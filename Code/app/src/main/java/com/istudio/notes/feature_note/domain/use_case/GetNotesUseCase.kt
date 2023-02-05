package com.istudio.notes.feature_note.domain.use_case

import com.istudio.notes.feature_note.domain.model.Note
import com.istudio.notes.feature_note.domain.respository.NoteRepository
import com.istudio.notes.feature_note.domain.util.NoteOrder
import com.istudio.notes.feature_note.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.annotation.meta.When

class GetNotesUseCase(
    private val repository: NoteRepository
) {

    /**
     * Using the invoke function lets the class to be called as a function
     */
    operator fun invoke(
        noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending)
    ) : Flow<List<Note>> {
        /**
         * We get the list from the repository
         * We then map into a new list
         */
        return repository.getNotes().map { notes ->
            when(noteOrder.orderType){
                is OrderType.Ascending -> {
                    when(noteOrder) {
                        is NoteOrder.Title -> notes.sortedBy { it.title.lowercase() }
                        is NoteOrder.Date -> notes.sortedBy { it.timestamp }
                    }
                }
                is OrderType.Descending -> {
                    when(noteOrder) {
                        is NoteOrder.Title -> notes.sortedByDescending { it.title.lowercase() }
                        is NoteOrder.Date -> notes.sortedByDescending { it.timestamp }
                    }
                }
            }
        }
    }

}