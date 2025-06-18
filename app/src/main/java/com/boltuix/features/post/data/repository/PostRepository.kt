package com.boltuix.features.post.data.repository

import com.boltuix.features.post.data.remote.PostApiService
import com.boltuix.features.post.domain.model.PostModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PostRepository @Inject constructor(
    private val apiService: PostApiService
) {

    fun getAllPosts(): Flow<List<PostModel>> = flow {
        val response = apiService.getPosts() // Call API
        emit(response) // Emit data as Flow
    }
}
