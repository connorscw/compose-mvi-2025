package com.boltuix.features.todo.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.boltuix.features.todo.data.local.ToDoDao
import com.boltuix.features.todo.data.local.ToDoEntity
import com.boltuix.features.todo.data.remote.ToDoApiService
import com.boltuix.features.todo.data.remote.toEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ToDoRepository @Inject constructor(
    private val dao: ToDoDao,
    private val apiService: ToDoApiService

) {


    fun getAllTodosPagination(): Pager<Int, ToDoEntity> = Pager(
        PagingConfig(
            pageSize = 50, // 🔄 Load more data per page
            prefetchDistance = 10, // 🔄 Load next page in advance
            enablePlaceholders = false // 🔄 Set to true if you want placeholders
        )
    ) { dao.getAllTodosPagination() }


    fun getAllTodos(): Flow<List<ToDoEntity>> = dao.getAllTodos()

    fun searchTodosPagination(query: String): Pager<Int, ToDoEntity> = Pager(
        PagingConfig(pageSize = 10)
    ) { dao.searchTodosPagination(query) }


    fun searchTodos(query: String): Flow<List<ToDoEntity>> = dao.searchTodos(query)


    suspend fun insert(todo: ToDoEntity) = dao.insert(todo)

    suspend fun update(todo: ToDoEntity) = dao.update(todo)

    suspend fun delete(todo: ToDoEntity) = dao.delete(todo)

    suspend fun insertDefaultTodos() {
        val defaultTodos = List(100) { index ->
            ToDoEntity(
                title = "Default Todo $index", // 📝 Task title
                createdTimeAt = System.currentTimeMillis() // ⏳ Set creation timestamp
            )
        }
        dao.insertAll(defaultTodos) // 📥 Bulk insert into database
    }



    /**
     * ✅ Fetch tasks from API & Store in Room Database
     */
    suspend fun fetchAndStoreTodos() {
        val todosFromApi = apiService.getTodos().map { it.toEntity() } // Convert API DTO → Room Entity
        dao.insertAll(todosFromApi) // Store in Room
    }


}
