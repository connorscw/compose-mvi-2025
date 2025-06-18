package com.boltuix.features.todo.domain.usecase

import com.boltuix.features.todo.data.repository.ToDoRepository
import com.boltuix.features.todo.domain.model.ToDoModel
import com.boltuix.features.todo.domain.model.toDomainModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * 📜 **GetTodosUseCase**
 * - Fetches all tasks from the database.
 * - Converts `ToDoEntity` to `ToDoModel` using `toDomainModel()`.
 */
class GetTodosUseCase @Inject constructor(
    private val repository: ToDoRepository
) {
    operator fun invoke(): Flow<List<ToDoModel>> {
        return repository.getAllTodos().map { todos ->
            todos.map { it.toDomainModel() } // ✅ Using Mapper Function
        }
    }
}
