package com.istudio.notes.di

import android.app.Application
import androidx.room.Room
import com.istudio.notes.feature_note.data.data_source.NoteDatabase
import com.istudio.notes.feature_note.data.repository.NoteRepositoryImpl
import com.istudio.notes.feature_note.domain.respository.NoteRepository
import com.istudio.notes.feature_note.domain.use_case.AddNoteUseCase
import com.istudio.notes.feature_note.domain.use_case.DeleteNotesUseCase
import com.istudio.notes.feature_note.domain.use_case.GetNotesUseCase
import com.istudio.notes.feature_note.domain.use_case.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    /**
     * Create a singleton instance of Use-Cases data object instance
     * This uses the note-repository interface class from the constructor
     */
    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotesUseCase = GetNotesUseCase(repository),
            deleteNotesUseCase = DeleteNotesUseCase(repository),
            addNotesUseCase = AddNoteUseCase(repository)
        )
    }

    /**
     * Create the implementation of noteRepository that returns a NoteRepository interface mapped
     * This accepts the note-database reference in the constructor
     */
    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }

    /**
     * Create a singleton instance of database
     */
    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

}