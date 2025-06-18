package com.boltuix.features.todo.domain.usecase

import com.boltuix.features.todo.data.repository.ToDoRepository
import com.boltuix.features.todo.domain.model.ToDoModel
import com.boltuix.features.todo.domain.model.toEntity
import javax.inject.Inject

/**
 * 🗑 **DeleteTodoUseCase**
 * - Converts `ToDoModel` → `ToDoEntity` before deletion.
 */
class DeleteTodoUseCase @Inject constructor(
    private val repository: ToDoRepository
) {
    suspend operator fun invoke(todo: ToDoModel) {
        repository.delete(todo.toEntity()) // ✅ Uses Mapper Function
    }
}
