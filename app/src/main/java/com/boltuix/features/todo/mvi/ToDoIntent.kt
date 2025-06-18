package com.boltuix.features.todo.mvi

import com.boltuix.features.todo.domain.model.ToDoModel

sealed class ToDoIntent {
    data class AddTask(val task: ToDoModel) : ToDoIntent()
    data class UpdateTask(val task: ToDoModel) : ToDoIntent()
    data class DeleteTask(val task: ToDoModel) : ToDoIntent()
    data class SearchTask(val query: String) : ToDoIntent()
    object LoadTasks : ToDoIntent() // Load all tasks
}
