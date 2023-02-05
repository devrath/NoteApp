package com.istudio.notes.feature_note.presentation.notes

import com.istudio.notes.feature_note.domain.model.Note
import com.istudio.notes.feature_note.domain.util.NoteOrder
import com.istudio.notes.feature_note.domain.util.OrderType

/**
 * Represent the state that is sent from view-model into view
 */
data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)
