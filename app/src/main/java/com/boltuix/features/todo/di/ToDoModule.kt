/*
package com.boltuix.features.todo.di

import com.boltuix.features.todo.data.local.ToDoDao
import com.boltuix.features.todo.data.repository.ToDoRepository
import com.boltuix.features.todo.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ToDoModule {

    @Provides
    @Singleton
    fun provideGetTodosUseCase(repository: ToDoRepository): GetTodosUseCase {
        return GetTodosUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideAddTodoUseCase(repository: ToDoRepository): AddTodoUseCase {
        return AddTodoUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideUpdateTodoUseCase(repository: ToDoRepository): UpdateTodoUseCase {
        return UpdateTodoUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideDeleteTodoUseCase(repository: ToDoRepository): DeleteTodoUseCase {
        return DeleteTodoUseCase(repository)
    }
}
*/
