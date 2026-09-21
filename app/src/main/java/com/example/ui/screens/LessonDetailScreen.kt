package com.example.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.models.ExplanationLanguage
import com.example.data.models.Lesson
import com.example.data.models.LessonVocabularyItem
import com.example.ui.components.ArabicPhoneticPill
import com.example.ui.components.AppTopBar
import com.example.ui.components.AudioSpeakButton
import com.example.ui.theme.AccentGold
import com.example.ui.theme.BrandNavy
import com.example.ui.theme.MoroccanGreen
import com.example.ui.theme.MoroccanGreenContainer
import com.example.ui.theme.MoroccanRed
import com.example.ui.theme.MoroccanRedContainer

@Composable
fun LessonDetailScreen(
    lesson: Lesson,
    language: ExplanationLanguage,
    isLessonCompleted: Boolean,
    selectedExerciseOption: Int?,
    isExerciseSubmitted: Boolean,
    xpPoints: Int,
    streakDays: Int,
    isSpeaking: Boolean,
    onSpeak: (String) -> Unit,
    onSelectExerciseOption: (Int) -> Unit,
    onCompleteLesson: () -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            AppTopBar(
                title = "الدرس ${lesson.number}: ${lesson.titleEnglish}",
                onBackClick = onBackClick,
                xpPoints = xpPoints,
                streakDays = streakDays,
                language = language
            )
        },
        modifier = modifier
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Lesson Header
            item {
                Card(
                    shape = RoundedCornerShape(22.dp),
                    colors = CardDefaults.cardColors(containerColor = BrandNavy),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(text = lesson.iconEmoji, fontSize = 32.sp)
                                Spacer(modifier = Modifier.width(12.dp))
                                Column {
                                    Text(
                                        text = lesson.titleEnglish,
                                        style = MaterialTheme.typography.titleLarge.copy(
                                            fontWeight = FontWeight.Bold
                                        ),
                                        color = Color.White
                                    )
                                    Text(
                                        text = if (language == ExplanationLanguage.DARIJA) lesson.titleDarija else lesson.titleArabic,
                                        style = MaterialTheme.typography.bodyMedium,
                                        color = MoroccanGreen
                                    )
                                }
                            }

                            if (isLessonCompleted) {
                                Surface(
                                    shape = RoundedCornerShape(10.dp),
                                    color = MoroccanGreen
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Check,
                                            contentDescription = null,
                                            tint = Color.White,
                                            modifier = Modifier.size(14.dp)
                                        )
                                        Spacer(modifier = Modifier.width(4.dp))
                                        Text(
                                            text = "مكتمل",
                                            style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                                            color = Color.White
                                        )
                                    }
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = if (language == ExplanationLanguage.DARIJA) lesson.descriptionDarija else lesson.descriptionArabic,
                            style = MaterialTheme.typography.bodySmall,
                            color = Color.White.copy(alpha = 0.8f)
                        )
                    }
                }
            }

            // Vocabulary Items Header
            item {
                Text(
                    text = "الكلمات والعبارات المستهدفة 📚",
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.onBackground
                )
            }

            // List of Items
            items(lesson.items) { item ->
                VocabularyItemCard(
                    item = item,
                    language = language,
                    isSpeaking = isSpeaking,
                    onSpeak = onSpeak
                )
            }

            // Small Exercise Section
            item {
                Spacer(modifier = Modifier.height(8.dp))
                ExerciseSection(
                    exercise = lesson.exercise,
                    language = language,
                    selectedOption = selectedExerciseOption,
                    isSubmitted = isExerciseSubmitted,
                    onSelectOption = onSelectExerciseOption,
                    onCompleteLesson = onCompleteLesson,
                    isLessonCompleted = isLessonCompleted
                )
            }
        }
    }
}

@Composable
private fun VocabularyItemCard(
    item: LessonVocabularyItem,
    language: ExplanationLanguage,
    isSpeaking: Boolean,
    onSpeak: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(18.dp)) {
            // English Word & Audio Speaker
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = item.english,
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.ExtraBold,
                            letterSpacing = 0.5.sp
                        ),
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    ArabicPhoneticPill(phoneticText = item.pronunciationArabic)
                }

                Spacer(modifier = Modifier.width(12.dp))

                AudioSpeakButton(
                    textToSpeak = item.english,
                    onSpeak = onSpeak,
                    isSpeaking = isSpeaking
                )
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Translations Row
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.45f))
                    .padding(12.dp)
            ) {
                // Moroccan Darija Translation
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "🇲🇦 بالدارجة: ", style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold))
                    Text(
                        text = item.darija,
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontWeight = if (language == ExplanationLanguage.DARIJA) FontWeight.Bold else FontWeight.Normal,
                            color = if (language == ExplanationLanguage.DARIJA) MoroccanGreen else MaterialTheme.colorScheme.onSurface
                        )
                    )
                }

                // Modern Standard Arabic Translation
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "🇸🇦 بالفصحى: ", style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold))
                    Text(
                        text = item.arabic,
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontWeight = if (language == ExplanationLanguage.MSA) FontWeight.Bold else FontWeight.Normal,
                            color = if (language == ExplanationLanguage.MSA) MoroccanGreen else MaterialTheme.colorScheme.onSurface
                        )
                    )
                }
            }

            // Example Sentence Box
            if (item.exampleEnglish.isNotBlank()) {
                Spacer(modifier = Modifier.height(12.dp))
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = Color(0xFFF1F5F9),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "مثال تطبيقي:",
                                style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                                color = BrandNavy
                            )
                            IconButton(
                                onClick = { onSpeak(item.exampleEnglish) },
                                modifier = Modifier.size(24.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.VolumeUp,
                                    contentDescription = "Listen to example",
                                    tint = BrandNavy,
                                    modifier = Modifier.size(16.dp)
                                )
                            }
                        }
                        Text(
                            text = "“${item.exampleEnglish}”",
                            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold),
                            color = BrandNavy
                        )
                        Text(
                            text = if (language == ExplanationLanguage.DARIJA) item.exampleDarija else item.exampleArabic,
                            style = MaterialTheme.typography.bodySmall,
                            color = Color(0xFF475569)
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun ExerciseSection(
    exercise: com.example.data.models.LessonExercise,
    language: ExplanationLanguage,
    selectedOption: Int?,
    isSubmitted: Boolean,
    onSelectOption: (Int) -> Unit,
    onCompleteLesson: () -> Unit,
    isLessonCompleted: Boolean,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(18.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = "✍️", fontSize = 24.sp)
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "تمرين سريع لتثبيت المعلومة",
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.onSurface
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = if (language == ExplanationLanguage.DARIJA) exercise.questionDarija else exercise.questionArabic,
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.SemiBold),
                color = MaterialTheme.colorScheme.onSurface
            )

            Spacer(modifier = Modifier.height(14.dp))

            // Options
            exercise.options.forEachIndexed { index, optionText ->
                val isSelected = selectedOption == index
                val isCorrect = index == exercise.correctIndex

                val borderColor = when {
                    isSubmitted && isCorrect -> MoroccanGreen
                    isSubmitted && isSelected && !isCorrect -> MoroccanRed
                    isSelected -> MoroccanGreen
                    else -> MaterialTheme.colorScheme.outline.copy(alpha = 0.3f)
                }

                val bgColor = when {
                    isSubmitted && isCorrect -> MoroccanGreenContainer.copy(alpha = 0.4f)
                    isSubmitted && isSelected && !isCorrect -> MoroccanRedContainer.copy(alpha = 0.4f)
                    isSelected -> MoroccanGreenContainer.copy(alpha = 0.2f)
                    else -> MaterialTheme.colorScheme.surface
                }

                Card(
                    shape = RoundedCornerShape(14.dp),
                    colors = CardDefaults.cardColors(containerColor = bgColor),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                        .border(1.5.dp, borderColor, RoundedCornerShape(14.dp))
                        .clickable(enabled = !isSubmitted) {
                            onSelectOption(index)
                        }
                        .testTag("exercise_option_$index")
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(14.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = optionText,
                            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Medium),
                            color = MaterialTheme.colorScheme.onSurface
                        )

                        if (isSubmitted && isCorrect) {
                            Icon(
                                imageVector = Icons.Default.CheckCircle,
                                contentDescription = "Correct",
                                tint = MoroccanGreen,
                                modifier = Modifier.size(20.dp)
                            )
                        } else if (isSubmitted && isSelected && !isCorrect) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = "Incorrect",
                                tint = MoroccanRed,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }
                }
            }

            AnimatedVisibility(visible = isSubmitted) {
                Column(modifier = Modifier.padding(top = 12.dp)) {
                    val isCorrect = selectedOption == exercise.correctIndex
                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = if (isCorrect) MoroccanGreenContainer else MoroccanRedContainer,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(12.dp)) {
                            Text(
                                text = if (isCorrect) "تبارك الله عليك! إجابة صحيحة 🎉" else "حاول تركز فهاد الملاحظة: 💡",
                                style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Bold),
                                color = if (isCorrect) MoroccanGreen else MoroccanRed
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = if (language == ExplanationLanguage.DARIJA) exercise.explanationDarija else exercise.explanationArabic,
                                style = MaterialTheme.typography.bodySmall,
                                color = if (isCorrect) Color(0xFF065F46) else Color(0xFF991B1B)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    Button(
                        onClick = onCompleteLesson,
                        shape = RoundedCornerShape(14.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = MoroccanGreen),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp)
                            .testTag("complete_lesson_button")
                    ) {
                        Text(
                            text = if (isLessonCompleted) "الدرس مكتمل بالفعل ✓" else "حفظ وإنهاء الدرس (+25 XP)",
                            style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Bold)
                        )
                    }
                }
            }
        }
    }
}
