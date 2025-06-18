package com.boltuix.features.todo.domain.usecase

import com.boltuix.features.todo.data.repository.ToDoRepository
import javax.inject.Inject

/**
 * ✅ Fetches tasks from API and stores them in Room database
 */
class FetchAndStoreTodosUseCase @Inject constructor(
    private val repository: ToDoRepository
) {
    suspend operator fun invoke() {
        repository.fetchAndStoreTodos()
    }
}
