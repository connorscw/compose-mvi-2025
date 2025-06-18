package com.boltuix.composetodo.core.common.dialog

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.boltuix.composetodo.R
import com.boltuix.composetodo.ui_theme.GreenBackground
import com.boltuix.composetodo.ui_theme.GreenPrimary
import com.boltuix.composetodo.ui_theme.GreenSecondary

/**
 * 🌟 **Custom Dialog UI** - A stylish pop-up dialog for adding or editing tasks! 📝
 *
 * This dialog provides an elegant **Outlined Text Field** for user input,
 * along with customizable **confirm** and **cancel** actions.
 *
 * ---
 *
 * 🔹 **Features:**
 * - 🎨 Beautiful Material3 design with rounded corners.
 * - 🖼️ Includes a header image for better UI presentation.
 * - ✍️ Editable `OutlinedTextField` for task input.
 * - 🎭 Supports **light & dark mode** dynamically.
 * - 🎨 Themed with green colors for a fresh, modern look.
 *
 * ---
 *
 * @param textValue ✏️ The current text entered by the user.
 * @param onTextChange 🔄 Callback for when text changes.
 * @param onDismiss ❌ Callback to close the dialog.
 * @param onConfirm ✅ Callback to confirm the task.
 * @param isEditing ✏️ `true` if editing an existing task, `false` for a new task.
 */
@Composable
fun CustomDialogUI(
    textValue: String,
    onTextChange: (String) -> Unit,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit,
    isEditing: Boolean
) {
    Card(
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier.padding(10.dp),
        elevation = CardDefaults.cardElevation(15.dp),
    ) {
        Column(
            modifier = Modifier.background(MaterialTheme.colorScheme.background)
        ) {
            // 📌 Header Image
            Image(
                painter = painterResource(id = R.drawable.todo),
                contentDescription = "Notification Icon",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .padding(top = 35.dp)
                    .height(70.dp)
                    .fillMaxWidth()
            )

            // 📝 Title
            Text(
                text = if (isEditing) "Edit Task" else "Add New Task",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(top = 5.dp)
                    .fillMaxWidth(),
                style = MaterialTheme.typography.headlineMedium,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            // ✍️ Outlined Text Field for User Input
            OutlinedTextField(
                value = textValue,
                onValueChange = { onTextChange(it) },
                label = { Text("Enter your notes") },
                modifier = Modifier
                    .padding(top = 10.dp, start = 25.dp, end = 25.dp)
                    .fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,  // No background color
                    unfocusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = GreenPrimary,  // Green border when focused
                    unfocusedIndicatorColor = GreenSecondary, // Greenish border when not focused
                    cursorColor = GreenPrimary
                ),
                shape = RoundedCornerShape(12.dp) // Smooth rounded edges
            )

            Spacer(modifier = Modifier.height(16.dp))

            // 🎭 Action Buttons (Dismiss & Confirm)
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
                    .background(GreenBackground),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                TextButton(onClick = { onDismiss() }) {
                    Text(
                        "Cancel",
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.Bold,
                        color = GreenPrimary,
                        modifier = Modifier.padding(vertical = 5.dp)
                    )
                }
                TextButton(onClick = { onConfirm() }) {
                    Text(
                        "Save",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.ExtraBold,
                        color = GreenSecondary,
                        modifier = Modifier.padding(vertical = 5.dp)
                    )
                }
            }
        }
    }
}