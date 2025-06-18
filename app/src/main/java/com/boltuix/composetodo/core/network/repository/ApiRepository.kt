package com.boltuix.composetodo.core.network.repository

import com.boltuix.composetodo.core.network.api.ApiService
import com.boltuix.features.todo.data.local.ToDoDao
import com.boltuix.features.todo.data.remote.toEntity
import javax.inject.Inject

/**
 * ✅ Handles API fetching and Room database caching
 */
class ApiRepository @Inject constructor(
    private val api: ApiService,
    private val dao: ToDoDao
) {
    suspend fun fetchAndStoreTasks() {
        val tasks = api.getPosts().map { it.toEntity() }
        dao.insertAll(tasks)
    }
}
