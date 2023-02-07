package com.istudio.notes.feature_note.presentation.edit_note

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.istudio.notes.feature_note.domain.model.InvalidNoteException
import com.istudio.notes.feature_note.domain.model.Note
import com.istudio.notes.feature_note.domain.use_case.NoteUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddEditNoteVm @Inject constructor(
    private val noteUseCases: NoteUseCases,
    savedStateHandle: SavedStateHandle
) : ViewModel(){

    private var currentNoteId: Int? = null

    /**  ****************************** We track the input states *****************************  **/
    private val _noteTitle = mutableStateOf(NoteTextFieldState(hint = "Enter title .."))
    val noteTitle : State<NoteTextFieldState> = _noteTitle

    private val _noteContent = mutableStateOf(NoteTextFieldState(hint = "Enter ome content .."))
    val noteContent : State<NoteTextFieldState> = _noteContent
    /**  ****************************** We track the input states *****************************  **/

    /**  ************************* We notify the UI action for a result ***********************  **/
    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()
    /**  ************************* We notify the UI action for a result ***********************  **/

    /**  ************************* Composable communicate to view model ***********************  **/
    fun onEvent(event: AddEditNoteEvent) {
        when(event){
            is AddEditNoteEvent.ChangeContentFocus -> changeContentFocus(event)
            is AddEditNoteEvent.ChangeTitleFocus -> changeTitleFocus(event)
            is AddEditNoteEvent.EnteredContent -> enteredContent(event)
            is AddEditNoteEvent.EnteredTitle -> enteredTitle(event)
            is AddEditNoteEvent.SaveNote -> saveNote(event)
        }
    }
    /**  ****************************** We track the input states *****************************  **/

    init {
        savedStateHandle.get<Int>("noteId")?.let { noteId ->
            if(noteId != -1) {
                viewModelScope.launch {
                    noteUseCases.getNoteUseCase(noteId)?.also { note ->
                        currentNoteId = note.id
                        _noteTitle.value = noteTitle.value.copy(
                            text = note.title,
                            isHintVisible = false
                        )
                        _noteContent.value = _noteContent.value.copy(
                            text = note.content,
                            isHintVisible = false
                        )
                    }
                }
            }
        }
    }

    /**  ***************************** Composable event definitions ****************************  **/
    /**
     * When we are not focused on the text and title is blank, we show our hint
     */
    private fun changeContentFocus(event: AddEditNoteEvent.ChangeContentFocus) {
        _noteContent.value = noteContent.value.copy(
            isHintVisible = !event.focusState.isFocused && noteTitle.value.text.isBlank()
        )
    }

    /**
     * When we are not focused on the text and description is blank, we show our hint
     */
    private fun changeTitleFocus(event: AddEditNoteEvent.ChangeTitleFocus) {
        _noteTitle.value = noteTitle.value.copy(
            isHintVisible = !event.focusState.isFocused && noteTitle.value.text.isBlank()
        )
    }

    /**
     * We update the new content to the content composable
     */
    private fun enteredContent(event: AddEditNoteEvent.EnteredContent) {
        _noteContent.value = noteContent.value.copy(text = event.value)
    }

    /**
     *  We update the new content to the title composable
     */
    private fun enteredTitle(event: AddEditNoteEvent.EnteredTitle) {
        _noteTitle.value = noteTitle.value.copy(text = event.value)
    }

    private fun saveNote(event: AddEditNoteEvent.SaveNote) {
        viewModelScope.launch {
            try {
                noteUseCases.addNotesUseCase(
                    Note(
                        title = noteTitle.value.text,
                        content = noteContent.value.text,
                        timestamp = System.currentTimeMillis(),
                        id = currentNoteId
                    )
                )
                _eventFlow.emit(UiEvent.SaveNote)
            } catch(e: InvalidNoteException) {
                _eventFlow.emit(
                    UiEvent.ShowSnackbar(
                        message = e.message ?: "Couldn't save note"
                    )
                )
            }
        }
    }
    /**  ***************************** Composable event definitions ****************************  **/


}