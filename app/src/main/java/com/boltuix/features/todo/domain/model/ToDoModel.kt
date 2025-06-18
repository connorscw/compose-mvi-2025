package com.boltuix.features.todo.domain.model

data class ToDoModel(
    val id: Int = 0,
    val title: String,
    val isCompleted: Boolean = false,
    val createdTimeAt: Long = System.currentTimeMillis()
)
