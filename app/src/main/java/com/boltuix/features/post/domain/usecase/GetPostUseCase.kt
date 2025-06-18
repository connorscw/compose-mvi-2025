package com.boltuix.features.post.domain.usecase

import com.boltuix.features.post.data.repository.PostRepository
import com.boltuix.features.post.domain.model.PostModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

// Fetches all posts from the repository & Returns a **Flow** of a list of `PostModel`
class GetPostUseCase @Inject constructor(
    private val repository: PostRepository // 🏦 Repository to fetch data
) {
    /**
     * 🚀 **Invoke operator function**
     * - Calls `getAllPosts()` from the repository.
     * - Returns a **Flow** of posts.
     */
    operator fun invoke(): Flow<List<PostModel>> {
        // 🔄 Fetch and stream posts as Flow
        return repository.getAllPosts()
    }
}
