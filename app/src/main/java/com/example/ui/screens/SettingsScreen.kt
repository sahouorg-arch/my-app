package com.example.ui.screens

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
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.DeleteForever
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.Speed
import androidx.compose.material.icons.filled.TrendingUp
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.models.EnglishLevel
import com.example.data.models.ExplanationLanguage
import com.example.ui.components.AppTopBar
import com.example.ui.theme.BrandNavy
import com.example.ui.theme.MoroccanGreen
import com.example.ui.theme.MoroccanGreenContainer
import com.example.ui.theme.MoroccanRed
import com.example.ui.theme.MoroccanRedContainer

@Composable
fun SettingsScreen(
    currentLanguage: ExplanationLanguage,
    currentLevel: EnglishLevel,
    soundEnabled: Boolean,
    speechRate: Float,
    onLanguageChanged: (ExplanationLanguage) -> Unit,
    onLevelChanged: (EnglishLevel) -> Unit,
    onSoundSettingsChanged: (Boolean, Float) -> Unit,
    onResetProgress: () -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var showResetDialog by remember { mutableStateOf(false) }
    var showAboutDialog by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            AppTopBar(
                title = "الإعدادات",
                onBackClick = onBackClick
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
            // 1. Explanation Language Section
            item {
                SettingsSection(
                    title = "لغة الشرح المفضلة",
                    icon = Icons.Default.Language
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        LanguageSelectChip(
                            title = "الدارجة المغربية",
                            flagEmoji = "🇲🇦",
                            isSelected = currentLanguage == ExplanationLanguage.DARIJA,
                            onClick = { onLanguageChanged(ExplanationLanguage.DARIJA) },
                            modifier = Modifier.weight(1f)
                        )
                        LanguageSelectChip(
                            title = "العربية الفصحى",
                            flagEmoji = "🇸🇦",
                            isSelected = currentLanguage == ExplanationLanguage.MSA,
                            onClick = { onLanguageChanged(ExplanationLanguage.MSA) },
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }

            // 2. Current Level Selection
            item {
                SettingsSection(
                    title = "المستوى التعليمي",
                    icon = Icons.Default.TrendingUp
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        EnglishLevel.entries.forEach { level ->
                            val isSelected = currentLevel == level
                            val levelColor = Color(level.colorValue)

                            Surface(
                                shape = RoundedCornerShape(12.dp),
                                color = if (isSelected) levelColor.copy(alpha = 0.12f) else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(12.dp))
                                    .clickable { onLevelChanged(level) }
                            ) {
                                Row(
                                    modifier = Modifier.padding(horizontal = 14.dp, vertical = 10.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Text(text = level.badge, fontSize = 16.sp)
                                        Spacer(modifier = Modifier.width(10.dp))
                                        Text(
                                            text = "${level.titleEnglish} (${level.titleArabic})",
                                            style = MaterialTheme.typography.bodyMedium.copy(
                                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                                            ),
                                            color = MaterialTheme.colorScheme.onSurface
                                        )
                                    }

                                    if (isSelected) {
                                        Icon(
                                            imageVector = Icons.Default.Check,
                                            contentDescription = null,
                                            tint = levelColor,
                                            modifier = Modifier.size(18.dp)
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }

            // 3. Audio & Sound Settings
            item {
                SettingsSection(
                    title = "الصوت والنطق",
                    icon = Icons.Default.VolumeUp
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column {
                                Text(
                                    text = "تشغيل الصوت التلقائي",
                                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                                Text(
                                    text = "سماع نطق الكلمات والجمل الإنجليزية",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }

                            Switch(
                                checked = soundEnabled,
                                onCheckedChange = { onSoundSettingsChanged(it, speechRate) },
                                colors = SwitchDefaults.colors(
                                    checkedThumbColor = MoroccanGreen,
                                    checkedTrackColor = MoroccanGreenContainer
                                ),
                                modifier = Modifier.testTag("settings_sound_switch")
                            )
                        }

                        // Speech Speed
                        Column {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(imageVector = Icons.Default.Speed, contentDescription = null, modifier = Modifier.size(18.dp), tint = MaterialTheme.colorScheme.onSurfaceVariant)
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = "سرعة نطق الكلام:",
                                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                            }

                            Spacer(modifier = Modifier.height(8.dp))

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                SpeedButton(
                                    label = "بطيء (0.8x)",
                                    isSelected = speechRate < 0.95f,
                                    onClick = { onSoundSettingsChanged(soundEnabled, 0.8f) },
                                    modifier = Modifier.weight(1f)
                                )
                                SpeedButton(
                                    label = "عادي (1.0x)",
                                    isSelected = speechRate in 0.95f..1.05f,
                                    onClick = { onSoundSettingsChanged(soundEnabled, 1.0f) },
                                    modifier = Modifier.weight(1f)
                                )
                                SpeedButton(
                                    label = "سريع (1.2x)",
                                    isSelected = speechRate > 1.05f,
                                    onClick = { onSoundSettingsChanged(soundEnabled, 1.2f) },
                                    modifier = Modifier.weight(1f)
                                )
                            }
                        }
                    }
                }
            }

            // 4. About & Reset Progress
            item {
                SettingsSection(
                    title = "عن التطبيق والبيانات",
                    icon = Icons.Default.Info
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        Button(
                            onClick = { showAboutDialog = true },
                            shape = RoundedCornerShape(14.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = BrandNavy),
                            modifier = Modifier.fillMaxWidth().testTag("settings_about_button")
                        ) {
                            Icon(imageVector = Icons.Default.Info, contentDescription = null)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(text = "حول تطبيق English M3ak")
                        }

                        OutlinedButton(
                            onClick = { showResetDialog = true },
                            shape = RoundedCornerShape(14.dp),
                            colors = ButtonDefaults.outlinedButtonColors(contentColor = MoroccanRed),
                            modifier = Modifier.fillMaxWidth().testTag("settings_reset_button")
                        ) {
                            Icon(imageVector = Icons.Default.DeleteForever, contentDescription = null)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(text = "إعادة تعيين التقدم بالكامل")
                        }
                    }
                }
            }
        }

        // About Dialog
        if (showAboutDialog) {
            AlertDialog(
                onDismissRequest = { showAboutDialog = false },
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(text = "🇬🇧", fontSize = 24.sp)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = "English M3ak 🇲🇦", fontWeight = FontWeight.Bold)
                    }
                },
                text = {
                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        Text(
                            text = "تطبيق تعليمي مغربي متكامل لتعلم اللغة الإنجليزية من الصفر للمبتدئين.",
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Text(
                            text = "• شروحات بالدارجة المغربية والعربية الفصحى\n• نطق صوتي مع تمارين ترديد بالميكروفون\n• محادثات حية واختبارات تفاعلية\n• يعمل بالكامل دون الحاجة للاتصال بالإنترنت",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                },
                confirmButton = {
                    Button(
                        onClick = { showAboutDialog = false },
                        colors = ButtonDefaults.buttonColors(containerColor = MoroccanGreen)
                    ) {
                        Text(text = "حسناً")
                    }
                }
            )
        }

        // Reset Confirmation Dialog
        if (showResetDialog) {
            AlertDialog(
                onDismissRequest = { showResetDialog = false },
                title = {
                    Text(text = "تأكيد إعادة التعيين", fontWeight = FontWeight.Bold, color = MoroccanRed)
                },
                text = {
                    Text(text = "هل أنت متأكد من رغبتك في مسح تقدم الدروس، النقاط، وسلسلة الأيام؟ لن تتمكن من التراجع عن هذه الخطوة.")
                },
                confirmButton = {
                    Button(
                        onClick = {
                            onResetProgress()
                            showResetDialog = false
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = MoroccanRed)
                    ) {
                        Text(text = "نعم، مسح كل شيء")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { showResetDialog = false }) {
                        Text(text = "إلغاء")
                    }
                }
            )
        }
    }
}

@Composable
private fun SettingsSection(
    title: String,
    icon: ImageVector,
    content: @Composable () -> Unit
) {
    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(18.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Surface(
                    shape = CircleShape,
                    color = MoroccanGreenContainer,
                    modifier = Modifier.size(32.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(imageVector = icon, contentDescription = null, tint = MoroccanGreen, modifier = Modifier.size(18.dp))
                    }
                }
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.onSurface
                )
            }

            Spacer(modifier = Modifier.height(14.dp))

            content()
        }
    }
}

@Composable
private fun LanguageSelectChip(
    title: String,
    flagEmoji: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = RoundedCornerShape(14.dp),
        color = if (isSelected) MoroccanGreenContainer else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f),
        border = if (isSelected) androidx.compose.foundation.BorderStroke(2.dp, MoroccanGreen) else null,
        modifier = modifier
            .clip(RoundedCornerShape(14.dp))
            .clickable { onClick() }
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = flagEmoji, fontSize = 20.sp)
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = title,
                style = MaterialTheme.typography.labelMedium.copy(
                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                ),
                color = if (isSelected) MoroccanGreen else MaterialTheme.colorScheme.onSurface
            )
        }
    }
}

@Composable
private fun SpeedButton(
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = RoundedCornerShape(10.dp),
        color = if (isSelected) MoroccanGreen else MaterialTheme.colorScheme.surfaceVariant,
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .clickable { onClick() }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            Text(
                text = label,
                style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                color = if (isSelected) Color.White else MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}
