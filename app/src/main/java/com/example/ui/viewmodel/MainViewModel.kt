package com.example.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.audio.PronunciationFeedback
import com.example.audio.SpeechRecognitionHelper
import com.example.audio.TtsManager
import com.example.data.local.AppDatabase
import com.example.data.local.UserProgressEntity
import com.example.data.models.Achievement
import com.example.data.models.Conversation
import com.example.data.models.EnglishLevel
import com.example.data.models.ExplanationLanguage
import com.example.data.models.Lesson
import com.example.data.models.ListeningQuestion
import com.example.data.models.PronunciationItem
import com.example.data.models.QuizQuestion
import com.example.data.repository.AppRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val database = AppDatabase.getDatabase(application)
    private val repository = AppRepository(database.userProgressDao())
    val ttsManager = TtsManager(application)
    val speechHelper = SpeechRecognitionHelper(application)

    val userProgress: StateFlow<UserProgressEntity?> = repository.userProgress
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = null
        )

    val lessons: List<Lesson> = repository.getAllLessons()
    val conversations: List<Conversation> = repository.getAllConversations()
    val pronunciationItems: List<PronunciationItem> = repository.getAllPronunciationItems()
    val listeningQuestions: List<ListeningQuestion> = repository.getAllListeningQuestions()
    val quizQuestions: List<QuizQuestion> = repository.getAllQuizQuestions()

    // Selected Active Items
    private val _selectedLesson = MutableStateFlow<Lesson?>(lessons.firstOrNull())
    val selectedLesson: StateFlow<Lesson?> = _selectedLesson.asStateFlow()

    private val _selectedConversation = MutableStateFlow<Conversation?>(conversations.firstOrNull())
    val selectedConversation: StateFlow<Conversation?> = _selectedConversation.asStateFlow()

    // Pronunciation state
    private val _pronunciationIndex = MutableStateFlow(0)
    val pronunciationIndex: StateFlow<Int> = _pronunciationIndex.asStateFlow()

    private val _pronunciationFeedback = MutableStateFlow<PronunciationFeedback?>(null)
    val pronunciationFeedback: StateFlow<PronunciationFeedback?> = _pronunciationFeedback.asStateFlow()

    // Quiz state
    private val _quizIndex = MutableStateFlow(0)
    val quizIndex: StateFlow<Int> = _quizIndex.asStateFlow()

    private val _quizSelectedOption = MutableStateFlow<Int?>(null)
    val quizSelectedOption: StateFlow<Int?> = _quizSelectedOption.asStateFlow()

    private val _quizIsSubmitted = MutableStateFlow(false)
    val quizIsSubmitted: StateFlow<Boolean> = _quizIsSubmitted.asStateFlow()

    private val _quizScore = MutableStateFlow(0)
    val quizScore: StateFlow<Int> = _quizScore.asStateFlow()

    // Listening state
    private val _listeningIndex = MutableStateFlow(0)
    val listeningIndex: StateFlow<Int> = _listeningIndex.asStateFlow()

    private val _listeningSelectedOption = MutableStateFlow<Int?>(null)
    val listeningSelectedOption: StateFlow<Int?> = _listeningSelectedOption.asStateFlow()

    private val _listeningIsSubmitted = MutableStateFlow(false)
    val listeningIsSubmitted: StateFlow<Boolean> = _listeningIsSubmitted.asStateFlow()

    private val _listeningScore = MutableStateFlow(0)
    val listeningScore: StateFlow<Int> = _listeningScore.asStateFlow()

    // Conversation Translation visibility
    private val _showConversationExplanation = MutableStateFlow(true)
    val showConversationExplanation: StateFlow<Boolean> = _showConversationExplanation.asStateFlow()

    // Lesson Exercise state
    private val _lessonExerciseSelected = MutableStateFlow<Int?>(null)
    val lessonExerciseSelected: StateFlow<Int?> = _lessonExerciseSelected.asStateFlow()

    private val _lessonExerciseSubmitted = MutableStateFlow(false)
    val lessonExerciseSubmitted: StateFlow<Boolean> = _lessonExerciseSubmitted.asStateFlow()

    init {
        viewModelScope.launch {
            repository.getInitialProgress()
        }
    }

    fun selectLesson(lesson: Lesson) {
        _selectedLesson.value = lesson
        _lessonExerciseSelected.value = null
        _lessonExerciseSubmitted.value = false
    }

    fun selectConversation(conversation: Conversation) {
        _selectedConversation.value = conversation
    }

    fun toggleConversationExplanation() {
        _showConversationExplanation.value = !_showConversationExplanation.value
    }

    fun setLanguage(language: ExplanationLanguage) {
        viewModelScope.launch {
            repository.setLanguage(language)
        }
    }

    fun setLevel(level: EnglishLevel) {
        viewModelScope.launch {
            repository.setLevel(level.code)
        }
    }

    fun completeOnboarding(language: ExplanationLanguage, level: EnglishLevel) {
        viewModelScope.launch {
            repository.completeOnboarding(language, level.code)
        }
    }

    fun speak(text: String, rate: Float? = null) {
        val currentProgress = userProgress.value
        if (currentProgress?.soundEnabled == false) return
        val speechRate = rate ?: currentProgress?.speechRate ?: 1.0f
        ttsManager.speak(text, speechRate)
    }

    fun stopSpeaking() {
        ttsManager.stop()
    }

    fun startListeningPronunciation(target: String) {
        speechHelper.startListening(target) { feedback ->
            _pronunciationFeedback.value = feedback
            if (feedback.isSuccess) {
                viewModelScope.launch {
                    repository.recordPronunciationPractice()
                }
            }
        }
    }

    fun stopListeningPronunciation() {
        speechHelper.stopListening()
    }

    fun nextPronunciationItem() {
        if (_pronunciationIndex.value < pronunciationItems.size - 1) {
            _pronunciationIndex.value += 1
            _pronunciationFeedback.value = null
        }
    }

    fun previousPronunciationItem() {
        if (_pronunciationIndex.value > 0) {
            _pronunciationIndex.value -= 1
            _pronunciationFeedback.value = null
        }
    }

    fun submitLessonExercise(selectedIndex: Int) {
        _lessonExerciseSelected.value = selectedIndex
        _lessonExerciseSubmitted.value = true
        val lesson = selectedLesson.value ?: return
        if (selectedIndex == lesson.exercise.correctIndex) {
            viewModelScope.launch {
                repository.markLessonCompleted(lesson.id)
            }
        }
    }

    fun markCurrentLessonCompleted() {
        val lesson = selectedLesson.value ?: return
        viewModelScope.launch {
            repository.markLessonCompleted(lesson.id)
        }
    }

    // Quiz logic
    fun selectQuizOption(index: Int) {
        if (!_quizIsSubmitted.value) {
            _quizSelectedOption.value = index
        }
    }

    fun submitQuizAnswer() {
        val selected = _quizSelectedOption.value ?: return
        val currentQ = quizQuestions.getOrNull(_quizIndex.value) ?: return
        _quizIsSubmitted.value = true
        val isCorrect = selected == currentQ.correctIndex
        if (isCorrect) {
            _quizScore.value += 1
        }
        viewModelScope.launch {
            repository.recordQuizResult(if (isCorrect) 1 else 0, 1)
        }
    }

    fun nextQuizQuestion() {
        if (_quizIndex.value < quizQuestions.size - 1) {
            _quizIndex.value += 1
            _quizSelectedOption.value = null
            _quizIsSubmitted.value = false
        }
    }

    fun restartQuiz() {
        _quizIndex.value = 0
        _quizSelectedOption.value = null
        _quizIsSubmitted.value = false
        _quizScore.value = 0
    }

    // Listening logic
    fun selectListeningOption(index: Int) {
        if (!_listeningIsSubmitted.value) {
            _listeningSelectedOption.value = index
        }
    }

    fun submitListeningAnswer() {
        val selected = _listeningSelectedOption.value ?: return
        val currentQ = listeningQuestions.getOrNull(_listeningIndex.value) ?: return
        _listeningIsSubmitted.value = true
        val isCorrect = selected == currentQ.correctIndex
        if (isCorrect) {
            _listeningScore.value += 1
            viewModelScope.launch {
                repository.recordQuizResult(1, 1)
            }
        }
    }

    fun nextListeningQuestion() {
        if (_listeningIndex.value < listeningQuestions.size - 1) {
            _listeningIndex.value += 1
            _listeningSelectedOption.value = null
            _listeningIsSubmitted.value = false
        }
    }

    fun restartListening() {
        _listeningIndex.value = 0
        _listeningSelectedOption.value = null
        _listeningIsSubmitted.value = false
        _listeningScore.value = 0
    }

    fun updateSoundSettings(soundEnabled: Boolean, speechRate: Float) {
        viewModelScope.launch {
            repository.updateSoundSettings(soundEnabled, speechRate)
        }
    }

    fun resetProgress() {
        viewModelScope.launch {
            repository.resetAllProgress()
            restartQuiz()
            restartListening()
            _pronunciationIndex.value = 0
            _pronunciationFeedback.value = null
            _lessonExerciseSelected.value = null
            _lessonExerciseSubmitted.value = false
        }
    }

    fun getAchievements(): List<Achievement> {
        val progress = userProgress.value ?: UserProgressEntity()
        return repository.getAchievements(progress)
    }

    fun getCurrentExplanationLanguage(): ExplanationLanguage {
        val code = userProgress.value?.language ?: "DARIJA"
        return if (code == "MSA") ExplanationLanguage.MSA else ExplanationLanguage.DARIJA
    }

    fun getCurrentLevel(): EnglishLevel {
        val code = userProgress.value?.level ?: "A1"
        return EnglishLevel.entries.find { it.code == code } ?: EnglishLevel.A1
    }

    override fun onCleared() {
        super.onCleared()
        ttsManager.cleanup()
        speechHelper.stopListening()
    }
}
