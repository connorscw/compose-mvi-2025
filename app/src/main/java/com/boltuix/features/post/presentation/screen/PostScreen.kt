package com.boltuix.features.post.presentation.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.boltuix.features.post.mvi.PostState
import com.boltuix.features.post.mvi.PostViewModel
@Composable
fun PostScreen(
    viewModel: PostViewModel = hiltViewModel() // 🔥 Injecting ViewModel using Hilt
) {
    // 🔄 UI State Management
    val state by viewModel.state.collectAsState()

    Scaffold(
    ) { paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues).padding(16.dp), // 🎨 Adding padding for better UI
            verticalArrangement = Arrangement.Center, // ⬇ Center content vertically
            horizontalAlignment = Alignment.CenterHorizontally // ⬅➡ Center content horizontally
        ) {
            when (state) {
                is PostState.Loading -> {
                    Text(
                        text = "Loading posts... ⏳",
                        style = MaterialTheme.typography.bodyMedium
                    ) // 🚀 Show loading state
                }
                is PostState.Success -> {
                    val posts = (state as PostState.Success).posts // ✅ Fetching posts
                    Text(
                        text = "✅ Posts Loaded Successfully! : Size : ${posts.size}",
                        style = MaterialTheme.typography.headlineMedium,
                        color = MaterialTheme.colorScheme.primary
                    ) // 🎉 Success state UI
                }
                is PostState.Empty -> {
                    Text(
                        text = "No posts available. Try adding some! 📝",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.secondary
                    ) // ➖ Empty state message
                }
                is PostState.Error -> {
                    Text(
                        text = "Error: ${(state as PostState.Error).message} ❌",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.error
                    ) // ⚠ Error state message
                }
            }
        }
    }
}
