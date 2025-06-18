package com.boltuix.features.todo.data.local

import androidx.paging.PagingSource
import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ToDoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(todo: ToDoEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(todos: List<ToDoEntity>)

    @Update
    suspend fun update(todo: ToDoEntity)

    @Delete
    suspend fun delete(todo: ToDoEntity)

    @Query("SELECT * FROM todo_table ORDER BY createdTimeAt DESC")
    fun getAllTodosPagination(): PagingSource<Int, ToDoEntity>


    @Query("SELECT * FROM todo_table ORDER BY createdTimeAt DESC")
    fun getAllTodos(): Flow<List<ToDoEntity>> // Returns a simple flow instead of paging source

    @Query("SELECT * FROM todo_table WHERE title LIKE '%' || :query || '%' ORDER BY createdTimeAt DESC")
    fun searchTodosPagination(query: String): PagingSource<Int, ToDoEntity>

    @Query("SELECT * FROM todo_table WHERE title LIKE '%' || :query || '%' ORDER BY createdTimeAt DESC")
    fun searchTodos(query: String): Flow<List<ToDoEntity>> // ✅ Changed from PagingSource to Flow<List<ToDo>>


    // Wrap in a transaction
    @Transaction
    suspend fun insertAllWithTransaction(posts: List<ToDoEntity>) {
        insertAll(posts) // Ensures atomicity
    }
    @Query("SELECT * FROM todo_table")
    suspend fun getAllPosts(): List<ToDoEntity>



}
