package com.istudio.notes.feature_note.data.data_source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Index
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.istudio.notes.feature_note.domain.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    // <------------------------ CRUD - OPERATIONS ------------------------>

    /**
     * OPERATION: CREATE
     *
     * Getting all the notes from database
     */
    @Query("SELECT * FROM note")
    fun getNotes() : Flow<List<Note>>

    /**
     * OPERATION: READ
     *
     * Retrieving a note by it's ID
     */
    @Query("SELECT * FROM note WHERE id = :id")
    suspend fun getNoteById(id:Int) : Note?

    /**
     * OPERATION: UPDATE
     *
     * Inserting a note into a table, If a note exists with that ID, We replace it
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note:Note)

    /**
     *  OPERATION: DELETE
     *
     * Deleting a note from the table
     */
    @Delete
    suspend fun deleteNote(note: Note)


}