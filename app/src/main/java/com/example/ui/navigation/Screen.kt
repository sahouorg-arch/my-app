package com.example.ui.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object LanguageSelection : Screen("language_selection")
    object LevelSelection : Screen("level_selection")
    object Home : Screen("home")
    object Lessons : Screen("lessons")
    object LessonDetail : Screen("lesson_detail")
    object Pronunciation : Screen("pronunciation")
    object Conversation : Screen("conversation")
    object Listening : Screen("listening")
    object Quiz : Screen("quiz")
    object Progress : Screen("progress")
    object Settings : Screen("settings")
}
