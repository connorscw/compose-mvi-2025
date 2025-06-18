package com.boltuix.features.post.mvi

import com.boltuix.features.post.domain.model.PostModel

// 🎭 Represents different UI states for posts
sealed class PostState {

    // ⏳ UI is in loading state
    object Loading : PostState()

    // ✅ Posts loaded successfully
    data class Success(val posts: List<PostModel>) : PostState()

    // 🗑️ No posts available
    object Empty : PostState()

    // ❌ Error occurred, displays message
    data class Error(val message: String) : PostState()
}
