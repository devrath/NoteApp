package com.istudio.notes.feature_note.presentation.edit_note

sealed class UiEvent {
    data class ShowSnackbar(val message: String): UiEvent()
    object SaveNote : UiEvent()
}
