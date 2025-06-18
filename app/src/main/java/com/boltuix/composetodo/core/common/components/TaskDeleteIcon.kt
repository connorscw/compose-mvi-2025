package com.boltuix.composetodo.core.common.components

import android.content.res.Configuration
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.boltuix.features.todo.domain.model.ToDoModel
import kotlinx.coroutines.flow.collectLatest

/**
 * 🗑 **Enhanced Delete Icon with Dynamic Effects**
 * - Uses an **elevated circular button**
 * - Features **animated hover & press effects**
 * - Improves **touch feedback and accessibility**
 */
@Composable
fun DeleteTaskIcon(todo: ToDoModel, onDeleteClick: (ToDoModel) -> Unit) {
    val interactionSource = remember { MutableInteractionSource() }
    var isPressed by remember { mutableStateOf(false) }

    // Listen for press interactions (for hover & touch feedback)
    LaunchedEffect(interactionSource) {
        interactionSource.interactions.collectLatest { interaction ->
            isPressed = interaction is PressInteraction.Press
        }
    }

    // 🎨 Smooth color animation for press effect
    val buttonColor by animateColorAsState(
        targetValue = if (isPressed) Color(0xFFFF5252) else Color(0xFFFF1744),
        label = "Delete Button Color"
    )

    IconButton(
        onClick = { onDeleteClick(todo) },
        modifier = Modifier
            .size(45.dp) // 🔘 Slightly larger touch area
            .shadow(6.dp, CircleShape) // ☁️ Soft elevation
            .background(buttonColor, CircleShape), // 🎨 Animated color change
        interactionSource = interactionSource
    ) {
        Icon(
            Icons.Rounded.Delete,
            contentDescription = "Delete Task",
            tint = Color.White // ⚪ High contrast for visibility
        )
    }
}
