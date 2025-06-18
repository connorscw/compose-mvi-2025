package com.boltuix.composetodo.core.common.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ThumbUp
import androidx.compose.material.icons.rounded.ThumbDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import com.boltuix.features.todo.domain.model.ToDoModel

@Composable
fun TaskCheckBox(todo: ToDoModel, onCheckChange: (ToDoModel, Boolean) -> Unit) {
    var isChecked by remember { mutableStateOf(todo.isCompleted) }

    // 🌈 Smooth transition between checked/unchecked states
    val backgroundBrush by remember {
        derivedStateOf {
            Brush.horizontalGradient(
                colors = if (isChecked) listOf(Color(0xFF43A047), Color(0xFF66BB6A)) // ✅ Green when checked
                else listOf(Color(0xFFBDBDBD), Color(0xFFE0E0E0)) // ⬜ Gray when unchecked
            )
        }
    }

    Box(
        modifier = Modifier
            .size(40.dp) // 📏 Consistent size with other buttons
            .shadow(6.dp, CircleShape) // ☁️ Soft shadow for floating effect
            .background(backgroundBrush, CircleShape) // 🎨 Gradient background
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null, // 🚫 Remove ripple effect for a clean look
                role = Role.Checkbox
            ) {
                isChecked = !isChecked
                onCheckChange(todo, isChecked)
            },
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = if (isChecked) Icons.Rounded.ThumbUp else Icons.Rounded.ThumbDown,
            contentDescription = if (isChecked) "Checked" else "Unchecked",
            tint = Color.White // ⚪ High contrast for visibility
        )
    }
}

