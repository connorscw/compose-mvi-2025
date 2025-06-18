package com.boltuix.features.post.domain.model

import com.boltuix.features.todo.data.local.ToDoEntity

// 📝 Data model representing a post
data class PostModel(
    val userId: Long, // 👤 ID of the user who created the post
    val id: Long, // 🆔 Unique ID of the post
    val title: String, // 🏷️ Title of the post
    val body: String, // ✍️ Content/body of the post
)

/**
 * ✅ Converts `PostModel` → `ToDoEntity` (Room Database Model)
 */
fun PostModel.toEntityNew(): ToDoEntity {
    return ToDoEntity(
        id = id.toInt(),
        title = title,
        isCompleted = false, // API may not provide `isCompleted`
        createdTimeAt = System.currentTimeMillis()
    )
}


