package com.boltuix.composetodo.core.common.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.boltuix.features.todo.domain.model.ToDoModel

@Composable
fun TaskItem(
    todo: ToDoModel,
    onTaskClick: (ToDoModel) -> Unit,
    onDeleteClick: (ToDoModel) -> Unit,
    onCheckChange: (ToDoModel, Boolean) -> Unit,
    index: Int
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable { onTaskClick(todo) },
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = todo.title,
                modifier = Modifier.weight(1f),
                style = MaterialTheme.typography.bodyLarge
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                TaskCheckBox(todo = todo, onCheckChange = onCheckChange)
                Spacer(modifier = Modifier.width(12.dp))
                DeleteTaskIcon(todo = todo, onDeleteClick = onDeleteClick)
            }
        }
    }
}
