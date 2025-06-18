package com.boltuix.features.todo.data.remote


import retrofit2.http.GET

/**
 * ✅ Retrofit API Service for fetching ToDo tasks
 */
interface ToDoApiService {
    @GET("posts") // Replace this with your actual API endpoint
    suspend fun getTodos(): List<ToDoDto>
}
