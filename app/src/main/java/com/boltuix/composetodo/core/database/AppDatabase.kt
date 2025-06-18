package com.boltuix.composetodo.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.boltuix.features.todo.data.local.ToDoDao
import com.boltuix.features.todo.data.local.ToDoEntity

// Step 9: Setting Up Room Database (ToDoDatabase)
/// 📌 File: data/local/AppDatabase.kt

/**
 * 🗄 **ToDo Database (Room)**
 *
 * This is the **Room Database** that provides local storage for **ToDo** tasks.
 * It acts as a single **source of truth** for task data and ensures persistence across app sessions.
 *
 * ---
 *
 * 🔹 **Features:**
 * - 📦 Stores tasks in a structured SQLite database.
 * - 🔄 Provides **DAO access** to interact with the database.
 * - 🚀 Ensures efficient task retrieval using **Paging3**.
 *
 * ---
 *
 * @see ToDoDao The DAO that provides access to database operations.
 */
@Database(entities = [ToDoEntity::class], version = 1, exportSchema = false)
abstract class ToDoDatabase : RoomDatabase() {

    /**
     * 🔌 **Get DAO Instance**
     * - Provides an instance of **ToDoDao** to interact with the database.
     *
     * @return `ToDoDao` The **Data Access Object** for performing database operations.
     */
    abstract fun toDoDao(): ToDoDao
}
