package com.boltuix.composetodo.core.common.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.paging.compose.LazyPagingItems
import com.boltuix.features.todo.data.local.ToDoEntity
import com.boltuix.features.todo.domain.model.ToDoModel

/**
 * 📜 **Task List (Paginated)**
 *
 * A **LazyColumn** that efficiently displays a paginated list of tasks using **Paging3**.
 * This component handles a large number of tasks smoothly by **only loading items as needed**.
 *
 * ---
 *
 * 🔹 **Features:**
 * - 📦 Uses **Paging3's LazyPagingItems** for automatic pagination.
 * - 🎯 Displays each task using the **TaskItem** component.
 * - 📌 Supports **task interactions** such as click, delete, and checkbox toggle.
 *
 * ---
 *
 * @param todos 📄 **LazyPagingItems<ToDo>** - The paginated list of tasks.
 * @param onTaskClick 👆 **(ToDo) -> Unit** - Callback when a task is clicked.
 * @param onDeleteClick 🗑 **(ToDo) -> Unit** - Callback when the delete icon is clicked.
 * @param onCheckChange ✅ **(ToDo, Boolean) -> Unit** - Callback when a task is checked/unchecked.
 */
@Composable
fun TaskList(
    todos: LazyPagingItems<ToDoModel>,
    onTaskClick: (ToDoModel) -> Unit,
    onDeleteClick: (ToDoModel) -> Unit,
    onCheckChange: (ToDoModel, Boolean) -> Unit
) {
    LazyColumn {
        items(todos.itemCount) { index ->
            val todo = todos[index]
            if (todo != null) {
                TaskItem(todo, onTaskClick, onDeleteClick, onCheckChange,index)
            }
        }
    }
}

//..................................................................................................
/**
 * 📜 **Task List (Non-Paginated)**
 *
 * A **LazyColumn** that displays a simple list of tasks **without pagination**.
 * Ideal for cases where all tasks are loaded at once without using **Paging3**.
 *
 * ---
 *
 * 🔹 **Features:**
 * - 📝 Displays tasks from a `List<ToDo>` instead of `LazyPagingItems`.
 * - 🎯 Uses the **TaskItem** component for each task.
 * - 📌 Supports **task interactions** such as click, delete, and checkbox toggle.
 *
 * ---
 *
 * @param todos 📄 **List<ToDo>** - The full list of tasks.
 * @param onTaskClick 👆 **(ToDo) -> Unit** - Callback when a task is clicked.
 * @param onDeleteClick 🗑 **(ToDo) -> Unit** - Callback when the delete icon is clicked.
 * @param onCheckChange ✅ **(ToDo, Boolean) -> Unit** - Callback when a task is checked/unchecked.
 */
@Composable
fun TaskList(
    todos: List<ToDoModel>,
    onTaskClick: (ToDoModel) -> Unit,
    onDeleteClick: (ToDoModel) -> Unit,
    onCheckChange: (ToDoModel, Boolean) -> Unit
) {
    LazyColumn {
        items(todos.size) { index ->
            val todo = todos[index]
            TaskItem(todo, onTaskClick, onDeleteClick, onCheckChange, index)
        }
    }
}