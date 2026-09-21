package com.example.data.datasource

import com.example.data.models.Conversation
import com.example.data.models.ConversationTurn

object ConversationsData {
    val conversations: List<Conversation> = listOf(
        Conversation(
            id = "conv_meeting",
            titleEnglish = "Meeting a New Friend",
            titleDarija = "التعرف على صديق جديد",
            titleArabic = "التعرف على صديق جديد",
            scenarioDarija = "جوج ديال الناس كيتعرفو لأول مرة فمقهى",
            scenarioArabic = "شخصان يتعارفان لأول مرة في مكان عام",
            iconEmoji = "🤝",
            turns = listOf(
                ConversationTurn(
                    speaker = "A",
                    speakerName = "Amine",
                    english = "Hello! My name is Amine. What is your name?",
                    pronunciationArabic = "هالو! ماي نيم إز أمين. وات إز يور نيم؟",
                    darija = "أهلاً! سميتي أمين. شنو سميتك نتا؟",
                    arabic = "مرحباً! اسمي أمين. ما هو اسمك؟"
                ),
                ConversationTurn(
                    speaker = "B",
                    speakerName = "John",
                    english = "Hi Amine! I'm John. Nice to meet you!",
                    pronunciationArabic = "هاي أمين! آيم جون. نايس تو ميت يو!",
                    darija = "أهلاً أمين! أنا جون. متشرف بمعرفتك!",
                    arabic = "أهلاً أمين! أنا جون. تشرفت بلقائك!"
                ),
                ConversationTurn(
                    speaker = "A",
                    speakerName = "Amine",
                    english = "Nice to meet you too! Where are you from?",
                    pronunciationArabic = "نايس تو ميت يو تو! وير آر يو فروم؟",
                    darija = "الشرف ليا حتى أنا! منين نتا؟",
                    arabic = "تشرفت بك أيضاً! من أي بلد أنت؟"
                ),
                ConversationTurn(
                    speaker = "B",
                    speakerName = "John",
                    english = "I am from London, England. And you?",
                    pronunciationArabic = "آي آم فروم لاندن، إنگلاند. أند يو؟",
                    darija = "أنا من لندن فإنجلترا. ونتا منين؟",
                    arabic = "أنا من لندن في بريطانيا. وأنت؟"
                ),
                ConversationTurn(
                    speaker = "A",
                    speakerName = "Amine",
                    english = "I am from Morocco! Welcome to our country!",
                    pronunciationArabic = "آيم فروم موروّكو! ويلكم تو آور كانتري!",
                    darija = "أنا من المغرب! مرحباً بيك فبلادنا!",
                    arabic = "أنا من المغرب! أهلاً بك في بلدنا!"
                ),
                ConversationTurn(
                    speaker = "B",
                    speakerName = "John",
                    english = "Thank you so much! Morocco is beautiful!",
                    pronunciationArabic = "ثانك يو سو ماتش! موروّكو إز بيوتيفول!",
                    darija = "شكراً بزاف ليك! المغرب زوين بزاف!",
                    arabic = "شكراً جزيلاً لك! المغرب بلد جميل ورائع!"
                )
            )
        ),
        Conversation(
            id = "conv_cafe",
            titleEnglish = "Ordering at a Cafe",
            titleDarija = "الطلب فالمقهى",
            titleArabic = "الطلب في المقهى",
            scenarioDarija = "طلب قهوة وكرواسون مع السرباي",
            scenarioArabic = "طلب مشروب ووجبة خفيفة من النادل",
            iconEmoji = "☕",
            turns = listOf(
                ConversationTurn(
                    speaker = "A",
                    speakerName = "Waiter",
                    english = "Good morning! Can I take your order?",
                    pronunciationArabic = "گود مورنينگ! كان آي تيك يور أوردر؟",
                    darija = "صباح الخير! شنو نوجد ليك تشرب؟",
                    arabic = "صباح الخير! هل يمكنني أخذ طلبك؟"
                ),
                ConversationTurn(
                    speaker = "B",
                    speakerName = "Customer",
                    english = "Good morning! I would like a coffee, please.",
                    pronunciationArabic = "گود مورنينگ! آي وود لايك أ كوفي، بليز.",
                    darija = "صباح النور! بغيت قهوة عافاك.",
                    arabic = "صباح الخير! أود الحصول على فنجان قهوة من فضلك."
                ),
                ConversationTurn(
                    speaker = "A",
                    speakerName = "Waiter",
                    english = "With milk or black coffee?",
                    pronunciationArabic = "وذ ميلك أور بلاك كوفي؟",
                    darija = "بالحليب (نص نص) ولا كحلة؟",
                    arabic = "هل تفضلها بالحليب أم سوداء؟"
                ),
                ConversationTurn(
                    speaker = "B",
                    speakerName = "Customer",
                    english = "With milk, please. And one bottle of water.",
                    pronunciationArabic = "وذ ميلك، بليز. أند وان بوتل أوف ووتر.",
                    darija = "بالحليب عافاك، وقرعة ديال الما.",
                    arabic = "بالحليب من فضلك، وقارورة ماء واحدة."
                ),
                ConversationTurn(
                    speaker = "A",
                    speakerName = "Waiter",
                    english = "Sure! That will be three dollars.",
                    pronunciationArabic = "شور! ذات ويل بي ثري دولارات.",
                    darija = "مرحبا! المجموع هو 3 دولار.",
                    arabic = "بكل سرور! الحساب سيكون ثلاثة دولارات."
                ),
                ConversationTurn(
                    speaker = "B",
                    speakerName = "Customer",
                    english = "Here you are. Thank you!",
                    pronunciationArabic = "هير يو آر. ثانك يو!",
                    darija = "هاك أسيدي. شكراً ليك بزاف!",
                    arabic = "تفضل. شكراً لك!"
                )
            )
        ),
        Conversation(
            id = "conv_directions",
            titleEnglish = "Asking for Directions",
            titleDarija = "طلب النعت والاتجاهات",
            titleArabic = "السؤال عن الاتجاهات والشارع",
            scenarioDarija = "السؤال على محطة القطار فالشارع",
            scenarioArabic = "السؤال عن موقع محطة القطار في الشارع",
            iconEmoji = "🗺️",
            turns = listOf(
                ConversationTurn(
                    speaker = "A",
                    speakerName = "Traveler",
                    english = "Excuse me, where is the train station?",
                    pronunciationArabic = "إكسكيوز مي، وير إز ذ ترين ستيشن؟",
                    darija = "سمح ليا عافاك، فين كاينة محطة التران؟",
                    arabic = "معذرة، أين تقع محطة القطار؟"
                ),
                ConversationTurn(
                    speaker = "B",
                    speakerName = "Local",
                    english = "Go straight, then turn left at the traffic light.",
                    pronunciationArabic = "گو ستريت، ذين تيرن ليفت أت ذ ترافيك لايت.",
                    darija = "سير نيشان، ومن بعد دور على اليسار عند الضو الحمر.",
                    arabic = "سر إلى الأمام مباشرة، ثم انعطف يساراً عند إشارة المرور."
                ),
                ConversationTurn(
                    speaker = "A",
                    speakerName = "Traveler",
                    english = "Is it far from here?",
                    pronunciationArabic = "إز إت فار فروم هير؟",
                    darija = "واش بعيدة من هنا؟",
                    arabic = "هل هي بعيدة من هنا؟"
                ),
                ConversationTurn(
                    speaker = "B",
                    speakerName = "Local",
                    english = "No, only five minutes on foot.",
                    pronunciationArabic = "نو، أونلي فايف مينتس أون فوت.",
                    darija = "لا، غير خمسة دالدقائق على رجليك.",
                    arabic = "لا، فقط خمس دقائق مشياً على الأقدام."
                ),
                ConversationTurn(
                    speaker = "A",
                    speakerName = "Traveler",
                    english = "Thank you very much for your help!",
                    pronunciationArabic = "ثانك يو ڤيري ماتش فور يور هيلب!",
                    darija = "شكراً بزاف ليك على المساعدة!",
                    arabic = "شكراً جزيلاً لك على مساعدتك!"
                )
            )
        )
    )
}
