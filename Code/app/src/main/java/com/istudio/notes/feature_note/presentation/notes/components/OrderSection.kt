package com.istudio.notes.feature_note.presentation.notes.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.istudio.notes.R
import com.istudio.notes.feature_note.domain.util.NoteOrder
import com.istudio.notes.feature_note.domain.util.OrderType

@Composable
fun OrderSection(
    modifier:Modifier = Modifier,
    // Default order
    noteOrder:NoteOrder = NoteOrder.Date(OrderType.Descending),
    // On selection of order type
    onOrderChange : (NoteOrder) -> Unit
) {
    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            DefaultRadioButton(
                text = stringResource(id = R.string.str_title),
                // If the note order is of title, mark it selected
                selected = noteOrder is NoteOrder.Title,
                onSelect = {
                    onOrderChange(NoteOrder.Title(noteOrder.orderType))
                }
            )
            Spacer(modifier = Modifier.width(10.dp))
            DefaultRadioButton(
                text = stringResource(id = R.string.str_date),
                // If the note order is of title, mark it selected
                selected = noteOrder is NoteOrder.Date,
                onSelect = {
                    onOrderChange(NoteOrder.Date(noteOrder.orderType))
                }
            )
            Spacer(modifier = Modifier.width(15.dp))
        }

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            DefaultRadioButton(
                text = stringResource(id = R.string.str_ascending),
                // If the note order is of title, mark it selected
                selected = noteOrder.orderType is OrderType.Ascending,
                onSelect = {
                    onOrderChange(noteOrder.copy(OrderType.Ascending))
                }
            )
            Spacer(modifier = Modifier.width(10.dp))
            DefaultRadioButton(
                text = stringResource(id = R.string.str_descending),
                // If the note order is of title, mark it selected
                selected = noteOrder.orderType is OrderType.Descending,
                onSelect = {
                    onOrderChange(noteOrder.copy(OrderType.Descending))
                }
            )
        }
    }
}