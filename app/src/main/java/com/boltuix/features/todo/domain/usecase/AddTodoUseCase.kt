package com.boltuix.features.todo.domain.usecase

import com.boltuix.features.todo.data.repository.ToDoRepository
import com.boltuix.features.todo.domain.model.ToDoModel
import com.boltuix.features.todo.domain.model.toEntity
import javax.inject.Inject

/**
 * 📜 **AddTodoUseCase**
 * - Converts `ToDoModel` → `ToDoEntity` before saving.
 */
class AddTodoUseCase @Inject constructor(
    private val repository: ToDoRepository
) {
    suspend operator fun invoke(todo: ToDoModel) {
        repository.insert(todo.toEntity()) // ✅ Uses Mapper Function
    }
}
