package com.boltuix.features.todo.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import com.boltuix.composetodo.core.common.components.FabButton
import com.boltuix.composetodo.core.common.components.LoadingIndicator
import com.boltuix.composetodo.core.common.components.SearchBar
import com.boltuix.composetodo.core.common.components.TaskList
import com.boltuix.features.todo.mvi.ToDoViewModel
import com.boltuix.features.todo.mvi.ToDoIntent
import com.boltuix.features.todo.mvi.ToDoState
import com.boltuix.composetodo.core.common.dialog.CustomDialogUI
import com.boltuix.composetodo.ui_theme.DarkGradient
import com.boltuix.composetodo.ui_theme.LightGradient
import com.boltuix.features.todo.domain.model.ToDoModel

@Composable
fun ToDoScreen(
    viewModel: ToDoViewModel = hiltViewModel()
) {
    // UI State Management
    val state by viewModel.state.collectAsState()

    // Hoisted UI states
    var showDialog by remember { mutableStateOf(false) }
    var selectedTask by remember { mutableStateOf<ToDoModel?>(null) }
    var taskText by remember { mutableStateOf("") }
    var searchText by remember { mutableStateOf("") }

    Scaffold(
        floatingActionButton = {
            FabButton(
                onClick = {
                    selectedTask = null
                    taskText = ""
                    showDialog = true
                },
                contentDescription = "Add new task"
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(if (isSystemInDarkTheme()) DarkGradient else LightGradient)
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            // Search Bar
            SearchBar(
                searchText = searchText,
                onSearchChange = { newText ->
                    searchText = newText
                    viewModel.sendIntent(ToDoIntent.SearchTask(newText))
                }
            )

            // Observe ViewModel State and React Accordingly
            when (state) {
                is ToDoState.Loading -> {
                    LoadingIndicator()
                }
                is ToDoState.Success -> {
                    TaskList(
                        todos = (state as ToDoState.Success).tasks,
                        onTaskClick = { todo ->
                            selectedTask = todo
                            taskText = todo.title
                            showDialog = true
                        },
                        onDeleteClick = { task ->
                            viewModel.sendIntent(ToDoIntent.DeleteTask(task))
                        },
                        onCheckChange = { todo, isChecked ->
                            viewModel.sendIntent(ToDoIntent.UpdateTask(todo.copy(isCompleted = isChecked)))
                        }
                    )
                }
                is ToDoState.Empty -> {
                    EmptyScreen(
                        onAddTaskClick = {
                            selectedTask = null
                            taskText = ""
                            showDialog = true
                        }
                    )
                }
                is ToDoState.Error -> {
                    Text(
                        text = "Error: ${(state as ToDoState.Error).message}",
                        color = MaterialTheme.colorScheme.error
                    )
                }
            }
        }
    }

    // Custom Dialog for Adding/Updating Tasks
    if (showDialog) {
        Dialog(onDismissRequest = { showDialog = false }) {
            CustomDialogUI(
                textValue = taskText,
                onTextChange = { newText -> taskText = newText },
                onDismiss = { showDialog = false },
                onConfirm = {
                    if (taskText.isNotBlank()) {
                        if (selectedTask == null) {
                            viewModel.sendIntent(ToDoIntent.AddTask(ToDoModel(title = taskText)))
                        } else {
                            viewModel.sendIntent(
                                ToDoIntent.UpdateTask(
                                    selectedTask!!.copy(title = taskText)
                                )
                            )
                        }
                    }
                    showDialog = false
                },
                isEditing = selectedTask != null
            )
        }
    }
}
