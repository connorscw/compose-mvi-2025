package com.boltuix.features.todo.data.local
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo_table")
data class ToDoEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0, // 🔑 Auto-generated primary key
    val isCompleted: Boolean = false, // ✅ Default: Task is not completed
    val title: String, // 📝 Task name
    val createdTimeAt: Long = System.currentTimeMillis() // ⏳ Timestamp at creation
)


