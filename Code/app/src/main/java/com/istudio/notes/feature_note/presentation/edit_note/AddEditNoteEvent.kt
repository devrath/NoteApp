package com.istudio.notes.feature_note.presentation.edit_note

import androidx.compose.ui.focus.FocusState

sealed class AddEditNoteEvent {

    data class EnteredTitle(val value:String) : AddEditNoteEvent()
    data class EnteredContent(val value:String) : AddEditNoteEvent()
    data class ChangeTitleFocus(val focusState: FocusState) : AddEditNoteEvent()
    data class ChangeContentFocus(val focusState: FocusState) : AddEditNoteEvent()
    object SaveNote: AddEditNoteEvent()

}
