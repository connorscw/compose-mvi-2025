# 🚀 Compose MVI 2025

A modern Android app template built with **Jetpack Compose**, **MVI architecture**, **Hilt for Dependency Injection**, and **Retrofit** for API communication – tailored for 2025 development best practices.

📺 **YouTube Demo**: [Watch Now](https://youtu.be/rUnXeJ7zC1w)

---

## 🧱 Tech Stack

- ✅ Jetpack Compose (UI Toolkit)
- 🧠 MVI Architecture (Model-View-Intent)
- 📡 Retrofit (API client)
- 💉 Hilt (Dependency Injection)
- 🔄 Kotlin Coroutines + Flow
- 🗃 Room (Offline caching)
- ✨ Clean Architecture principles

---

## 📂 Folder Structure

```
compose_post                     # 🏗️ Root Package (Main App)
│
├── di                           # 💉 Dependency Injection Modules
│   ├── AppModule.kt             # Shared dependencies
│   ├── NetworkModule.kt        # Retrofit instance
│
├── features                     # 🚀 Modular Feature Design
│   ├── posts                    # 📝 Posts Feature
│   │   ├── data                 # API and Repository Layer
│   │   │   ├── remote           # Retrofit & Data Source
│   │   │   ├── repository       # Data Handling Logic
│   │   ├── domain               # Business Logic Layer
│   │   │   ├── model            # Data Models
│   │   │   ├── usecase          # Use Cases
│   │   ├── mvi                  # 🧠 MVI Layer (State, Intent, ViewModel)
│   │   ├── presentation         # 🎨 UI Layer (Jetpack Compose)
```

---

## ✅ Features

- 🔄 Clean MVI flow with unidirectional data handling.
- ⚡ Smooth integration of Retrofit, Coroutines, and Flow.
- 📱 Fully functional Compose UI screens.
- 🔧 Modular structure using Clean Architecture.
- 🧪 Easy to test, scale, and extend.

---

## 📦 How to Use

1. Clone the repo:
```bash
git clone https://github.com/your-username/compose-mvi-2025.git
```

2. Open in Android Studio (Giraffe or later).

3. Sync Gradle and Run on emulator/device.

---

## 📌 Requirements

- Android Studio Giraffe or later
- Kotlin 1.9+
- Gradle 8.0+

---

## 🙌 Credits

Built by [boltuix](mailto:boltuix@gmail.com) – inspired by modern clean architecture principles.

---

## 📢 License

This project is licensed under the MIT License.
