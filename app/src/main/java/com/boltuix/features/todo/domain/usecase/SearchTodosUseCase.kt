package com.boltuix.features.todo.domain.usecase

import com.boltuix.features.todo.data.repository.ToDoRepository
import com.boltuix.features.todo.domain.model.ToDoModel
import com.boltuix.features.todo.domain.model.toDomainModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * 🔍 **SearchTodosUseCase**
 * - Fetches tasks from the database.
 * - Filters tasks by title (case-insensitive).
 * - Converts `ToDoEntity` to `ToDoModel` using `toDomainModel()`.
 */
class SearchTodosUseCase @Inject constructor(
    private val repository: ToDoRepository
) {
    operator fun invoke(query: String): Flow<List<ToDoModel>> {
        return repository.getAllTodos().map { todos ->
            todos.map { it.toDomainModel() } // ✅ Convert database model to domain model
                .filter { it.title.contains(query, ignoreCase = true) } // ✅ Case-insensitive filtering
        }
    }
}
