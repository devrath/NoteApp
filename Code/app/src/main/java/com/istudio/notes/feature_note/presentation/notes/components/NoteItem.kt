package com.istudio.notes.feature_note.presentation.notes.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.istudio.notes.R
import com.istudio.notes.feature_note.domain.model.Note

@Composable
fun NoteItem(
    note: Note,
    modifier: Modifier = Modifier,
    cornerRadius : Dp = 10.dp
) {

    Box(
        modifier = modifier
            .clip(shape = RoundedCornerShape(cornerRadius))
            .background(MaterialTheme.colors.background)
            .fillMaxWidth()
            .height(210.dp)
            .padding(10.dp)
    ) {
        Row(
            modifier = modifier.fillMaxWidth()
        ) {

            Column(
                modifier = modifier.weight(1F, fill = true),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    modifier = modifier.padding(bottom = 5.dp),
                    text = note.title,
                    style = MaterialTheme.typography.h6,
                    color = MaterialTheme.colors.onSurface,
                    maxLines = 1
                )
                Text(
                    text = note.content,
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.onSurface,
                    maxLines = 8,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Column(
                modifier = modifier.fillMaxHeight().padding(start = 10.dp),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.Start
            ) {

                Image(
                    painter = painterResource(id = R.drawable.ic_delete),
                    contentDescription = stringResource(id = R.string.str_delete)
                )
            }

        }
    }

}


@Preview
@Composable
private fun CurrentScreen() {
    NoteItem(
        note = Note(
            id = 1 , title = "Title" ,
            content = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
            timestamp = 20
        )
    )
}

