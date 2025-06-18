package com.boltuix.composetodo.core.di

import android.content.Context
import androidx.room.Room
import com.boltuix.composetodo.core.database.ToDoDatabase
import com.boltuix.features.todo.data.local.ToDoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

// Step 8: Create a Hilt Module for Dependency Injection
// 📌 File: di/DatabaseModule.kt

/**
 * 🏗️ **Dependency Injection Module (Hilt)**
 *
 * This **Hilt module** provides dependencies required throughout the app.
 * It includes:
 * - 🗄 **Room Database** (ToDoDatabase)
 * - 🏛 **DAO (ToDoDao)**
 * - 📝 **Logger Utility**
 *
 * ---
 *
 * 🔹 **Features:**
 * - 📦 **Singleton Scoped** dependencies (for optimized memory usage).
 * - 🏗 **Provides Room Database instance**.
 * - 📝 **Provides a Logger utility**.
 * - 🏛 **Provides DAO for accessing ToDo tasks**.
 *
 * ---
 *
 * @see ToDoDatabase The database storing `ToDo` items.
 * @see ToDoDao The DAO providing CRUD operations.
 * @see Logger The logging interface for debugging.
 */
@Module
@InstallIn(SingletonComponent::class) // 📍 Ensures dependencies live throughout the app's lifecycle
object DatabaseModule {

    /**
     * 🗄 **Provide Room Database Instance**
     * - Creates a **singleton** Room database instance.
     *
     * @param context The application context.
     * @return The **ToDoDatabase** instance.
     */
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): ToDoDatabase {
        return Room.databaseBuilder(
            context,
            ToDoDatabase::class.java, // 🗄️ Define the database class
            "todo_db3" // 🗂️ Database name
        ).build()
    }

    /**
     * 🏛 **Provide ToDoDao**
     * - Extracts **DAO** from the **Room Database**.
     *
     * @param database The **ToDoDatabase** instance.
     * @return The **ToDoDao** instance.
     */
    @Provides
    fun provideToDoDao(database: ToDoDatabase): ToDoDao = database.toDoDao()
}
