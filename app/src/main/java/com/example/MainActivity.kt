package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.data.models.EnglishLevel
import com.example.data.models.ExplanationLanguage
import com.example.ui.navigation.Screen
import com.example.ui.screens.ConversationScreen
import com.example.ui.screens.HomeScreen
import com.example.ui.screens.LanguageSelectionScreen
import com.example.ui.screens.LessonDetailScreen
import com.example.ui.screens.LessonsListScreen
import com.example.ui.screens.LevelSelectionScreen
import com.example.ui.screens.ListeningScreen
import com.example.ui.screens.ProgressScreen
import com.example.ui.screens.PronunciationScreen
import com.example.ui.screens.QuizScreen
import com.example.ui.screens.SettingsScreen
import com.example.ui.screens.SplashScreen
import com.example.ui.theme.MyApplicationTheme
import com.example.ui.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                    Surface(modifier = Modifier.fillMaxSize()) {
                        EnglishM3akApp()
                    }
                }
            }
        }
    }
}

@Composable
fun EnglishM3akApp(
    viewModel: MainViewModel = viewModel()
) {
    val navController = rememberNavController()
    val userProgress by viewModel.userProgress.collectAsState()

    val currentLanguage = viewModel.getCurrentExplanationLanguage()
    val currentLevel = viewModel.getCurrentLevel()
    val xpPoints = userProgress?.xpPoints ?: 0
    val streakDays = userProgress?.streakDays ?: 1
    val completedLessonIds = userProgress?.getCompletedLessonSet() ?: emptySet()

    val selectedLesson by viewModel.selectedLesson.collectAsState()
    val selectedConversation by viewModel.selectedConversation.collectAsState()
    val isSpeaking by viewModel.ttsManager.isSpeaking.collectAsState()
    val isListening by viewModel.speechHelper.isListening.collectAsState()
    val pronunciationFeedback by viewModel.pronunciationFeedback.collectAsState()
    val pronunciationIndex by viewModel.pronunciationIndex.collectAsState()

    val quizIndex by viewModel.quizIndex.collectAsState()
    val quizSelectedOption by viewModel.quizSelectedOption.collectAsState()
    val quizIsSubmitted by viewModel.quizIsSubmitted.collectAsState()
    val quizScore by viewModel.quizScore.collectAsState()

    val listeningIndex by viewModel.listeningIndex.collectAsState()
    val listeningSelectedOption by viewModel.listeningSelectedOption.collectAsState()
    val listeningIsSubmitted by viewModel.listeningIsSubmitted.collectAsState()
    val listeningScore by viewModel.listeningScore.collectAsState()

    val showConversationExplanation by viewModel.showConversationExplanation.collectAsState()
    val lessonExerciseSelected by viewModel.lessonExerciseSelected.collectAsState()
    val lessonExerciseSubmitted by viewModel.lessonExerciseSubmitted.collectAsState()

    // Determine start destination: splash if not onboarded yet
    val startDestination = remember(userProgress?.isOnboarded) {
        if (userProgress?.isOnboarded == true) Screen.Home.route else Screen.Splash.route
    }

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        // 1. Splash Screen
        composable(Screen.Splash.route) {
            SplashScreen(
                onContinueClick = {
                    navController.navigate(Screen.LanguageSelection.route)
                }
            )
        }

        // 2. Language Selection Screen
        composable(Screen.LanguageSelection.route) {
            LanguageSelectionScreen(
                currentSelection = currentLanguage,
                onLanguageSelected = { viewModel.setLanguage(it) },
                onContinueClick = {
                    navController.navigate(Screen.LevelSelection.route)
                }
            )
        }

        // 3. Level Selection Screen
        composable(Screen.LevelSelection.route) {
            LevelSelectionScreen(
                currentLevel = currentLevel,
                onLevelSelected = { viewModel.setLevel(it) },
                onFinishOnboarding = {
                    viewModel.completeOnboarding(currentLanguage, currentLevel)
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Splash.route) { inclusive = true }
                    }
                }
            )
        }

        // 4. Home Screen
        composable(Screen.Home.route) {
            val dailyLesson = viewModel.lessons.firstOrNull { !completedLessonIds.contains(it.id) }
                ?: viewModel.lessons.first()

            HomeScreen(
                userProgress = userProgress,
                explanationLanguage = currentLanguage,
                currentLevel = currentLevel,
                dailyLesson = dailyLesson,
                completedLessonsCount = completedLessonIds.size,
                totalLessonsCount = viewModel.lessons.size,
                onNavigateToLessons = { navController.navigate(Screen.Lessons.route) },
                onNavigateToLessonDetail = { lesson ->
                    viewModel.selectLesson(lesson)
                    navController.navigate(Screen.LessonDetail.route)
                },
                onNavigateToConversation = { navController.navigate(Screen.Conversation.route) },
                onNavigateToPronunciation = { navController.navigate(Screen.Pronunciation.route) },
                onNavigateToListening = { navController.navigate(Screen.Listening.route) },
                onNavigateToQuiz = { navController.navigate(Screen.Quiz.route) },
                onNavigateToProgress = { navController.navigate(Screen.Progress.route) },
                onNavigateToSettings = { navController.navigate(Screen.Settings.route) }
            )
        }

        // 5. Lessons Screen (A1 Path)
        composable(Screen.Lessons.route) {
            LessonsListScreen(
                lessons = viewModel.lessons,
                completedLessonIds = completedLessonIds,
                language = currentLanguage,
                xpPoints = xpPoints,
                streakDays = streakDays,
                onLessonClick = { lesson ->
                    viewModel.selectLesson(lesson)
                    navController.navigate(Screen.LessonDetail.route)
                },
                onBackClick = { navController.popBackStack() }
            )
        }

        // 6. Lesson Detail Screen
        composable(Screen.LessonDetail.route) {
            val lesson = selectedLesson ?: viewModel.lessons.first()
            LessonDetailScreen(
                lesson = lesson,
                language = currentLanguage,
                isLessonCompleted = completedLessonIds.contains(lesson.id),
                selectedExerciseOption = lessonExerciseSelected,
                isExerciseSubmitted = lessonExerciseSubmitted,
                xpPoints = xpPoints,
                streakDays = streakDays,
                isSpeaking = isSpeaking,
                onSpeak = { viewModel.speak(it) },
                onSelectExerciseOption = { viewModel.submitLessonExercise(it) },
                onCompleteLesson = { viewModel.markCurrentLessonCompleted() },
                onBackClick = { navController.popBackStack() }
            )
        }

        // 7. Pronunciation Screen
        composable(Screen.Pronunciation.route) {
            PronunciationScreen(
                items = viewModel.pronunciationItems,
                currentIndex = pronunciationIndex,
                feedback = pronunciationFeedback,
                isListening = isListening,
                isSpeaking = isSpeaking,
                language = currentLanguage,
                xpPoints = xpPoints,
                streakDays = streakDays,
                onSpeak = { viewModel.speak(it) },
                onStartListening = { viewModel.startListeningPronunciation(it) },
                onStopListening = { viewModel.stopListeningPronunciation() },
                onNext = { viewModel.nextPronunciationItem() },
                onPrevious = { viewModel.previousPronunciationItem() },
                onBackClick = { navController.popBackStack() }
            )
        }

        // 8. Conversation Screen
        composable(Screen.Conversation.route) {
            val conv = selectedConversation ?: viewModel.conversations.first()
            ConversationScreen(
                conversations = viewModel.conversations,
                selectedConversation = conv,
                language = currentLanguage,
                showExplanations = showConversationExplanation,
                xpPoints = xpPoints,
                streakDays = streakDays,
                isSpeaking = isSpeaking,
                onSelectConversation = { viewModel.selectConversation(it) },
                onToggleExplanations = { viewModel.toggleConversationExplanation() },
                onSpeak = { viewModel.speak(it) },
                onBackClick = { navController.popBackStack() }
            )
        }

        // 9. Listening Screen
        composable(Screen.Listening.route) {
            ListeningScreen(
                questions = viewModel.listeningQuestions,
                currentIndex = listeningIndex,
                selectedOption = listeningSelectedOption,
                isSubmitted = listeningIsSubmitted,
                score = listeningScore,
                language = currentLanguage,
                xpPoints = xpPoints,
                streakDays = streakDays,
                isSpeaking = isSpeaking,
                onSpeak = { viewModel.speak(it) },
                onSelectOption = { viewModel.selectListeningOption(it) },
                onSubmitAnswer = { viewModel.submitListeningAnswer() },
                onNextQuestion = { viewModel.nextListeningQuestion() },
                onRestart = { viewModel.restartListening() },
                onBackClick = { navController.popBackStack() }
            )
        }

        // 10. Quiz Screen
        composable(Screen.Quiz.route) {
            QuizScreen(
                questions = viewModel.quizQuestions,
                currentIndex = quizIndex,
                selectedOption = quizSelectedOption,
                isSubmitted = quizIsSubmitted,
                score = quizScore,
                language = currentLanguage,
                xpPoints = xpPoints,
                streakDays = streakDays,
                onSelectOption = { viewModel.selectQuizOption(it) },
                onSubmitAnswer = { viewModel.submitQuizAnswer() },
                onNextQuestion = { viewModel.nextQuizQuestion() },
                onRestart = { viewModel.restartQuiz() },
                onBackClick = { navController.popBackStack() }
            )
        }

        // 11. Progress Screen
        composable(Screen.Progress.route) {
            ProgressScreen(
                completedLessonsCount = completedLessonIds.size,
                totalLessonsCount = viewModel.lessons.size,
                quizCorrectCount = userProgress?.quizCorrectCount ?: 0,
                quizTotalCount = userProgress?.quizTotalCount ?: 0,
                xpPoints = xpPoints,
                streakDays = streakDays,
                currentLevel = currentLevel,
                achievements = viewModel.getAchievements(),
                language = currentLanguage,
                onBackClick = { navController.popBackStack() }
            )
        }

        // 12. Settings Screen
        composable(Screen.Settings.route) {
            SettingsScreen(
                currentLanguage = currentLanguage,
                currentLevel = currentLevel,
                soundEnabled = userProgress?.soundEnabled ?: true,
                speechRate = userProgress?.speechRate ?: 1.0f,
                onLanguageChanged = { viewModel.setLanguage(it) },
                onLevelChanged = { viewModel.setLevel(it) },
                onSoundSettingsChanged = { sound, rate -> viewModel.updateSoundSettings(sound, rate) },
                onResetProgress = { viewModel.resetProgress() },
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}

