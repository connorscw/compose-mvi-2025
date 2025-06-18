package com.boltuix.composetodo

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

// 📌 File: MyApplication.kt

@HiltAndroidApp // 💉 Enable Hilt Dependency Injection for the entire app
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // Initialize your app here if needed
    }
}
