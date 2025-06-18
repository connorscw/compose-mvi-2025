package com.boltuix.composetodo.core.common.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * 📌 A reusable centered loader with a green progress indicator.
 *
 * ✅ **Features:**
 * - 🎯 **Centered**: Always appears in the middle of the screen.
 * - 🟢 **Green Color**: Uses `Color.Green` for visibility.
 * - 🔄 **Smooth Animation**: Works seamlessly with Compose.
 *
 * 🚀 **Usage:**
 * ```
 * LoadingIndicator()
 * ```
 */
@Composable
fun LoadingIndicator() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            color = Color.Green, // ✅ Green loader
            strokeWidth = 6.dp // ✅ Slightly thicker for better visibility
        )
    }
}
