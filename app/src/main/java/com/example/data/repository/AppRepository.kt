package com.example.data.repository

import com.example.data.datasource.ConversationsData
import com.example.data.datasource.LessonsData
import com.example.data.datasource.ListeningData
import com.example.data.datasource.PronunciationData
import com.example.data.datasource.QuizData
import com.example.data.local.UserProgressDao
import com.example.data.local.UserProgressEntity
import com.example.data.models.Achievement
import com.example.data.models.Conversation
import com.example.data.models.ExplanationLanguage
import com.example.data.models.Lesson
import com.example.data.models.ListeningQuestion
import com.example.data.models.PronunciationItem
import com.example.data.models.QuizQuestion
import kotlinx.coroutines.flow.Flow
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class AppRepository(private val dao: UserProgressDao) {

    val userProgress: Flow<UserProgressEntity?> = dao.getUserProgress()

    suspend fun getInitialProgress(): UserProgressEntity {
        val existing = dao.getUserProgressOnce()
        return if (existing != null) {
            checkAndUpdateStreak(existing)
        } else {
            val today = getTodayDateString()
            val initial = UserProgressEntity(
                id = 1,
                language = "DARIJA",
                level = "A1",
                completedLessonIds = "",
                xpPoints = 10,
                streakDays = 1,
                lastActiveDate = today,
                quizCorrectCount = 0,
                quizTotalCount = 0,
                soundEnabled = true,
                speechRate = 1.0f,
                pronunciationCount = 0,
                isOnboarded = false
            )
            dao.insertOrUpdate(initial)
            initial
        }
    }

    private suspend fun checkAndUpdateStreak(current: UserProgressEntity): UserProgressEntity {
        val today = getTodayDateString()
        if (current.lastActiveDate == today) {
            return current
        }

        val yesterday = getYesterdayDateString()
        val newStreak = if (current.lastActiveDate == yesterday) {
            current.streakDays + 1
        } else if (current.lastActiveDate.isBlank()) {
            1
        } else {
            1
        }

        val updated = current.copy(
            lastActiveDate = today,
            streakDays = newStreak
        )
        dao.insertOrUpdate(updated)
        return updated
    }

    suspend fun setLanguage(language: ExplanationLanguage) {
        val current = dao.getUserProgressOnce() ?: getInitialProgress()
        dao.insertOrUpdate(current.copy(language = language.code))
    }

    suspend fun setLevel(levelCode: String) {
        val current = dao.getUserProgressOnce() ?: getInitialProgress()
        dao.insertOrUpdate(current.copy(level = levelCode))
    }

    suspend fun completeOnboarding(language: ExplanationLanguage, levelCode: String) {
        val current = dao.getUserProgressOnce() ?: getInitialProgress()
        dao.insertOrUpdate(
            current.copy(
                language = language.code,
                level = levelCode,
                isOnboarded = true,
                xpPoints = current.xpPoints + 15
            )
        )
    }

    suspend fun markLessonCompleted(lessonId: String): Boolean {
        val current = dao.getUserProgressOnce() ?: getInitialProgress()
        val completedSet = current.getCompletedLessonSet().toMutableSet()
        val isFirstTime = !completedSet.contains(lessonId)
        completedSet.add(lessonId)

        val newXp = if (isFirstTime) current.xpPoints + 25 else current.xpPoints + 5
        val updated = current.copy(
            completedLessonIds = completedSet.joinToString(","),
            xpPoints = newXp
        )
        dao.insertOrUpdate(updated)
        return isFirstTime
    }

    suspend fun recordQuizResult(correctCount: Int, totalQuestions: Int) {
        val current = dao.getUserProgressOnce() ?: getInitialProgress()
        val earnedXp = correctCount * 10
        val updated = current.copy(
            xpPoints = current.xpPoints + earnedXp,
            quizCorrectCount = current.quizCorrectCount + correctCount,
            quizTotalCount = current.quizTotalCount + totalQuestions
        )
        dao.insertOrUpdate(updated)
    }

    suspend fun recordPronunciationPractice() {
        val current = dao.getUserProgressOnce() ?: getInitialProgress()
        val updated = current.copy(
            xpPoints = current.xpPoints + 10,
            pronunciationCount = current.pronunciationCount + 1
        )
        dao.insertOrUpdate(updated)
    }

    suspend fun updateSoundSettings(soundEnabled: Boolean, speechRate: Float) {
        val current = dao.getUserProgressOnce() ?: getInitialProgress()
        dao.insertOrUpdate(current.copy(soundEnabled = soundEnabled, speechRate = speechRate))
    }

    suspend fun resetAllProgress() {
        dao.clearAll()
        val today = getTodayDateString()
        val fresh = UserProgressEntity(
            id = 1,
            language = "DARIJA",
            level = "A1",
            completedLessonIds = "",
            xpPoints = 0,
            streakDays = 1,
            lastActiveDate = today,
            quizCorrectCount = 0,
            quizTotalCount = 0,
            soundEnabled = true,
            speechRate = 1.0f,
            pronunciationCount = 0,
            isOnboarded = false
        )
        dao.insertOrUpdate(fresh)
    }

    fun getAllLessons(): List<Lesson> = LessonsData.a1Lessons

    fun getLessonById(id: String): Lesson? = LessonsData.a1Lessons.find { it.id == id }

    fun getAllConversations(): List<Conversation> = ConversationsData.conversations

    fun getConversationById(id: String): Conversation? = ConversationsData.conversations.find { it.id == id }

    fun getAllPronunciationItems(): List<PronunciationItem> = PronunciationData.items

    fun getAllListeningQuestions(): List<ListeningQuestion> = ListeningData.questions

    fun getAllQuizQuestions(): List<QuizQuestion> = QuizData.questions

    fun getAchievements(progress: UserProgressEntity): List<Achievement> {
        val completedCount = progress.getCompletedLessonSet().size
        return listOf(
            Achievement(
                id = "ach_first_step",
                titleEnglish = "First Step",
                titleDarija = "أول خطوة",
                titleArabic = "الخطوة الأولى",
                descriptionDarija = "أكمل أول درس بنجاح",
                descriptionArabic = "إتمام أول درس بنجاح",
                iconEmoji = "🌟",
                maxProgress = 1,
                currentProgress = minOf(1, completedCount),
                isUnlocked = completedCount >= 1
            ),
            Achievement(
                id = "ach_streak_3",
                titleEnglish = "Flame Starter",
                titleDarija = "شعلة الحماس",
                titleArabic = "شعلة المواظبة",
                descriptionDarija = "حافظ على حماس التعلم لمدة 3 أيام متتالية",
                descriptionArabic = "المحافظة على التعلم لمدة 3 أيام متتالية",
                iconEmoji = "🔥",
                maxProgress = 3,
                currentProgress = minOf(3, progress.streakDays),
                isUnlocked = progress.streakDays >= 3
            ),
            Achievement(
                id = "ach_lessons_5",
                titleEnglish = "Knowledge Seeker",
                titleDarija = "طالب العلم",
                titleArabic = "طالب المعرفة",
                descriptionDarija = "أكمل 5 دروس في مسار A1",
                descriptionArabic = "إتمام 5 دروس في مسار المستوى A1",
                iconEmoji = "📚",
                maxProgress = 5,
                currentProgress = minOf(5, completedCount),
                isUnlocked = completedCount >= 5
            ),
            Achievement(
                id = "ach_quiz_champion",
                titleEnglish = "Quiz Champion",
                titleDarija = "بطل الكويز",
                titleArabic = "بطل الاختبارات",
                descriptionDarija = "جاوب على 5 أسئلة صحيحة في الاختبارات",
                descriptionArabic = "الإجابة عن 5 أسئلة صحيحة في الاختبارات",
                iconEmoji = "🎯",
                maxProgress = 5,
                currentProgress = minOf(5, progress.quizCorrectCount),
                isUnlocked = progress.quizCorrectCount >= 5
            ),
            Achievement(
                id = "ach_pronunciation_pro",
                titleEnglish = "Pronunciation Pro",
                titleDarija = "فصيح اللسان",
                titleArabic = "فصيح النطق",
                descriptionDarija = "تدرب على النطق بالإنجليزية 3 مرات",
                descriptionArabic = "التدرب على النطق بالإنجليزية 3 مرات",
                iconEmoji = "🗣️",
                maxProgress = 3,
                currentProgress = minOf(3, progress.pronunciationCount),
                isUnlocked = progress.pronunciationCount >= 3
            ),
            Achievement(
                id = "ach_xp_master",
                titleEnglish = "Master 200 XP",
                titleDarija = "خبير الإنجليزية",
                titleArabic = "المتعلم المتألق",
                descriptionDarija = "اجمع 200 نقطة خبرة (XP)",
                descriptionArabic = "جمع 200 نقطة خبرة في التطبيق",
                iconEmoji = "🏆",
                maxProgress = 200,
                currentProgress = minOf(200, progress.xpPoints),
                isUnlocked = progress.xpPoints >= 200
            )
        )
    }

    private fun getTodayDateString(): String {
        val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.US)
        return sdf.format(Date())
    }

    private fun getYesterdayDateString(): String {
        val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.US)
        val cal = java.util.Calendar.getInstance()
        cal.add(java.util.Calendar.DATE, -1)
        return sdf.format(cal.time)
    }
}
