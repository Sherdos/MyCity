# 📱 My Bishkek App

A modern Android app built with **Kotlin + Jetpack Compose** that helps users explore places in Bishkek by category (coffee, parks, restaurants, shopping, and more).

This project demonstrates **modern Android architecture**, adaptive layouts, and best practices using Jetpack libraries.

---

## Preview
[Screencast_20260225_193952.webm](https://github.com/user-attachments/assets/9dfd9d08-6f56-46c9-aae0-8ca0b4fdde6a)



## ✨ Features

- 🧭 Multi-screen navigation (Categories → Places → Details)
- 🧱 Clean architecture (UI + Data separation)
- 🔄 Unidirectional Data Flow (UDF)
- 🧠 ViewModel state management
- 📱 Adaptive layouts (phone + tablet)
- 🎨 Material 3 design
- 🖼 Place images support
- ⚡ Fully offline (local data)

---

## 🏙 Content

The app contains curated places in **Bishkek**:

### Categories
- ☕ Coffee shops
- 🍽 Restaurants
- 🌳 Parks
- 🧒 Kid-friendly places
- 🛍 Shopping

Each category includes 3–5 recommendations with:
- Image
- Description
- Details
- Address

---

## 🧱 Architecture

This project follows recommended Android architecture.

### Layers

UI Layer (Compose Screens)  
↓  
ViewModel (State + UDF)  
↓  
Repository (Data source)  
↓  
Models

### Key Concepts

- Jetpack Compose UI
- StateFlow
- Single source of truth
- Stateless UI components

---

## 🧭 Navigation

Built using Jetpack Navigation (Compose)

Flow:

Categories Screen  
↓  
Places Screen  
↓  
Place Details Screen

On tablets:
- Two-pane layout (list + details side by side)

---

## 📱 Adaptive Layout

The app supports:

| Device | Layout |
|--------|--------|
| Phones | Single-pane navigation |
| Tablets | Two-pane master/detail |

Uses:
- Material 3 Adaptive Layout
- Window size classes

---

## 🛠 Tech Stack

- Language: Kotlin
- UI: Jetpack Compose
- Architecture: MVVM + UDF
- Navigation: Navigation Compose
- Design: Material 3
- State: StateFlow
- Images: Local drawable resources

---

## 📦 Project Structure

com.example.mybishkek  
│  
├── data/  
│   └── CityRepository.kt  
│  
├── model/  
│   ├── Category.kt  
│   └── Place.kt  
│  
├── ui/  
│   ├── screens/  
│   ├── navigation/  
│   ├── state/  
│   └── MyCityApp.kt  
│  
└── MainActivity.kt  

---

## 🚀 Getting Started

### 1. Clone the project

git clone https://github.com/yourusername/my-bishkek-app.git

### 2. Open in Android Studio

Use Android Studio Hedgehog or newer.

### 3. Run the app

- Select emulator or device
- Click ▶ Run

---
## 👨‍💻 Author

Шердос Жапаров  
