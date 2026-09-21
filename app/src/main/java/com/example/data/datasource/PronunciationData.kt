package com.example.data.datasource

import com.example.data.models.PronunciationItem

object PronunciationData {
    val items: List<PronunciationItem> = listOf(
        PronunciationItem(
            id = "pr_1",
            english = "Good morning",
            phoneticArabic = "گودْ مُورْنِينْگْ",
            darija = "صباح الخير",
            arabic = "صباح الخير",
            difficulty = "Easy",
            pronunciationTip = "حرف G ينطق مثل الگاف المغربية (گ)، والـ ing فالاخير خفيفة."
        ),
        PronunciationItem(
            id = "pr_2",
            english = "Thank you very much",
            phoneticArabic = "ثَانْكْ يُو ڤِيرِي مَاتْشْ",
            darija = "شكراً بزاف ليك",
            arabic = "شكراً جزيلاً لك",
            difficulty = "Medium",
            pronunciationTip = "حرف الـ Th فهاد الكلمة كيتنطق بحال الثاء (ث)، ماشي السين."
        ),
        PronunciationItem(
            id = "pr_3",
            english = "Nice to meet you",
            phoneticArabic = "نَايْسْ تُو مِيتْ يُو",
            darija = "متشرفين بمعرفتك",
            arabic = "سُررت بلقائك",
            difficulty = "Easy",
            pronunciationTip = "حرف C كيتنطق 'س' ناعمة، و meet بمد الياء."
        ),
        PronunciationItem(
            id = "pr_4",
            english = "How are you doing?",
            phoneticArabic = "هَاوْ آرْ يُو دُوِينْگْ؟",
            darija = "كيداير؟ كيف دايرة الأمور؟",
            arabic = "كيف تسير أمورك؟",
            difficulty = "Medium",
            pronunciationTip = "ربط 'How are' بسلاسة فجملة وحدة سريعة."
        ),
        PronunciationItem(
            id = "pr_5",
            english = "Excuse me, please",
            phoneticArabic = "إِكْسْكْيُوزْ مِي، پْلِيزْ",
            darija = "سمح ليا عافاك",
            arabic = "معذرة من فضلك",
            difficulty = "Medium",
            pronunciationTip = "انتبه للفرق بين P و B: كلمة 'Please' فيها هواء قوي (پ)."
        ),
        PronunciationItem(
            id = "pr_6",
            english = "I am learning English",
            phoneticArabic = "آي آمْ لِيرْنِينْگْ إِينْگْلِشْ",
            darija = "كنتعلم الإنجليزية",
            arabic = "أنا أتعلم اللغة الإنجليزية",
            difficulty = "Hard",
            pronunciationTip = "حرف Sh فـ English كيتنطق الشين (ش) واضحة."
        ),
        PronunciationItem(
            id = "pr_7",
            english = "Delicious Moroccan food",
            phoneticArabic = "دِيلِيشَسْ مُورُوكَّانْ فُودْ",
            darija = "ماكلة مغربية بنينة بزاف",
            arabic = "طعام مغربي لذيذ جداً",
            difficulty = "Hard",
            pronunciationTip = "الـ cious تنطق 'شَس' خفيفة وسلسة."
        ),
        PronunciationItem(
            id = "pr_8",
            english = "Welcome to Morocco",
            phoneticArabic = "وِيلْكَمْ تُو مُورُوكُّو",
            darija = "مرحباً بيك فالمغرب",
            arabic = "أهلاً بك في المغرب",
            difficulty = "Easy",
            pronunciationTip = "كلمة Welcome تبدأ بصوت الواو الصريح."
        )
    )
}
