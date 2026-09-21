package com.example.data.models

enum class ExplanationLanguage(
    val code: String,
    val titleArabic: String,
    val flagEmoji: String,
    val greeting: String
) {
    DARIJA(
        code = "DARIJA",
        titleArabic = "الدارجة المغربية",
        flagEmoji = "🇲🇦",
        greeting = "أهلاً بيك! واجد باش نتعلمو؟"
    ),
    MSA(
        code = "MSA",
        titleArabic = "العربية الفصحى",
        flagEmoji = "🇸🇦",
        greeting = "مرحباً بك! هل أنت مستعد للتعلم؟"
    )
}

enum class EnglishLevel(
    val code: String,
    val titleEnglish: String,
    val titleArabic: String,
    val colorValue: Long,
    val badge: String,
    val description: String
) {
    A1(
        code = "A1",
        titleEnglish = "Beginner A1",
        titleArabic = "مبتدئ A1",
        colorValue = 0xFF10B981,
        badge = "🟢",
        description = "الأساسيات والكلمات والعبارات اليومية الأكثر استعمالاً"
    ),
    A2(
        code = "A2",
        titleEnglish = "Elementary A2",
        titleArabic = "ابتدائي A2",
        colorValue = 0xFFF59E0B,
        badge = "🟡",
        description = "التعبير عن النفس والتواصل البسيط في مواقف الحياة"
    ),
    B1(
        code = "B1",
        titleEnglish = "Intermediate B1",
        titleArabic = "متوسط B1",
        colorValue = 0xFF3B82F6,
        badge = "🔵",
        description = "المحادثات وفهم النصوص وبناء الجمل المسترسلة"
    ),
    B2(
        code = "B2",
        titleEnglish = "Upper Intermediate B2",
        titleArabic = "فوق المتوسط B2",
        colorValue = 0xFF8B5CF6,
        badge = "🟣",
        description = "الطلاقة والمصطلحات المتقدمة والنقاشات التخصصية"
    )
}

data class LessonVocabularyItem(
    val id: String,
    val english: String,
    val pronunciationArabic: String,
    val darija: String,
    val arabic: String,
    val exampleEnglish: String,
    val examplePronunciation: String,
    val exampleDarija: String,
    val exampleArabic: String
)

data class LessonExercise(
    val id: String,
    val questionEnglish: String,
    val questionDarija: String,
    val questionArabic: String,
    val options: List<String>,
    val correctIndex: Int,
    val explanationDarija: String,
    val explanationArabic: String
)

data class Lesson(
    val id: String,
    val number: Int,
    val titleEnglish: String,
    val titleDarija: String,
    val titleArabic: String,
    val iconEmoji: String,
    val descriptionDarija: String,
    val descriptionArabic: String,
    val items: List<LessonVocabularyItem>,
    val exercise: LessonExercise
)

data class ConversationTurn(
    val speaker: String, // "A" or "B"
    val speakerName: String,
    val english: String,
    val pronunciationArabic: String,
    val darija: String,
    val arabic: String
)

data class Conversation(
    val id: String,
    val titleEnglish: String,
    val titleDarija: String,
    val titleArabic: String,
    val scenarioDarija: String,
    val scenarioArabic: String,
    val iconEmoji: String,
    val turns: List<ConversationTurn>
)

data class PronunciationItem(
    val id: String,
    val english: String,
    val phoneticArabic: String,
    val darija: String,
    val arabic: String,
    val difficulty: String,
    val pronunciationTip: String
)

data class ListeningQuestion(
    val id: String,
    val englishAudioText: String,
    val promptDarija: String,
    val promptArabic: String,
    val options: List<String>,
    val correctIndex: Int,
    val explanationDarija: String,
    val explanationArabic: String
)

data class QuizQuestion(
    val id: String,
    val questionEnglish: String,
    val questionDarija: String,
    val questionArabic: String,
    val options: List<String>,
    val correctIndex: Int,
    val explanationDarija: String,
    val explanationArabic: String,
    val category: String
)

data class Achievement(
    val id: String,
    val titleEnglish: String,
    val titleDarija: String,
    val titleArabic: String,
    val descriptionDarija: String,
    val descriptionArabic: String,
    val iconEmoji: String,
    val maxProgress: Int,
    val currentProgress: Int,
    val isUnlocked: Boolean
)
