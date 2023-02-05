package com.istudio.notes.feature_note.domain.use_case

import com.istudio.notes.feature_note.domain.model.Note
import com.istudio.notes.feature_note.domain.respository.NoteRepository

class GetNoteUseCase(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(id:Int) : Note? {
        return repository.getNoteById(id)
    }

}