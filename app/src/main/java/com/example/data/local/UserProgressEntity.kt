package com.example.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_progress")
data class UserProgressEntity(
    @PrimaryKey val id: Int = 1,
    val language: String = "DARIJA", // "DARIJA" or "MSA"
    val level: String = "A1",
    val completedLessonIds: String = "", // comma-separated lesson IDs
    val xpPoints: Int = 0,
    val streakDays: Int = 1,
    val lastActiveDate: String = "",
    val quizCorrectCount: Int = 0,
    val quizTotalCount: Int = 0,
    val soundEnabled: Boolean = true,
    val speechRate: Float = 1.0f,
    val pronunciationCount: Int = 0,
    val isOnboarded: Boolean = false
) {
    fun getCompletedLessonSet(): Set<String> {
        return if (completedLessonIds.isBlank()) {
            emptySet()
        } else {
            completedLessonIds.split(",").map { it.trim() }.filter { it.isNotEmpty() }.toSet()
        }
    }
}
