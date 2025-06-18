package com.boltuix.features.post.domain.model

import com.boltuix.features.todo.data.local.ToDoEntity

// Extension function to convert ToDoEntity → PostModel
fun ToDoEntity.toDomain(): PostModel {
    return PostModel(
        userId = 0L, // Default since ToDoEntity doesn't have userId
        id = this.id.toLong(),
        title = this.title,
        body = "" // Default since ToDoEntity doesn't have body
    )
}
