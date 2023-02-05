package com.istudio.notes.feature_note.domain.respository

import com.istudio.notes.feature_note.domain.model.Note
import kotlinx.coroutines.flow.Flow

/**
 * This is useful because we can create fake versions of the repository for testing
 * We can pass fake repository to use cases for testing so that use cases won't know where the data is coming from
 * Say its from a real repository or a local json file, They just get data and do something from it
 */
interface NoteRepository {
    fun getNotes() : Flow<List<Note>>
    suspend fun getNoteById(id:Int) : Note?
    suspend fun insertNote(note : Note)
    suspend fun deleteNote(note : Note)
}