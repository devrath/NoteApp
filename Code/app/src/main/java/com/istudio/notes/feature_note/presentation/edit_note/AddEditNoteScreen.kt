package com.istudio.notes.feature_note.presentation.edit_note

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.istudio.notes.feature_note.presentation.edit_note.components.TransparentHintTextField
import kotlinx.coroutines.flow.collectLatest

@Composable
fun AddEditNoteScreen(
    navController: NavController,
    viewModel: AddEditNoteVm = hiltViewModel()
) {
    val titleState = viewModel.noteTitle.value
    val contentState = viewModel.noteContent.value

    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    /**
     * We used launched effect because we need to initiate the collect functionality of view model only once
     */
    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is UiEvent.SaveNote -> {
                    navController.navigateUp()
                }
                is UiEvent.ShowSnackbar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message
                    )
                }
            }
        }
    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    viewModel.onEvent(AddEditNoteEvent.SaveNote)
                },
                backgroundColor = MaterialTheme.colors.secondaryVariant
            ) {
                Icon(imageVector = Icons.Default.Done, contentDescription = "Save note")
            }
        },
        scaffoldState = scaffoldState
    ) {
       Box(
           modifier = Modifier.padding(it)
       ) {
           Column(
               modifier = Modifier
                   .fillMaxSize()
                   .background(MaterialTheme.colors.onSurface)
                   .padding(16.dp)
           ) {
               Spacer(modifier = Modifier.height(16.dp))
               TransparentHintTextField(
                   text = titleState.text,
                   hint = titleState.hint,
                   onValueChange = {
                       viewModel.onEvent(AddEditNoteEvent.EnteredTitle(it))
                   },
                   onFocusChange = {
                       viewModel.onEvent(AddEditNoteEvent.ChangeTitleFocus(it))
                   },
                   isHintVisible = titleState.isHintVisible,
                   singleLine = true,
                   textStyle = MaterialTheme.typography.h5
               )
               Spacer(modifier = Modifier.height(16.dp))
               TransparentHintTextField(
                   text = contentState.text,
                   hint = contentState.hint,
                   onValueChange = {
                       viewModel.onEvent(AddEditNoteEvent.EnteredContent(it))
                   },
                   onFocusChange = {
                       viewModel.onEvent(AddEditNoteEvent.ChangeContentFocus(it))
                   },
                   isHintVisible = contentState.isHintVisible,
                   textStyle = MaterialTheme.typography.body1,
                   modifier = Modifier.fillMaxHeight()
               )
           }
       }
    }
}