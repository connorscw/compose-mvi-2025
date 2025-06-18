package com.boltuix.composetodo.core.common.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * 🔍 **Search Bar Component**
 *
 * A **custom search bar** with a **gradient background** and rounded corners.
 * It includes **leading & trailing icons** and is optimized for a **modern UI**.
 *
 * @param searchText 📝 **String** - The current text inside the search bar.
 * @param onSearchChange 🔄 **(String) -> Unit** - Callback triggered when the text changes.
 */
@Composable
fun SearchBar(searchText: String, onSearchChange: (String) -> Unit) {
    val keyboardController = LocalSoftwareKeyboardController.current

    // 🎨 Gradient background for the search bar
    val gradient = Brush.linearGradient(
        colors = listOf(Color(0xFF11998e), Color(0xFF38ef7d)), // 🌿 Dark to Light Green Gradient
    )

    TextField(
        value = searchText,
        onValueChange = { onSearchChange(it) },
        label = {
            Text("Search tasks...", color = Color.White) // 🏷️ Placeholder text
        },
        leadingIcon = {
            Icon(Icons.Rounded.Search, contentDescription = "Search Icon", tint = Color.White) // 🔍 Search Icon
        },
        trailingIcon = {
            IconButton(
                onClick = {
                    onSearchChange("")  // ✅ Clear the search field
                    keyboardController?.hide()  // ✅ Hide the keyboard
                }
            ) {
                Icon(Icons.Rounded.Refresh, contentDescription = "Clear Search", tint = Color.White) // 🔄 Refresh Icon
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .shadow(8.dp, RoundedCornerShape(25.dp))
            .background(gradient, RoundedCornerShape(20.dp)),
        shape = RoundedCornerShape(35.dp),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            focusedTextColor = Color.White,
            unfocusedTextColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            cursorColor = Color.White
        )
    )
}

/**
 * 🎨 **Light Mode Preview**
 */
@Preview(name = "Light Mode", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun PreviewSearchBarLight() {
    SearchBar(searchText = "", onSearchChange = {})
}
