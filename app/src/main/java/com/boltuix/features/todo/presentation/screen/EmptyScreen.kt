package com.boltuix.features.todo.presentation.screen

import android.content.res.Configuration
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.boltuix.composetodo.R

@Composable
fun EmptyScreen(onAddTaskClick: () -> Unit) {
    val configuration = LocalConfiguration.current
    val isPortrait = configuration.orientation == Configuration.ORIENTATION_PORTRAIT

    if (isPortrait) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AnimatedImage()
            TitleAndDescription()
            AddTaskButton(onAddTaskClick)
        }
    } else {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            AnimatedImage()
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TitleAndDescription()
                AddTaskButton(onAddTaskClick)
            }
        }
    }
}

/**
 * 🖼 **Animated Image with One-Time Zoom Effect**
 */
@Composable
fun AnimatedImage() {
    var isAnimated by remember { mutableStateOf(false) }

    // One-time animation from 0.5x to 1.0x scale
    val scale by animateFloatAsState(
        targetValue = if (isAnimated) 1.0f else 0.5f,
        animationSpec = tween(durationMillis = 1000, easing = FastOutSlowInEasing),
        label = ""
    )

    // Start animation on first composition
    LaunchedEffect(Unit) {
        isAnimated = true
    }

    Image(
        painter = painterResource(id = R.drawable.empty_state_todo),
        contentDescription = "No To-Dos",
        modifier = Modifier
            .size(190.dp)
            .graphicsLayer(scaleX = scale, scaleY = scale)
    )
}

/**
 * 📄 **Title & Description Text**
 */
@Composable
fun TitleAndDescription() {
    Text(
        text = "No To-Do Items",
        fontSize = 22.sp,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
        modifier = Modifier.padding(top = 20.dp)
    )

    Text(
        text = "No tasks available. Tap below to add one!",
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
    )
}

/**
 * ➕ **Floating Action Button with Gradient**
 */
@Composable
fun AddTaskButton(onAddTaskClick: () -> Unit) {
    Box(
        modifier = Modifier
            .padding(top = 30.dp)
            .width(160.dp)
            .background(
                Brush.linearGradient(
                    colors = listOf(Color(0xFF11998e), Color(0xFF38ef7d))
                ),
                shape = CircleShape
            )
    ) {
        FloatingActionButton(
            onClick = { onAddTaskClick() },
            containerColor = Color.Transparent,
            shape = CircleShape,
            modifier = Modifier.fillMaxWidth(),
            elevation = FloatingActionButtonDefaults.elevation(0.dp)
        ) {
            Text(
                text = "Add a Task",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}

/**
 * 🖼️ **Preview** - Displays `EmptyScreen` in Android Studio.
 */
@Preview(showBackground = true, name = "Portrait Mode")
@Composable
fun PreviewEmptyScreenPortrait() {
    EmptyScreen(onAddTaskClick = {})
}

@Preview(showBackground = true, widthDp = 700, heightDp = 400, name = "Landscape Mode")
@Composable
fun PreviewEmptyScreenLandscape() {
    EmptyScreen(onAddTaskClick = {})
}
