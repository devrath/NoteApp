package com.istudio.notes.feature_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.istudio.notes.ui.theme.BabyBlue
import com.istudio.notes.ui.theme.LightGreen
import com.istudio.notes.ui.theme.RedOrange
import com.istudio.notes.ui.theme.RedPink
import com.istudio.notes.ui.theme.Violet

@Entity
data class Note(
    @PrimaryKey val id : Int? = null,
    val title : String,
    val content : String,
    val timestamp : Long,
    val color : Int,
){
    companion object{
        val noteColors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }
}

class InvalidNoteException(message: String): Exception(message)
