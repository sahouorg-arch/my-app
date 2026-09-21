package com.example.ui.screens

import androidx.compose.animation.AnimatedVisibility
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Translate
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.models.Conversation
import com.example.data.models.ConversationTurn
import com.example.data.models.ExplanationLanguage
import com.example.ui.components.ArabicPhoneticPill
import com.example.ui.components.AppTopBar
import com.example.ui.components.AudioSpeakButton
import com.example.ui.theme.BrandNavy
import com.example.ui.theme.MoroccanGreen
import com.example.ui.theme.MoroccanGreenContainer
import com.example.ui.theme.MoroccanRed

@Composable
fun ConversationScreen(
    conversations: List<Conversation>,
    selectedConversation: Conversation,
    language: ExplanationLanguage,
    showExplanations: Boolean,
    xpPoints: Int,
    streakDays: Int,
    isSpeaking: Boolean,
    onSelectConversation: (Conversation) -> Unit,
    onToggleExplanations: () -> Unit,
    onSpeak: (String) -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            AppTopBar(
                title = "محادثات بالإنجليزية",
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
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            // Conversation Topics Carousel
            item {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(conversations) { conv ->
                        val isSelected = conv.id == selectedConversation.id
                        Surface(
                            shape = RoundedCornerShape(14.dp),
                            color = if (isSelected) MoroccanGreen else MaterialTheme.colorScheme.surfaceVariant,
                            modifier = Modifier
                                .clip(RoundedCornerShape(14.dp))
                                .clickable { onSelectConversation(conv) }
                                .testTag("conversation_tab_${conv.id}")
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp)
                            ) {
                                Text(text = conv.iconEmoji, fontSize = 16.sp)
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = conv.titleEnglish,
                                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                                    color = if (isSelected) Color.White else MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }
                    }
                }
            }

            // Scenario Context & Translation Toggle Card
            item {
                Card(
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column {
                                Text(
                                    text = selectedConversation.titleEnglish,
                                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                                Text(
                                    text = if (language == ExplanationLanguage.DARIJA) selectedConversation.scenarioDarija else selectedConversation.scenarioArabic,
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        // Switch: Show Darija and Arabic explanations when requested
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(12.dp))
                                .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f))
                                .padding(horizontal = 12.dp, vertical = 6.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = Icons.Default.Translate,
                                    contentDescription = null,
                                    tint = MoroccanGreen,
                                    modifier = Modifier.size(18.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = "إظهار الترجمة والشرح",
                                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                            }

                            Switch(
                                checked = showExplanations,
                                onCheckedChange = { onToggleExplanations() },
                                colors = SwitchDefaults.colors(
                                    checkedThumbColor = MoroccanGreen,
                                    checkedTrackColor = MoroccanGreenContainer
                                ),
                                modifier = Modifier.testTag("conversation_toggle_explanations")
                            )
                        }
                    }
                }
            }

            // Conversation Chat Dialogue Bubbles
            items(selectedConversation.turns) { turn ->
                DialogueTurnBubble(
                    turn = turn,
                    language = language,
                    showExplanation = showExplanations,
                    isSpeaking = isSpeaking,
                    onSpeak = onSpeak
                )
            }
        }
    }
}

@Composable
private fun DialogueTurnBubble(
    turn: ConversationTurn,
    language: ExplanationLanguage,
    showExplanation: Boolean,
    isSpeaking: Boolean,
    onSpeak: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val isSpeakerA = turn.speaker == "A"
    val alignment = if (isSpeakerA) Alignment.Start else Alignment.End
    val bubbleColor = if (isSpeakerA) Color(0xFFF1F5F9) else MoroccanGreenContainer.copy(alpha = 0.35f)

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = alignment
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Surface(
                shape = CircleShape,
                color = if (isSpeakerA) BrandNavy else MoroccanGreen,
                modifier = Modifier.size(24.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Text(
                        text = turn.speaker,
                        style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                        color = Color.White
                    )
                }
            }
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = turn.speakerName,
                style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        Spacer(modifier = Modifier.height(4.dp))

        Card(
            shape = RoundedCornerShape(18.dp),
            colors = CardDefaults.cardColors(containerColor = bubbleColor),
            modifier = Modifier.fillMaxWidth(0.92f)
        ) {
            Column(modifier = Modifier.padding(14.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = turn.english,
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 0.3.sp
                        ),
                        color = BrandNavy,
                        modifier = Modifier.weight(1f)
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    AudioSpeakButton(
                        textToSpeak = turn.english,
                        onSpeak = onSpeak,
                        isSpeaking = isSpeaking,
                        buttonSize = 36,
                        iconSize = 18
                    )
                }

                AnimatedVisibility(visible = showExplanation) {
                    Column(modifier = Modifier.padding(top = 10.dp)) {
                        ArabicPhoneticPill(phoneticText = turn.pronunciationArabic)

                        Spacer(modifier = Modifier.height(6.dp))

                        Text(
                            text = if (language == ExplanationLanguage.DARIJA) "🇲🇦 ${turn.darija}" else "🇸🇦 ${turn.arabic}",
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontWeight = FontWeight.SemiBold,
                                color = MoroccanGreen
                            )
                        )
                    }
                }
            }
        }
    }
}
