package com.boltuix.composetodo.core.common.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * ➕ **Floating Action Button (FAB) with Gradient** 🚀
 * - Uses **gradient background** for a dynamic look 🌈
 * - **Elevated** for a floating effect ☁️
 * - **Circular shape** with smooth touch feedback 🔘
 */
@Composable
fun FabButton(onClick: () -> Unit, contentDescription : String?="none") {
    IconButton(
        onClick = onClick,
        modifier = Modifier
            .size(56.dp)
            .shadow(8.dp, CircleShape) // ☁️ Smooth elevation
            .background(
                Brush.linearGradient(
                    colors = listOf(Color(0xFF11998e), Color(0xFF38ef7d)), // 🌿 Green gradient
                    start = Offset(0f, 0f),
                    end = Offset(100f, 100f)
                ),
                shape = CircleShape
            )
    ) {
        Icon(
            Icons.Rounded.Add,
            contentDescription = contentDescription,
            tint = Color.White // ⚪ High contrast for visibility
        )
    }
}

/**
 * 📱 **Light Mode Preview**
 * - Helps test FAB UI under normal conditions
 */
@Preview(name = "Light Mode", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun PreviewFabButtonLight() {
    FabButton(onClick = {})
}
