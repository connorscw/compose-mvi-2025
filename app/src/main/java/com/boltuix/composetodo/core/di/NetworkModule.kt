package com.boltuix.composetodo.core.di

import com.boltuix.features.post.data.remote.PostApiService
import com.boltuix.features.todo.data.remote.ToDoApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"  // 🌍 Base URL for API requests

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY  // 🔍 Logs HTTP requests & responses
        }
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)  // 🛠 Adds logging interceptor
            .connectTimeout(30, TimeUnit.SECONDS)  // ⏳ Connection timeout
            .readTimeout(30, TimeUnit.SECONDS)  // 📖 Read timeout
            .writeTimeout(30, TimeUnit.SECONDS)  // ✍ Write timeout
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)  // 🔗 Sets base API URL
            .client(okHttpClient)  // 🚀 Uses OkHttpClient for networking
            .addConverterFactory(GsonConverterFactory.create())  // 📦 Converts JSON to Kotlin objects
            .build()
    }


    @Provides
    @Singleton
    fun provideTodoApiService(retrofit: Retrofit): ToDoApiService {
        return retrofit.create(ToDoApiService::class.java)
    }


    @Provides
    @Singleton
    fun providePostService(retrofit: Retrofit): PostApiService {
        return retrofit.create(PostApiService::class.java)  // 📡 Creates API service for posts
    }
}
