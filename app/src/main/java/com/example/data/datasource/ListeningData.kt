package com.example.data.datasource

import com.example.data.models.ListeningQuestion

object ListeningData {
    val questions: List<ListeningQuestion> = listOf(
        ListeningQuestion(
            id = "lis_1",
            englishAudioText = "Can I have some water, please?",
            promptDarija = "سمع الأوديو واختار المعنى الصحيح بالدارجة:",
            promptArabic = "استمع إلى المقطع الصوتي واختر المعنى الصحيح:",
            options = listOf(
                "عافاك عطيني شوية دالما؟",
                "واش كاين شي قهوة؟",
                "بشحال هاد الخبز؟",
                "فين كاين المطار؟"
            ),
            correctIndex = 0,
            explanationDarija = "\"Can I have some water, please?\" كتعني واش ممكن تعطيني شوية دالما عافاك؟",
            explanationArabic = "\"Can I have some water, please?\" تعني هل يمكنني الحصول على قليل من الماء من فضلك؟"
        ),
        ListeningQuestion(
            id = "lis_2",
            englishAudioText = "Nice to meet you, my friend!",
            promptDarija = "شنو قال فهاد المقطع الصوتي؟",
            promptArabic = "ماذا قيل في هذا المقطع الصوتي؟",
            options = listOf(
                "بسلامة عليك يا خويا",
                "متشرفين بمعرفتك يا صاحبي!",
                "كيداير اليوم؟",
                "أنا جيعان بزاف"
            ),
            correctIndex = 1,
            explanationDarija = "\"Nice to meet you\" كتعني متشرفين بمعرفتك، و \"my friend\" هي صاحبي.",
            explanationArabic = "\"Nice to meet you, my friend!\" تعني تشرفت بلقائك يا صديقي!"
        ),
        ListeningQuestion(
            id = "lis_3",
            englishAudioText = "The train leaves at seven o'clock.",
            promptDarija = "شنو التوقيت لي سمعتي فالمقطع؟",
            promptArabic = "ما هو التوقيت المذكور في المقطع الصوتي؟",
            options = listOf(
                "التران كيمشي مع التلاتة",
                "التران كيمشي مع العشرة",
                "التران كيمشي مع السبعة",
                "التران كيمشي مع التمنية"
            ),
            correctIndex = 2,
            explanationDarija = "\"Seven o'clock\" هي السبعة دالعشية أو الصباح تماماً.",
            explanationArabic = "\"Seven o'clock\" تعني الساعة السابعة تماماً."
        ),
        ListeningQuestion(
            id = "lis_4",
            englishAudioText = "This Moroccan tea is very delicious!",
            promptDarija = "على شنو كيهضر الشخص فالمقطع؟",
            promptArabic = "عن ماذا يتحدث المتكلم في المقطع الصوتي؟",
            options = listOf(
                "القهوة سخونة بزاف",
                "أتاي المغربي بنين ولذيذ بزاف!",
                "السوق غالي بزاف",
                "الدار نقية وزوينة"
            ),
            correctIndex = 1,
            explanationDarija = "\"Moroccan tea\" هو أتاي المغربي، و \"delicious\" هي بنين بزاف.",
            explanationArabic = "\"Moroccan tea is very delicious!\" تعني الشاي المغربي لذيذ جداً."
        ),
        ListeningQuestion(
            id = "lis_5",
            englishAudioText = "I wake up early in the morning.",
            promptDarija = "شنو كيدير هاد الشخص حسب الأوديو؟",
            promptArabic = "ماذا يفعل الشخص وفق المقطع الصوتي؟",
            options = listOf(
                "كيشرب أتاي بالليل",
                "كيمشي للمارشي مع الجوج",
                "كيفيق بكري فالصباح",
                "كيسكن فمدينة كازا"
            ),
            correctIndex = 2,
            explanationDarija = "\"Wake up early\" كتعني كيفيق بكري فالصباح.",
            explanationArabic = "\"Wake up early in the morning\" تعني يستيقظ مبكراً في الصباح."
        )
    )
}
