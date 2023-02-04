package com.istudio.notes.feature_note.data.data_source

import androidx.room.Dao
import androidx.room.Query
import com.istudio.notes.feature_note.domain.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Query(value = "SELECT * FROM note")
    fun getNotes() : Flow<List<Note>>


}