package com.istudio.notes.feature_note.presentation.notes

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.istudio.notes.feature_note.domain.model.Note
import com.istudio.notes.feature_note.domain.use_case.NoteUseCases
import com.istudio.notes.feature_note.domain.util.NoteOrder
import com.istudio.notes.feature_note.domain.util.OrderType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    // With this wrapper class, we can access all the use-cases for our notes feature
    private val noteUseCases: NoteUseCases
) : ViewModel(){

    // This will be hte state that the UI will observe
    private val _state = mutableStateOf(NotesState())
    val state: State<NotesState> = _state

    private var recentlyDeletedNote : Note? = null

    private var getNotesJob: Job? = null

    init {
        getNotes(NoteOrder.Date(OrderType.Descending))
    }

    // We have one state UI-class that represents the current state of UI screen
    fun onEvent(event: NotesEvent) {
        when(event){
            is NotesEvent.DeleteNote -> {
                viewModelScope.launch {
                    noteUseCases.deleteNotesUseCase(event.note)
                    // Saving the reference of the note so that it can be restored later
                    recentlyDeletedNote = event.note
                }
            }
            is NotesEvent.Order -> {
                if (state.value.noteOrder::class == event.noteOrder::class &&
                    state.value.noteOrder.orderType == event.noteOrder.orderType
                ) {
                    return
                }
                getNotes(event.noteOrder)
            }
            is NotesEvent.RestoreNote -> {
                viewModelScope.launch {
                    noteUseCases.addNotesUseCase(recentlyDeletedNote ?: return@launch)
                    recentlyDeletedNote = null
                }
            }
            is NotesEvent.ToggleOrderSection -> {
                _state.value = _state.value.copy(
                    isOrderSectionVisible = !state.value.isOrderSectionVisible
                )
            }
        }
    }


    private fun getNotes(noteOrder: NoteOrder) {
       getNotesJob?.cancel()
       getNotesJob = noteUseCases.getNotesUseCase(noteOrder)
           .onEach {notes ->
               _state.value = state.value.copy(
                   notes = notes,
                   noteOrder = noteOrder
               )
           }
           .launchIn(viewModelScope)
    }


}