package com.boltuix.features.todo.data.remote

import com.boltuix.features.todo.data.local.ToDoEntity

/**
 * ✅ API DTO (Data Transfer Object)
 */
data class ToDoDto(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String // Assuming API provides `body` instead of `description`
)

/**
 * ✅ Converts `ToDoDto` → `ToDoEntity` (Room Database Model)
 */
fun ToDoDto.toEntity(): ToDoEntity {
    return ToDoEntity(
        id = id,
        title = title,
        isCompleted = false, // API may not provide `isCompleted`
        createdTimeAt = System.currentTimeMillis()
    )
}
