package com.boltuix.composetodo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.boltuix.composetodo.ui_theme.ComposeTodoTheme
import com.boltuix.features.post.presentation.screen.PostScreen
import com.boltuix.features.todo.presentation.screen.ToDoScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint // 💉 Enables Hilt for Dependency Injection
class MainActivity : ComponentActivity() {

    /**
     * 🎬 **onCreate Lifecycle Method**
     * - Initializes the **Compose UI** and applies the theme.
     *
     * @param savedInstanceState The saved instance state.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // 🖥 Enables full edge-to-edge display
        setContent {
            ComposeTodoTheme { // 🎨 Apply App Theme
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // 🔄 Apply padding dynamically
                    Modifier.padding(innerPadding)
                    // 📜 Load the main screen
                    PostScreen() // api call demo
                    // ToDoScreen() // todo room demo
                }
            }
        }
    }
}
