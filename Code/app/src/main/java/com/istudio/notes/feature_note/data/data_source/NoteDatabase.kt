package com.istudio.notes.feature_note.data.data_source

import android.database.sqlite.SQLiteDatabase
import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Note::class],
    version = 1
)
abstract class NoteDatabase : RoomDatabase(){

    abstract val noteDao: NoteDao

}