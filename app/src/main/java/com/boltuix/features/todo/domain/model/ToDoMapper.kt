package com.boltuix.features.todo.domain.model

import com.boltuix.features.todo.data.local.ToDoEntity

/**
 * ✅ Converts **Database Model (`ToDoEntity`)** → **Domain Model (`ToDoModel`)**
 */
fun ToDoEntity.toDomainModel(): ToDoModel {
    return ToDoModel(
        id = this.id,
        title = this.title,
        isCompleted = this.isCompleted,
        createdTimeAt = this.createdTimeAt
    )
}

/**
 * ✅ Converts **Domain Model (`ToDoModel`)** → **Database Model (`ToDoEntity`)**
 */
fun ToDoModel.toEntity(): ToDoEntity {
    return ToDoEntity(
        id = this.id,
        title = this.title,
        isCompleted = this.isCompleted,
        createdTimeAt = this.createdTimeAt
    )
}
