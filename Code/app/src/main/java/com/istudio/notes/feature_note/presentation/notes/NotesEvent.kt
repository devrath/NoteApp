package com.istudio.notes.feature_note.presentation.notes

import com.istudio.notes.feature_note.domain.model.Note
import com.istudio.notes.feature_note.domain.util.NoteOrder

/**
 * Represent note event where on user action, The user can perform certain operations
 */
sealed class NotesEvent {
    // Displaying a list in a certain order
    data class Order(val noteOrder: NoteOrder): NotesEvent()
    // Deleting the note from the screen
    data class DeleteNote(val note: Note): NotesEvent()
    // Performing the undo operation, when we press undo in the snack-bar
    object RestoreNote: NotesEvent()
    // Toggling the section that does the hide/show of the ordering
    object ToggleOrderSection: NotesEvent()
}
