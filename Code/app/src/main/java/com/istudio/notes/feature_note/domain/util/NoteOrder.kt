package com.istudio.notes.feature_note.domain.util

sealed class NoteOrder(val orderType: OrderType) {
    class Title(orderType: OrderType) : NoteOrder(orderType)
    class Date(orderType: OrderType) : NoteOrder(orderType)

    fun copy(orderType: OrderType) : NoteOrder {
        return when(orderType){
            is OrderType.Ascending -> Title(orderType)
            is OrderType.Descending -> Date(orderType)
        }
    }
}
