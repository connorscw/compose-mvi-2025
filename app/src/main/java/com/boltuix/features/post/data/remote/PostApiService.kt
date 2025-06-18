package com.boltuix.features.post.data.remote

import com.boltuix.features.post.domain.model.PostModel
import retrofit2.http.GET

// Injected into PostRepository (Data Layer)
interface PostApiService {

    // 🌍 API endpoint to fetch posts
    @GET("posts")
    suspend fun getPosts(): List<PostModel> // 🔄 Makes a network request and returns a list of posts
}
