package com.boltuix.composetodo.core.network.api

import com.boltuix.features.todo.data.remote.ToDoDto
import retrofit2.http.GET

/**
 * ✅ Retrofit API Service for fetching tasks
 */
interface ApiService {
    @GET("posts")
    suspend fun getPosts(): List<ToDoDto>
}
