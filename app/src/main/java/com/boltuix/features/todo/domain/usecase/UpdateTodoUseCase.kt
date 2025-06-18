package com.boltuix.features.todo.domain.usecase

import com.boltuix.features.todo.data.repository.ToDoRepository
import com.boltuix.features.todo.domain.model.ToDoModel
import com.boltuix.features.todo.domain.model.toEntity
import javax.inject.Inject

/**
 * ✏️ **UpdateTodoUseCase**
 * - Converts `ToDoModel` → `ToDoEntity` before updating the database.
 */
class UpdateTodoUseCase @Inject constructor(
    private val repository: ToDoRepository
) {
    suspend operator fun invoke(todo: ToDoModel) {
        repository.update(todo.toEntity()) // ✅ Uses Mapper Function
    }
}
