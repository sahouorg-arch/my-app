package com.example.data.datasource

import com.example.data.models.QuizQuestion

object QuizData {
    val questions: List<QuizQuestion> = listOf(
        QuizQuestion(
            id = "q_1",
            questionEnglish = "What does \"hungry\" mean?",
            questionDarija = "شنو كيعني \"hungry\" بالدارجة؟",
            questionArabic = "ماذا تعني كلمة \"hungry\"؟",
            options = listOf("عطشان", "جائع / فيا الجوع", "عيان", "فرحان"),
            correctIndex = 1,
            explanationDarija = "\"Hungry\" كتعني جائع أو فيا الجوع. عطشان هي \"thirsty\".",
            explanationArabic = "\"Hungry\" تعني جائع. بينما عطشان تعني \"thirsty\".",
            category = "Vocabulary"
        ),
        QuizQuestion(
            id = "q_2",
            questionEnglish = "How do you say \"Good morning\" in Darija?",
            questionDarija = "شنو هو المقابل ديال \"Good morning\" فالمغرب؟",
            questionArabic = "ما المقابل المناسب لتحية \"Good morning\"؟",
            options = listOf("تصبح على خير", "مساء الخير", "صباح الخير", "بسلامة"),
            correctIndex = 2,
            explanationDarija = "\"Good morning\" كنقولوها فالصباح وتعني صباح الخير.",
            explanationArabic = "\"Good morning\" تحية صباحية تعني صباح الخير.",
            category = "Greetings"
        ),
        QuizQuestion(
            id = "q_3",
            questionEnglish = "Choose the correct translation for \"سميتي أمين\":",
            questionDarija = "اختار الترجمة الصحيحة لـ \"سميتي أمين\":",
            questionArabic = "اختر الترجمة الإنجليزية الصحيحة لـ \"اسمي أمين\":",
            options = listOf(
                "My brother is Amine",
                "My name is Amine",
                "I live with Amine",
                "I know Amine"
            ),
            correctIndex = 1,
            explanationDarija = "\"My name is...\" هي سميتي فاش كتبغي تعرف براسك.",
            explanationArabic = "\"My name is...\" تُستخدم للتعريف بالاسم وتطابق اسمي...",
            category = "Introductions"
        ),
        QuizQuestion(
            id = "q_4",
            questionEnglish = "What does \"Too expensive\" mean when shopping?",
            questionDarija = "فاش تكون فالسوق وتقول \"Too expensive\" شنو كتقصد؟",
            questionArabic = "ماذا يقصد المشتري بعبارة \"Too expensive\"؟",
            options = listOf("رخيص بزاف", "غالي بزاف", "زوين وعجبني", "قديم"),
            correctIndex = 1,
            explanationDarija = "\"Expensive\" هي غالي، و \"Too expensive\" كتعني غالي بزاف ومبالغ فيه.",
            explanationArabic = "\"Too expensive\" تعني باهظ الثمن أو غالٍ جداً.",
            category = "Shopping"
        ),
        QuizQuestion(
            id = "q_5",
            questionEnglish = "What is the English word for \"ختي\" (الأخت)؟",
            questionDarija = "شنو هي الكلمة بالإنجليزية ديال \"ختي\"؟",
            questionArabic = "ما هي الكلمة المقابلة لـ \"الأخت\" بالإنجليزية؟",
            options = listOf("Mother", "Sister", "Daughter", "Aunt"),
            correctIndex = 1,
            explanationDarija = "\"Sister\" هي الأخت (ختي)، و \"Brother\" هو الأخ (خويا).",
            explanationArabic = "\"Sister\" تعني الأخت، بينما \"Mother\" تعني الأم.",
            category = "Family"
        ),
        QuizQuestion(
            id = "q_6",
            questionEnglish = "Complete the sentence: \"I live ______ Casablanca.\"",
            questionDarija = "كمل الجملة بالحرف المناسب: \"I live ______ Casablanca.\"",
            questionArabic = "اختر حرف الجر الصحيح: \"I live ______ Casablanca.\"",
            options = listOf("on", "at", "in", "to"),
            correctIndex = 2,
            explanationDarija = "مع المدن والدول كنستعملو حرف الجر \"in\" (I live in Casablanca).",
            explanationArabic = "نستخدم حرف الجر \"in\" مع المدن والبلدان (I live in Casablanca).",
            category = "Grammar"
        ),
        QuizQuestion(
            id = "q_7",
            questionEnglish = "How do you ask for water politely?",
            questionDarija = "كيفاش تطلب الما بطريقة مؤدبة بالإنجليزية؟",
            questionArabic = "كيف تطلب الماء بلباقة؟",
            options = listOf(
                "Give me water now!",
                "Can I have some water, please?",
                "Where is the food?",
                "I don't drink water"
            ),
            correctIndex = 1,
            explanationDarija = "كنستعملو \"Can I have..., please?\" باش نطلبو شي حاجة بأدب.",
            explanationArabic = "صيغة \"Can I have..., please?\" هي الأنسب للطلب المؤدب.",
            category = "Expressions"
        ),
        QuizQuestion(
            id = "q_8",
            questionEnglish = "What does \"Airport\" mean?",
            questionDarija = "شنو كيعني \"Airport\" بالدارجة؟",
            questionArabic = "ما معنى كلمة \"Airport\"؟",
            options = listOf("المحطة دالتران", "المطار ديال الطيارات", "الميناء دالباطوات", "لوطيل"),
            correctIndex = 1,
            explanationDarija = "\"Airport\" هو المطار فين كيحطو ويقلعو الطيارات.",
            explanationArabic = "\"Airport\" تعني المطار الجوي.",
            category = "Travel"
        )
    )
}
