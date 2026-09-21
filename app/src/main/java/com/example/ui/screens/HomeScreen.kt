package com.example.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.ChatBubble
import androidx.compose.material.icons.filled.Headphones
import androidx.compose.material.icons.filled.Leaderboard
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Psychology
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.data.local.UserProgressEntity
import com.example.data.models.EnglishLevel
import com.example.data.models.ExplanationLanguage
import com.example.data.models.Lesson
import com.example.ui.components.AppTopBar
import com.example.ui.theme.AccentGold
import com.example.ui.theme.BrandNavy
import com.example.ui.theme.MoroccanGreen
import com.example.ui.theme.MoroccanGreenContainer
import com.example.ui.theme.MoroccanRed
import com.example.ui.theme.MoroccanRedContainer

@Composable
fun HomeScreen(
    userProgress: UserProgressEntity?,
    explanationLanguage: ExplanationLanguage,
    currentLevel: EnglishLevel,
    dailyLesson: Lesson,
    completedLessonsCount: Int,
    totalLessonsCount: Int,
    onNavigateToLessons: () -> Unit,
    onNavigateToLessonDetail: (Lesson) -> Unit,
    onNavigateToConversation: () -> Unit,
    onNavigateToPronunciation: () -> Unit,
    onNavigateToListening: () -> Unit,
    onNavigateToQuiz: () -> Unit,
    onNavigateToProgress: () -> Unit,
    onNavigateToSettings: () -> Unit,
    modifier: Modifier = Modifier
) {
    val progressPercent = if (totalLessonsCount > 0) {
        (completedLessonsCount.toFloat() / totalLessonsCount.toFloat())
    } else 0f

    val xp = userProgress?.xpPoints ?: 0
    val streak = userProgress?.streakDays ?: 1

    ScaffoldWithContent(
        title = "English M3ak 🇬🇧🇲🇦",
        xp = xp,
        streak = streak,
        language = explanationLanguage,
        onSettingsClick = onNavigateToSettings,
        modifier = modifier
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Greeting & Level Hero Card
            item {
                GreetingCard(
                    language = explanationLanguage,
                    level = currentLevel,
                    streak = streak,
                    xp = xp
                )
            }

            // Daily Lesson Card
            item {
                DailyLessonCard(
                    lesson = dailyLesson,
                    isCompleted = userProgress?.getCompletedLessonSet()?.contains(dailyLesson.id) == true,
                    progressPercent = progressPercent,
                    completedCount = completedLessonsCount,
                    totalCount = totalLessonsCount,
                    language = explanationLanguage,
                    onStartLesson = { onNavigateToLessonDetail(dailyLesson) }
                )
            }

            // Section Header: Explore Learning Modes
            item {
                Text(
                    text = if (explanationLanguage == ExplanationLanguage.DARIJA) "الأقسام الرئيسية 🚀" else "الأقسام التعليمية 🚀",
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp)
                )
            }

            // 6 Grid Buttons (Lessons, Conversation, Pronunciation, Listening, Quiz, Progress)
            item {
                Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        ActionCard(
                            title = "الدروس",
                            subtitle = "مسار التعلم A1",
                            icon = Icons.Default.MenuBook,
                            iconColor = MoroccanGreen,
                            backgroundColor = MoroccanGreenContainer.copy(alpha = 0.4f),
                            badge = "$completedLessonsCount/$totalLessonsCount",
                            onClick = onNavigateToLessons,
                            testTag = "home_button_lessons",
                            modifier = Modifier.weight(1f)
                        )
                        ActionCard(
                            title = "المحادثة",
                            subtitle = "حوارات يومية",
                            icon = Icons.Default.ChatBubble,
                            iconColor = Color(0xFF2563EB),
                            backgroundColor = Color(0xFFDBEAFE),
                            badge = "مباشر",
                            onClick = onNavigateToConversation,
                            testTag = "home_button_conversation",
                            modifier = Modifier.weight(1f)
                        )
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        ActionCard(
                            title = "النطق",
                            subtitle = "تدريب صوتي",
                            icon = Icons.Default.Mic,
                            iconColor = MoroccanRed,
                            backgroundColor = MoroccanRedContainer.copy(alpha = 0.4f),
                            badge = "صوتي",
                            onClick = onNavigateToPronunciation,
                            testTag = "home_button_pronunciation",
                            modifier = Modifier.weight(1f)
                        )
                        ActionCard(
                            title = "الاستماع",
                            subtitle = "فهم المسموع",
                            icon = Icons.Default.Headphones,
                            iconColor = Color(0xFF7C3AED),
                            backgroundColor = Color(0xFFEDE9FE),
                            badge = "تحدي",
                            onClick = onNavigateToListening,
                            testTag = "home_button_listening",
                            modifier = Modifier.weight(1f)
                        )
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        ActionCard(
                            title = "الاختبارات",
                            subtitle = "كويز تفاعلي",
                            icon = Icons.Default.Psychology,
                            iconColor = Color(0xFFD97706),
                            backgroundColor = Color(0xFFFEF3C7),
                            badge = "+10 XP",
                            onClick = onNavigateToQuiz,
                            testTag = "home_button_quiz",
                            modifier = Modifier.weight(1f)
                        )
                        ActionCard(
                            title = "التقدم",
                            subtitle = "سجل الإنجازات",
                            icon = Icons.Default.Leaderboard,
                            iconColor = Color(0xFF0D9488),
                            backgroundColor = Color(0xFFCCFBF1),
                            badge = "إنجازات",
                            onClick = onNavigateToProgress,
                            testTag = "home_button_progress",
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }

            // Daily Challenge Card
            item {
                DailyChallengeCard(language = explanationLanguage)
            }
        }
    }
}

@Composable
private fun ScaffoldWithContent(
    title: String,
    xp: Int,
    streak: Int,
    language: ExplanationLanguage,
    onSettingsClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable (PaddingValues) -> Unit
) {
    androidx.compose.material3.Scaffold(
        topBar = {
            AppTopBar(
                title = title,
                xpPoints = xp,
                streakDays = streak,
                language = language,
                onLanguageClick = onSettingsClick
            )
        },
        floatingActionButton = {
            IconButton(
                onClick = onSettingsClick,
                modifier = Modifier
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.surface)
                    .size(48.dp)
                    .testTag("home_settings_fab")
            ) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "الإعدادات",
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        },
        modifier = modifier
    ) { padding ->
        content(padding)
    }
}

@Composable
private fun GreetingCard(
    language: ExplanationLanguage,
    level: EnglishLevel,
    streak: Int,
    xp: Int,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = BrandNavy),
        modifier = modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = if (language == ExplanationLanguage.DARIJA) "Salam! مرحباً بك 👋" else "مرحباً بك مجدداً 👋",
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.ExtraBold
                        ),
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = language.greeting,
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.White.copy(alpha = 0.8f)
                    )
                }

                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = Color(level.colorValue).copy(alpha = 0.25f)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                    ) {
                        Text(text = level.badge, fontSize = 12.sp)
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = level.titleEnglish,
                            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                            color = Color.White
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Stats summary row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(14.dp))
                    .background(Color.White.copy(alpha = 0.1f))
                    .padding(horizontal = 16.dp, vertical = 10.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.LocalFireDepartment,
                        contentDescription = null,
                        tint = MoroccanRed,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Column {
                        Text(
                            text = "$streak أيام متتالية",
                            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                            color = Color.White
                        )
                        Text(
                            text = "شعلة الحماس",
                            style = MaterialTheme.typography.labelSmall,
                            color = Color.White.copy(alpha = 0.6f)
                        )
                    }
                }

                Box(
                    modifier = Modifier
                        .height(28.dp)
                        .width(1.dp)
                        .background(Color.White.copy(alpha = 0.2f))
                )

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = null,
                        tint = AccentGold,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Column {
                        Text(
                            text = "$xp نقطة XP",
                            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                            color = Color.White
                        )
                        Text(
                            text = "مجموع النقاط",
                            style = MaterialTheme.typography.labelSmall,
                            color = Color.White.copy(alpha = 0.6f)
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun DailyLessonCard(
    lesson: Lesson,
    isCompleted: Boolean,
    progressPercent: Float,
    completedCount: Int,
    totalCount: Int,
    language: ExplanationLanguage,
    onStartLesson: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(18.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    shape = RoundedCornerShape(10.dp),
                    color = MoroccanGreenContainer
                ) {
                    Text(
                        text = "درس اليوم",
                        style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                        color = MoroccanGreen,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }

                Text(
                    text = "${(progressPercent * 100).toInt()}% مكتمل",
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            LinearProgressIndicator(
                progress = { progressPercent },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(6.dp)
                    .clip(RoundedCornerShape(3.dp)),
                color = MoroccanGreen,
                trackColor = MaterialTheme.colorScheme.surfaceVariant
            )

            Spacer(modifier = Modifier.height(14.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Surface(
                    shape = RoundedCornerShape(14.dp),
                    color = MoroccanGreenContainer.copy(alpha = 0.5f),
                    modifier = Modifier.size(48.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Text(text = lesson.iconEmoji, fontSize = 24.sp)
                    }
                }

                Spacer(modifier = Modifier.width(14.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "الدرس ${lesson.number}: ${lesson.titleEnglish}",
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = if (language == ExplanationLanguage.DARIJA) lesson.titleDarija else lesson.titleArabic,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            Button(
                onClick = onStartLesson,
                shape = RoundedCornerShape(14.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isCompleted) MaterialTheme.colorScheme.surfaceVariant else MoroccanGreen,
                    contentColor = if (isCompleted) MaterialTheme.colorScheme.onSurfaceVariant else Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(46.dp)
                    .testTag("home_start_lesson_button")
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = if (isCompleted) "مراجعة الدرس" else "ابدأ الدرس الآن (+25 XP)",
                        style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Bold)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                        contentDescription = null,
                        modifier = Modifier.size(18.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun ActionCard(
    title: String,
    subtitle: String,
    icon: ImageVector,
    iconColor: Color,
    backgroundColor: Color,
    badge: String,
    onClick: () -> Unit,
    testTag: String,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .clickable { onClick() }
            .testTag(testTag)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    shape = CircleShape,
                    color = backgroundColor,
                    modifier = Modifier.size(42.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(
                            imageVector = icon,
                            contentDescription = title,
                            tint = iconColor,
                            modifier = Modifier.size(22.dp)
                        )
                    }
                }

                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f)
                ) {
                    Text(
                        text = badge,
                        style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                color = MaterialTheme.colorScheme.onSurface
            )

            Text(
                text = subtitle,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
private fun DailyChallengeCard(
    language: ExplanationLanguage,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFEF3C7)
        ),
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                shape = CircleShape,
                color = AccentGold,
                modifier = Modifier.size(40.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Text(text = "🎯", fontSize = 20.sp)
                }
            }

            Spacer(modifier = Modifier.width(14.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "تحدي اليوم",
                    style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Bold),
                    color = Color(0xFF92400E)
                )
                Text(
                    text = if (language == ExplanationLanguage.DARIJA)
                        "أكمل درس واحد أو اختبار اليوم واربح +30 XP إضافية!"
                    else
                        "أتمم درساً واحداً أو اختباراً اليوم لتحصل على 30 نقطة إضافية!",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(0xFF78350F)
                )
            }
        }
    }
}
