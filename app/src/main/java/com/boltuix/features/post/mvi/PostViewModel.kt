package com.boltuix.features.post.mvi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.boltuix.features.post.domain.usecase.GetPostUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel // 💉 Enables Hilt Dependency Injection
class PostViewModel @Inject constructor(
    private val getPostsUseCase: GetPostUseCase, // 🔍 UseCase to fetch posts
) : ViewModel() {

    // 📊 StateFlow to hold UI state
    private val _state = MutableStateFlow<PostState>(PostState.Loading)
    val state: StateFlow<PostState> = _state.asStateFlow()

    private val _intent = MutableSharedFlow<PostIntent>() // 🎯 SharedFlow to handle user intents

    init {
        // 🔄 Start listening for user intents
        handleIntent()
        // 🚀 Load posts by default
        loadPosts()
    }

    // Handles user intents - Collects user actions and triggers corresponding methods.
    private fun handleIntent() {
        viewModelScope.launch {
            _intent.collect { intent ->
                when (intent) {
                    // 🔄 Reload posts when requested
                    is PostIntent.LoadPosts -> loadPosts()
                }
            }
        }
    }

    //  Fetch posts from the UseCase and update UI state
    private fun loadPosts() {
        viewModelScope.launch {
            getPostsUseCase().collect { posts ->
                // ✅ Update state based on posts
                _state.value = if (posts.isEmpty()) PostState.Empty else PostState.Success(posts)
            }
        }
    }
}