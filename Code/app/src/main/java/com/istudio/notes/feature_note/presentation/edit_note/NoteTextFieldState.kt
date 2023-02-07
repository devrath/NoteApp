package com.istudio.notes.feature_note.presentation.edit_note

data class NoteTextFieldState(
    val text: String = "",
    val hint: String = "",
    val isHintVisible: Boolean = true
)