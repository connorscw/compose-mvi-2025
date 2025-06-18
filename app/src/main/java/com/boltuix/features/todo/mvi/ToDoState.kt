package com.boltuix.features.todo.mvi

import com.boltuix.features.todo.domain.model.ToDoModel

sealed class ToDoState {
    object Loading : ToDoState() // ⏳ UI is in loading state
    data class Success(val tasks: List<ToDoModel>) : ToDoState() // ✅ Tasks loaded successfully
    object Empty : ToDoState() // 🗑️ No tasks available
    data class Error(val message: String) : ToDoState() // ❌ Error state
}
