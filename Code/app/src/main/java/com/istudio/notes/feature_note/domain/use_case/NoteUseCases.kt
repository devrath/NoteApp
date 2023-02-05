package com.istudio.notes.feature_note.domain.use_case

/**
 * This will be the class we inject into the view model
 * This gives the advantage that say if our view-model has lot of use cases, this becomes the problem of constructor becoming large
 * By wrapping all constructors into a single data class, we can keep the implementation cleaner.
 */
data class NoteUseCases(
    val getNotesUseCase : GetNotesUseCase,
    val deleteNotesUseCase : DeleteNotesUseCase,
    val addNotesUseCase : AddNoteUseCase
)
