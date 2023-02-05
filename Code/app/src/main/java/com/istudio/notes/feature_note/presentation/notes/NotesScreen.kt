package com.istudio.notes.feature_note.presentation.notes

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarResult
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.istudio.notes.R
import com.istudio.notes.feature_note.presentation.notes.components.NoteItem
import com.istudio.notes.feature_note.presentation.notes.components.OrderSection
import kotlinx.coroutines.launch

@Composable
fun NotesScreen(
    navController: NavController,
    viewModel: NotesViewModel = hiltViewModel()
) {

    val state = viewModel.state.value
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {

                },
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = stringResource(id = R.string.str_add_note)
                )
            }
        },
        scaffoldState = scaffoldState
    ) { padding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(id = R.string.str_your_note),
                        style = MaterialTheme.typography.h4
                    )
                    IconButton(onClick = {
                        viewModel.onEvent(NotesEvent.ToggleOrderSection)
                    }) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = stringResource(id = R.string.str_sort)
                        )
                    }
                    AnimatedVisibility(
                        visible = state.isOrderSectionVisible,
                        enter = fadeIn() + slideInVertically(),
                        exit = fadeOut() + slideOutVertically()
                    ) {
                        OrderSection(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 16.dp),
                            noteOrder = state.noteOrder,
                            onOrderChange = {
                                viewModel.onEvent(NotesEvent.Order(it))
                            }
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))
                    val msg = stringResource(id = R.string.str_note_deleted)
                    val undo = stringResource(id = R.string.str_undo)
                    LazyColumn(modifier = Modifier.fillMaxSize()) {
                        itemsIndexed(state.notes) { index, item ->
                            NoteItem(
                                note = item,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable {
                                        /* navController.navigate(
                                             Screen.AddEditNoteScreen.route +
                                                 "?noteId=${note.id}&noteColor=${note.color}"
                                         )*/
                                    },
                                onDeleteClick = {
                                    viewModel.onEvent(NotesEvent.DeleteNote(item))
                                    scope.launch {
                                        val result = scaffoldState.snackbarHostState.showSnackbar(
                                            message = msg, actionLabel = undo
                                        )
                                        if (result == SnackbarResult.ActionPerformed) {
                                            viewModel.onEvent(NotesEvent.RestoreNote)
                                        }
                                    }
                                }
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                        }
                    }
                }
            }
        }
    }
}