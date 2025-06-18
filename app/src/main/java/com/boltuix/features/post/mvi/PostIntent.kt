package com.boltuix.features.post.mvi

// 🎭 Represents different user intents for posts
sealed class PostIntent {
    // 🔄 Load all posts
    object LoadPosts : PostIntent()
}
