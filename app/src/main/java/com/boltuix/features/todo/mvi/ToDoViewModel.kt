package com.boltuix.features.todo.mvi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.boltuix.features.todo.domain.model.ToDoModel
import com.boltuix.features.todo.domain.usecase.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ToDoViewModel @Inject constructor(
    private val getTodosUseCase: GetTodosUseCase,
    private val addTodoUseCase: AddTodoUseCase,
    private val updateTodoUseCase: UpdateTodoUseCase,
    private val deleteTodoUseCase: DeleteTodoUseCase,
    private val searchTodosUseCase: SearchTodosUseCase,
    private val fetchAndStoreTodosUseCase: FetchAndStoreTodosUseCase // ✅ Fetch API Data
) : ViewModel() {

    private val _state = MutableStateFlow<ToDoState>(ToDoState.Loading)
    val state: StateFlow<ToDoState> = _state.asStateFlow()

    private val _intent = MutableSharedFlow<ToDoIntent>()

    init {
        handleIntent()
        refreshTasks()
       // sendIntent(ToDoIntent.LoadTasks)
    }

    private fun handleIntent() {
        viewModelScope.launch {
            _intent.collect { intent ->
                when (intent) {
                    is ToDoIntent.AddTask -> addTask(intent.task)
                    is ToDoIntent.UpdateTask -> updateTask(intent.task)
                    is ToDoIntent.DeleteTask -> deleteTask(intent.task)
                    is ToDoIntent.SearchTask -> searchTasks(intent.query)
                    is ToDoIntent.LoadTasks -> loadTasks()
                }
            }
        }
    }


    fun refreshTasks() {
        viewModelScope.launch {
            fetchAndStoreTodosUseCase() // ✅ Fetch from API and store in Room
            loadTasks() // ✅ Load from Room
        }
    }

    fun sendIntent(intent: ToDoIntent) {
        viewModelScope.launch { _intent.emit(intent) }
    }

    private fun loadTasks() {
        viewModelScope.launch {
            getTodosUseCase().collect { tasks ->
                _state.value = if (tasks.isEmpty()) ToDoState.Empty else ToDoState.Success(tasks)
            }
        }
    }



    private fun addTask(task: ToDoModel) {
        viewModelScope.launch {
            addTodoUseCase(task)
            loadTasks()
        }
    }

    private fun updateTask(task: ToDoModel) {
        viewModelScope.launch {
            updateTodoUseCase(task)
            loadTasks()
        }
    }

    private fun deleteTask(task: ToDoModel) {
        viewModelScope.launch {
            deleteTodoUseCase(task)
            loadTasks()
        }
    }




    /**
     * 🔍 **Search Tasks**
     */
    private fun searchTasks(query: String) {
        viewModelScope.launch {
            searchTodosUseCase(query).collect { tasks ->
                _state.value = if (tasks.isEmpty()) ToDoState.Empty else ToDoState.Success(tasks)
            }
        }
    }


}
