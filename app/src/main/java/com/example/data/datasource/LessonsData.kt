package com.example.data.datasource

import com.example.data.models.Lesson
import com.example.data.models.LessonExercise
import com.example.data.models.LessonVocabularyItem

object LessonsData {
    val a1Lessons: List<Lesson> = listOf(
        Lesson(
            id = "greetings",
            number = 1,
            titleEnglish = "Greetings",
            titleDarija = "التحيات والترحيب",
            titleArabic = "التحيات والسلام",
            iconEmoji = "👋",
            descriptionDarija = "تعلم كيفاش تسلم على الناس بالإنجليزية فكل وقت",
            descriptionArabic = "تعلم كيفية إلقاء التحية باللغة الإنجليزية في أوقات اليوم المختلفة",
            items = listOf(
                LessonVocabularyItem(
                    id = "g_1",
                    english = "Hello",
                    pronunciationArabic = "هالو",
                    darija = "أهلاً / السلام عليكم",
                    arabic = "مرحباً / أهلاً",
                    exampleEnglish = "Hello, my friend!",
                    examplePronunciation = "هالو، ماي فريند!",
                    exampleDarija = "أهلاً بصاحبي!",
                    exampleArabic = "مرحباً يا صديقي!"
                ),
                LessonVocabularyItem(
                    id = "g_2",
                    english = "Good morning",
                    pronunciationArabic = "گود مورنينگ",
                    darija = "صباح الخير",
                    arabic = "صباح الخير",
                    exampleEnglish = "Good morning everyone!",
                    examplePronunciation = "گود مورنينگ إيڤري وان!",
                    exampleDarija = "صباح الخير عليكم كاملين!",
                    exampleArabic = "صباح الخير للجميع!"
                ),
                LessonVocabularyItem(
                    id = "g_3",
                    english = "Good evening",
                    pronunciationArabic = "گود إيڤنينگ",
                    darija = "مساء الخير",
                    arabic = "مساء الخير",
                    exampleEnglish = "Good evening, sir.",
                    examplePronunciation = "گود إيڤنينگ، سير.",
                    exampleDarija = "مساء الخير أ سيدي.",
                    exampleArabic = "مساء الخير سيدي."
                ),
                LessonVocabularyItem(
                    id = "g_4",
                    english = "How are you?",
                    pronunciationArabic = "هاو آر يو؟",
                    darija = "كيداير؟ / كيدايرة؟",
                    arabic = "كيف حالك؟",
                    exampleEnglish = "How are you today?",
                    examplePronunciation = "هاو آر يو توداي؟",
                    exampleDarija = "كيداير اليوم؟ لاباس عليك؟",
                    exampleArabic = "كيف حالك اليوم؟"
                ),
                LessonVocabularyItem(
                    id = "g_5",
                    english = "I'm fine, thank you",
                    pronunciationArabic = "آيم فاين، ثانك يو",
                    darija = "لاباس، شكراً ليك",
                    arabic = "أنا بخير، شكراً لك",
                    exampleEnglish = "I'm fine, thank you very much.",
                    examplePronunciation = "آيم فاين، ثانك يو ڤيري ماتش.",
                    exampleDarija = "لاباس الحمد لله، شكراً بزاف.",
                    exampleArabic = "أنا بخير، شكراً جزيلاً لك."
                ),
                LessonVocabularyItem(
                    id = "g_6",
                    english = "Goodbye",
                    pronunciationArabic = "گود باي",
                    darija = "بسلامة / الله يعاون",
                    arabic = "مع السلامة / وداعاً",
                    exampleEnglish = "Goodbye, see you tomorrow!",
                    examplePronunciation = "گود باي، سي يو تومورو!",
                    exampleDarija = "بسلامة، نشوفك غدا إن شاء الله!",
                    exampleArabic = "مع السلامة، أراك غداً!"
                )
            ),
            exercise = LessonExercise(
                id = "ex_greetings",
                questionEnglish = "What does \"How are you?\" mean?",
                questionDarija = "شنو المعنى ديال \"How are you?\"",
                questionArabic = "ما معنى عبارة \"How are you?\"",
                options = listOf("كيداير؟ / كيف حالك؟", "صباح الخير", "بسلامة", "شكراً لك"),
                correctIndex = 0,
                explanationDarija = "\"How are you?\" كنستعملوها باش نسولو على الحال (كيداير؟).",
                explanationArabic = "\"How are you?\" تعني كيف حالك وتُستخدم للسؤال عن الحال."
            )
        ),
        Lesson(
            id = "introducing_yourself",
            number = 2,
            titleEnglish = "Introducing Yourself",
            titleDarija = "التعريف بالنفس",
            titleArabic = "التعريف بالنفس",
            iconEmoji = "🤝",
            descriptionDarija = "عرف براسك، سميتك، ومنين نتا بكل ثقة",
            descriptionArabic = "تعلم كيف تقدم نفسك وبلدك ومدينتك بثقة واحترافية",
            items = listOf(
                LessonVocabularyItem(
                    id = "iy_1",
                    english = "My name is...",
                    pronunciationArabic = "ماي نيم إز...",
                    darija = "سميتي...",
                    arabic = "اسمي هو...",
                    exampleEnglish = "My name is Amine.",
                    examplePronunciation = "ماي نيم إز أمين.",
                    exampleDarija = "سميتي أمين.",
                    exampleArabic = "اسمي أمين."
                ),
                LessonVocabularyItem(
                    id = "iy_2",
                    english = "Nice to meet you",
                    pronunciationArabic = "نايس تو ميت يو",
                    darija = "متشرفين بمعرفتك",
                    arabic = "سُررت بلقائك / تشرفت بك",
                    exampleEnglish = "Nice to meet you, Sara!",
                    examplePronunciation = "نايس تو ميت يو، سارة!",
                    exampleDarija = "متشرفين يا سارة!",
                    exampleArabic = "تشرفت بلقائك يا سارة!"
                ),
                LessonVocabularyItem(
                    id = "iy_3",
                    english = "I am from Morocco",
                    pronunciationArabic = "آيم فروم موروّكو",
                    darija = "أنا من المغرب",
                    arabic = "أنا من المغرب",
                    exampleEnglish = "I am from Morocco, and you?",
                    examplePronunciation = "آيم فروم موروّكو، أند يو؟",
                    exampleDarija = "أنا من المغرب، ونتا؟",
                    exampleArabic = "أنا من المغرب، وأنت؟"
                ),
                LessonVocabularyItem(
                    id = "iy_4",
                    english = "Where are you from?",
                    pronunciationArabic = "وير آر يو فروم؟",
                    darija = "منين نتا؟ / منين نتي؟",
                    arabic = "من أين أنت؟",
                    exampleEnglish = "Excuse me, where are you from?",
                    examplePronunciation = "إكسكيوز مي، وير آر يو فروم؟",
                    exampleDarija = "سمح ليا، منين نتا؟",
                    exampleArabic = "معذرة، من أين أنت؟"
                ),
                LessonVocabularyItem(
                    id = "iy_5",
                    english = "I live in Casablanca",
                    pronunciationArabic = "آي ليڤ إن كازابلانكا",
                    darija = "كنسكن فالدار البيضاء (كازا)",
                    arabic = "أعيش في الدار البيضاء",
                    exampleEnglish = "I live in Casablanca with my family.",
                    examplePronunciation = "آي ليڤ إن كازابلانكا وذ ماي فاميلي.",
                    exampleDarija = "كنسكن فالدار البيضاء مع عائلتي.",
                    exampleArabic = "أعيش في الدار البيضاء مع عائلتي."
                )
            ),
            exercise = LessonExercise(
                id = "ex_introducing",
                questionEnglish = "How do you say \"متشرفين بمعرفتك\" in English?",
                questionDarija = "كيفاش كتقول \"متشرفين بمعرفتك\" بالإنجليزية؟",
                questionArabic = "كيف تقول \"سُررت بلقائك\" باللغة الإنجليزية؟",
                options = listOf("Good evening", "Nice to meet you", "Where are you from?", "My name is"),
                correctIndex = 1,
                explanationDarija = "\"Nice to meet you\" كتعني متشرفين بلقائك ومعرفتك.",
                explanationArabic = "\"Nice to meet you\" تعني سُررت بلقائك أو تشرفت بمعرفتك."
            )
        ),
        Lesson(
            id = "numbers",
            number = 3,
            titleEnglish = "Numbers",
            titleDarija = "الأرقام والأعداد",
            titleArabic = "الأرقام والأعداد",
            iconEmoji = "🔢",
            descriptionDarija = "حفظ الأرقام من 1 حتى 10 وكيفاش تسول على الثمن",
            descriptionArabic = "تعلم العد والأرقام وكيفية السؤال عن السعر والحساب",
            items = listOf(
                LessonVocabularyItem(
                    id = "num_1",
                    english = "One, Two, Three",
                    pronunciationArabic = "وان، تو، ثري",
                    darija = "واحد، جوج، تلاتة",
                    arabic = "واحد، اثنان، ثلاثة",
                    exampleEnglish = "I have three tickets.",
                    examplePronunciation = "آي هاڤ ثري تيكيتس.",
                    exampleDarija = "عندي تلاتة دالتيكيات.",
                    exampleArabic = "لدي ثلاث تذاكر."
                ),
                LessonVocabularyItem(
                    id = "num_2",
                    english = "Four, Five, Six",
                    pronunciationArabic = "فور، فايف، سيكس",
                    darija = "ربعة، خمسة، ستة",
                    arabic = "أربعة، خمسة، ستة",
                    exampleEnglish = "Room number four.",
                    examplePronunciation = "روم نامبر فور.",
                    exampleDarija = "البيت رقم ربعة.",
                    exampleArabic = "الغرفة رقم أربعة."
                ),
                LessonVocabularyItem(
                    id = "num_3",
                    english = "Seven, Eight, Nine, Ten",
                    pronunciationArabic = "سيڤن، إيت، ناين، تين",
                    darija = "سبعة، تمنية، تسعود، عشرة",
                    arabic = "سبعة، ثمانية، تسعة، عشرة",
                    exampleEnglish = "It is ten o'clock.",
                    examplePronunciation = "إت إز تين أوكلوك.",
                    exampleDarija = "راها العشرة دابا.",
                    exampleArabic = "إنها الساعة العاشرة تماماً."
                ),
                LessonVocabularyItem(
                    id = "num_4",
                    english = "How much is this?",
                    pronunciationArabic = "هاو ماتش إز ذيس؟",
                    darija = "بشحال هادا؟",
                    arabic = "كم ثمن هذا؟",
                    exampleEnglish = "Excuse me, how much is this bag?",
                    examplePronunciation = "إكسكيوز مي، هاو ماتش إز ذيس باگ؟",
                    exampleDarija = "سمح ليا، بشحال هاد الصاك؟",
                    exampleArabic = "معذرة، كم ثمن هذه الحقيبة؟"
                )
            ),
            exercise = LessonExercise(
                id = "ex_numbers",
                questionEnglish = "What does \"How much is this?\" mean in Darija?",
                questionDarija = "شنو كتعني \"How much is this?\" بالدارجة؟",
                questionArabic = "ما معنى \"How much is this?\"؟",
                options = listOf("فين غادي؟", "بشحال هادا؟", "شكون نتا؟", "شحال الساعة؟"),
                correctIndex = 1,
                explanationDarija = "\"How much is this?\" كنسولو بيها على الثمن (بشحال هادا؟).",
                explanationArabic = "\"How much is this?\" تُستعمل للسؤال عن الثمن (كم سعر هذا؟)."
            )
        ),
        Lesson(
            id = "family",
            number = 4,
            titleEnglish = "Family",
            titleDarija = "العائلة والأسرة",
            titleArabic = "العائلة والقرابة",
            iconEmoji = "👨‍👩‍👧‍👦",
            descriptionDarija = "أسماء أفراد العائلة: الأب، الأم، الخوت وغيرهم",
            descriptionArabic = "تعلم أسماء أفراد الأسرة والعلاقات العائلية بالإنجليزية",
            items = listOf(
                LessonVocabularyItem(
                    id = "fam_1",
                    english = "Father",
                    pronunciationArabic = "فاذر",
                    darija = "الوالد / الأب / با",
                    arabic = "الأب",
                    exampleEnglish = "My father is very kind.",
                    examplePronunciation = "ماي فاذر إز ڤيري كايند.",
                    exampleDarija = "الوالد ديالي ظريف بزاف.",
                    exampleArabic = "أبي طيب ولطيف جداً."
                ),
                LessonVocabularyItem(
                    id = "fam_2",
                    english = "Mother",
                    pronunciationArabic = "ماذر",
                    darija = "الوالدة / الأم / مّي",
                    arabic = "الأم",
                    exampleEnglish = "My mother cooks delicious food.",
                    examplePronunciation = "ماي ماذر كوكس ديليشوس فود.",
                    exampleDarija = "الوالدة كطيب ماكلة بنينة بزاف.",
                    exampleArabic = "أمي تطهو طعاماً لذيذاً."
                ),
                LessonVocabularyItem(
                    id = "fam_3",
                    english = "Brother",
                    pronunciationArabic = "براذر",
                    darija = "خويا / الأخ",
                    arabic = "الأخ",
                    exampleEnglish = "I have an older brother.",
                    examplePronunciation = "آي هاڤ أن أولدر براذر.",
                    exampleDarija = "عندي خويا كبير عليا.",
                    exampleArabic = "لدي أخ أكبر مني."
                ),
                LessonVocabularyItem(
                    id = "fam_4",
                    english = "Sister",
                    pronunciationArabic = "سيستر",
                    darija = "ختي / الأخت",
                    arabic = "الأخت",
                    exampleEnglish = "My sister is a doctor.",
                    examplePronunciation = "ماي سيستر إز أ دوكتور.",
                    exampleDarija = "ختي طبيبة.",
                    exampleArabic = "أختي طبيبة."
                ),
                LessonVocabularyItem(
                    id = "fam_5",
                    english = "Family",
                    pronunciationArabic = "فاميلي",
                    darija = "العائلة / لافامي",
                    arabic = "الأسرة / العائلة",
                    exampleEnglish = "I love my family.",
                    examplePronunciation = "آي لاڤ ماي فاميلي.",
                    exampleDarija = "كنبغي عائلتي بزاف.",
                    exampleArabic = "أنا أحب عائلتي."
                )
            ),
            exercise = LessonExercise(
                id = "ex_family",
                questionEnglish = "What is the English word for \"ختي\"?",
                questionDarija = "شنو هي الكلمة بالإنجليزية لـ \"ختي\"؟",
                questionArabic = "ما هي الكلمة الإنجليزية المقابلة لـ \"أختي\"؟",
                options = listOf("Mother", "Brother", "Sister", "Father"),
                correctIndex = 2,
                explanationDarija = "\"Sister\" كتعني الأخت (ختي)، و \"Brother\" كتعني الأخ (خويا).",
                explanationArabic = "\"Sister\" تعني الأخت، بينما \"Brother\" تعني الأخ."
            )
        ),
        Lesson(
            id = "daily_routine",
            number = 5,
            titleEnglish = "Daily Routine",
            titleDarija = "الروتين اليومي",
            titleArabic = "الروتين اليومي والأفعال",
            iconEmoji = "⏰",
            descriptionDarija = "الأفعال لي كديرها كل نهار من الصباح حتى الليل",
            descriptionArabic = "تعلم التعبير عن الأنشطة اليومية من الصباح حتى النوم",
            items = listOf(
                LessonVocabularyItem(
                    id = "dr_1",
                    english = "I wake up early",
                    pronunciationArabic = "آي ويك أب إيرلي",
                    darija = "كنفيق بكري",
                    arabic = "أستيقظ مبكراً",
                    exampleEnglish = "I wake up early at 7 AM.",
                    examplePronunciation = "آي ويك أب إيرلي أت سيڤن إي إم.",
                    exampleDarija = "كنفيق بكري مع السبعة دالصباح.",
                    exampleArabic = "أستيقظ مبكراً في الساعة السابعة صباحاً."
                ),
                LessonVocabularyItem(
                    id = "dr_2",
                    english = "I drink coffee",
                    pronunciationArabic = "آي درينك كوفي",
                    darija = "كنشرب القهوة",
                    arabic = "أشرب القهوة",
                    exampleEnglish = "I drink coffee in the morning.",
                    examplePronunciation = "آي درينك كوفي إن ذ مورنينگ.",
                    exampleDarija = "كنشرب قهوة فالصباح.",
                    exampleArabic = "أشرب القهوة في الصباح."
                ),
                LessonVocabularyItem(
                    id = "dr_3",
                    english = "I go to work",
                    pronunciationArabic = "آي گو تو وورك",
                    darija = "كنمشي للخدمة",
                    arabic = "أذهب إلى العمل",
                    exampleEnglish = "I go to work by bus.",
                    examplePronunciation = "آي گو تو وورك باي باس.",
                    exampleDarija = "كنمشي للخدمة فالطوبيس.",
                    exampleArabic = "أذهب إلى العمل بالحافلة."
                ),
                LessonVocabularyItem(
                    id = "dr_4",
                    english = "I sleep at night",
                    pronunciationArabic = "آي سليب أت نايت",
                    darija = "كننعس بالليل",
                    arabic = "أنام في الليل",
                    exampleEnglish = "I sleep at night at 11 PM.",
                    examplePronunciation = "آي سليب أت نايت أت إليڤن بي إم.",
                    exampleDarija = "كننعس بالليل مع لحداش.",
                    exampleArabic = "أنام في الليل في الساعة الحادية عشرة."
                )
            ),
            exercise = LessonExercise(
                id = "ex_routine",
                questionEnglish = "How do you say \"كنفيق بكري\" in English?",
                questionDarija = "كيفاش كتقول \"كنفيق بكري\" بالإنجليزية؟",
                questionArabic = "كيف تعبر عن \"أستيقظ مبكراً\" بالإنجليزية؟",
                options = listOf("I sleep at night", "I go to work", "I wake up early", "I drink tea"),
                correctIndex = 2,
                explanationDarija = "\"I wake up early\" كتعني كنفيق بكري من النعاس.",
                explanationArabic = "\"I wake up early\" تعني أستيقظ مبكراً."
            )
        ),
        Lesson(
            id = "food_and_drinks",
            number = 6,
            titleEnglish = "Food and Drinks",
            titleDarija = "الأكل والمشروبات",
            titleArabic = "الطعام والشراب",
            iconEmoji = "🍔",
            descriptionDarija = "أسماء الأكلات، المشروبات، وعبارات الجوع والعطش",
            descriptionArabic = "تعلم مصطلحات الأطعمة والمشروبات والتعبير عن الجوع والشبع",
            items = listOf(
                LessonVocabularyItem(
                    id = "fd_1",
                    english = "Water",
                    pronunciationArabic = "ووتر",
                    darija = "الما",
                    arabic = "الماء",
                    exampleEnglish = "Can I have some water, please?",
                    examplePronunciation = "كان آي هاڤ سام ووتر، بليز؟",
                    exampleDarija = "عافاك عطيني شوية دالما؟",
                    exampleArabic = "هل يمكنني الحصول على قليل من الماء من فضلك؟"
                ),
                LessonVocabularyItem(
                    id = "fd_2",
                    english = "Bread",
                    pronunciationArabic = "بريد",
                    darija = "الخبز",
                    arabic = "الخبز",
                    exampleEnglish = "Fresh Moroccan bread is delicious.",
                    examplePronunciation = "فريش موروّكان بريد إز ديليشوس.",
                    exampleDarija = "الخبز المغربي سخون وبنين بزاف.",
                    exampleArabic = "الخبز المغربي الطازج لذيذ جداً."
                ),
                LessonVocabularyItem(
                    id = "fd_3",
                    english = "Tea",
                    pronunciationArabic = "تي",
                    darija = "أتاي / الشاي",
                    arabic = "الشاي",
                    exampleEnglish = "Moroccan mint tea is famous.",
                    examplePronunciation = "موروّكان مينت تي إز فايموس.",
                    exampleDarija = "أتاي المغربي بالنعناع معروف فالعالم.",
                    exampleArabic = "الشاي المغربي بالنعناع مشهور جداً."
                ),
                LessonVocabularyItem(
                    id = "fd_4",
                    english = "I am hungry",
                    pronunciationArabic = "آيم هانگري",
                    darija = "فيا الجوع / جيعان",
                    arabic = "أنا جائع",
                    exampleEnglish = "I am hungry, let's eat!",
                    examplePronunciation = "آيم هانگري، ليتس إيت!",
                    exampleDarija = "فيا الجوع، يلاه ناكلو!",
                    exampleArabic = "أنا جائع، هيا نتناول الطعام!"
                ),
                LessonVocabularyItem(
                    id = "fd_5",
                    english = "Delicious",
                    pronunciationArabic = "ديليشوس",
                    darija = "بنين / لذيذ بزاف",
                    arabic = "لذيذ / شهي",
                    exampleEnglish = "This couscous is delicious!",
                    examplePronunciation = "ذيس كسكوس إز ديليشوس!",
                    exampleDarija = "هاد الكسكسو بنين بزاف!",
                    exampleArabic = "هذا الكسكس لذيذ جداً!"
                )
            ),
            exercise = LessonExercise(
                id = "ex_food",
                questionEnglish = "What does \"hungry\" mean?",
                questionDarija = "شنو كيعني \"hungry\" بالدارجة؟",
                questionArabic = "ما معنى كلمة \"hungry\"؟",
                options = listOf("عطشان", "جائع / فيا الجوع", "عيان", "فرحان"),
                correctIndex = 1,
                explanationDarija = "\"Hungry\" كتعني جائع (فيا الجوع)، و \"Thirsty\" هي عطشان.",
                explanationArabic = "\"Hungry\" تعني جائع، بينما \"Thirsty\" تعني عطشان."
            )
        ),
        Lesson(
            id = "home",
            number = 7,
            titleEnglish = "Home",
            titleDarija = "الدار والمنزل",
            titleArabic = "المنزل والغرف",
            iconEmoji = "🏠",
            descriptionDarija = "أركان الدار: البيوت، الكوزينة، الباب والأثاث",
            descriptionArabic = "تعلم تسمية غرف المنزل وأجزائه والأثاث الأساسي",
            items = listOf(
                LessonVocabularyItem(
                    id = "hm_1",
                    english = "House / Home",
                    pronunciationArabic = "هاوس / هوم",
                    darija = "الدار / المنزل",
                    arabic = "منزل / بيت",
                    exampleEnglish = "Welcome to my home!",
                    examplePronunciation = "ويلكم تو ماي هوم!",
                    exampleDarija = "مرحباً بيك فالدار ديالي!",
                    exampleArabic = "أهلاً بك في منزلي!"
                ),
                LessonVocabularyItem(
                    id = "hm_2",
                    english = "Room",
                    pronunciationArabic = "روم",
                    darija = "البيت / الغرفة",
                    arabic = "غرفة / حجرة",
                    exampleEnglish = "My bedroom is very clean.",
                    examplePronunciation = "ماي بيدروم إز ڤيري كلين.",
                    exampleDarija = "بيت النعاس ديالي نقي بزاف.",
                    exampleArabic = "غرفة نومي نظيفة جداً."
                ),
                LessonVocabularyItem(
                    id = "hm_3",
                    english = "Kitchen",
                    pronunciationArabic = "كيتشن",
                    darija = "الكوزينة / المطبخ",
                    arabic = "المطبخ",
                    exampleEnglish = "She is in the kitchen.",
                    examplePronunciation = "شي إز إن ذ كيتشن.",
                    exampleDarija = "راها كاينا فالكوزينة.",
                    exampleArabic = "إنها في المطبخ."
                ),
                LessonVocabularyItem(
                    id = "hm_4",
                    english = "Door",
                    pronunciationArabic = "دور",
                    darija = "الباب",
                    arabic = "الباب",
                    exampleEnglish = "Please close the door.",
                    examplePronunciation = "بليز كلوز ذ دور.",
                    exampleDarija = "عافاك سد الباب.",
                    exampleArabic = "من فضلك أغلق الباب."
                )
            ),
            exercise = LessonExercise(
                id = "ex_home",
                questionEnglish = "What is \"الكوزينة\" in English?",
                questionDarija = "شنو هي \"الكوزينة\" بالإنجليزية؟",
                questionArabic = "ما هو المصطلح الإنجليزي لكلمة \"المطبخ\"؟",
                options = listOf("Door", "Kitchen", "House", "Room"),
                correctIndex = 1,
                explanationDarija = "\"Kitchen\" هي الكوزينة (المطبخ) فين كنطيبو.",
                explanationArabic = "\"Kitchen\" تعني المطبخ."
            )
        ),
        Lesson(
            id = "shopping",
            number = 8,
            titleEnglish = "Shopping",
            titleDarija = "التسوق والشراء",
            titleArabic = "التسوق والشراء",
            iconEmoji = "🛍️",
            descriptionDarija = "عبارات الحانوت والسوق والمفاهمة على الثمن",
            descriptionArabic = "تعلم مصطلحات الشراء والتسوق والسؤال عن المنتجات في المتاجر",
            items = listOf(
                LessonVocabularyItem(
                    id = "sh_1",
                    english = "Market / Store",
                    pronunciationArabic = "ماركت / ستور",
                    darija = "السوق / الحانوت / المتجر",
                    arabic = "السوق / المتجر",
                    exampleEnglish = "I am going to the market.",
                    examplePronunciation = "آي آم گوينگ تو ذ ماركت.",
                    exampleDarija = "راني غادي للسوق.",
                    exampleArabic = "أنا ذاهب إلى السوق."
                ),
                LessonVocabularyItem(
                    id = "sh_2",
                    english = "Can you help me?",
                    pronunciationArabic = "كان يو هيلب مي؟",
                    darija = "واش تقدر تعاوني؟",
                    arabic = "هل يمكنك مساعدتي؟",
                    exampleEnglish = "Excuse me, can you help me find this?",
                    examplePronunciation = "إكسكيوز مي، كان يو هيلب مي فايند ذيس؟",
                    exampleDarija = "سمح ليا، واش تقدر تعاوني نلقى هادا؟",
                    exampleArabic = "معذرة، هل يمكنك مساعدتي في العثور على هذا؟"
                ),
                LessonVocabularyItem(
                    id = "sh_3",
                    english = "Too expensive",
                    pronunciationArabic = "تو إكسبنسيڤ",
                    darija = "غالي بزاف",
                    arabic = "غالٍ جداً / باهظ الثمن",
                    exampleEnglish = "This jacket is too expensive.",
                    examplePronunciation = "ذيس جاكيت إز تو إكسبنسيڤ.",
                    exampleDarija = "هاد الجاكيت غالية بزاف.",
                    exampleArabic = "هذه السترة باهظة الثمن جداً."
                ),
                LessonVocabularyItem(
                    id = "sh_4",
                    english = "I want this",
                    pronunciationArabic = "آي وونت ذيس",
                    darija = "بغيت هادا / هادي",
                    arabic = "أريد هذا",
                    exampleEnglish = "I want this shirt, please.",
                    examplePronunciation = "آي وونت ذيس شيرت، بليز.",
                    exampleDarija = "بغيت هاد القميجة عافاك.",
                    exampleArabic = "أريد هذا القميص من فضلك."
                )
            ),
            exercise = LessonExercise(
                id = "ex_shopping",
                questionEnglish = "What does \"Too expensive\" mean?",
                questionDarija = "شنو كتعني \"Too expensive\" بالدارجة؟",
                questionArabic = "ما معنى \"Too expensive\"؟",
                options = listOf("رخيص بزاف", "غالي بزاف", "زوين بزاف", "كبير بزاف"),
                correctIndex = 1,
                explanationDarija = "\"Expensive\" هي غالي، و \"Too expensive\" هي غالي بزاف.",
                explanationArabic = "\"Too expensive\" تعني غالٍ جداً أو باهظ الثمن."
            )
        ),
        Lesson(
            id = "school_and_university",
            number = 9,
            titleEnglish = "School and University",
            titleDarija = "المدرسة والجامعة",
            titleArabic = "المدرسة والجامعة والتعليم",
            iconEmoji = "🎓",
            descriptionDarija = "مصطلحات القراية: التلميذ، الأستاذ، الكتوبا والتعلم",
            descriptionArabic = "تعلم مصطلحات الدراسة والفصول الأكاديمية والتعلم",
            items = listOf(
                LessonVocabularyItem(
                    id = "sc_1",
                    english = "Student",
                    pronunciationArabic = "ستيودنت",
                    darija = "طالب / تلميذ",
                    arabic = "طالب / تلميذ",
                    exampleEnglish = "I am an English student.",
                    examplePronunciation = "آيم أن إنگلش ستيودنت.",
                    exampleDarija = "أنا طالب كنتعلم الإنجليزية.",
                    exampleArabic = "أنا طالب أتعلم الإنجليزية."
                ),
                LessonVocabularyItem(
                    id = "sc_2",
                    english = "Teacher",
                    pronunciationArabic = "تيتشر",
                    darija = "أستاذ / معلم",
                    arabic = "أستاذ / معلم",
                    exampleEnglish = "Our teacher is wonderful.",
                    examplePronunciation = "آور تيتشر إز واندرفول.",
                    exampleDarija = "الأستاذ ديالنا واعر وممتاز.",
                    exampleArabic = "أستاذنا رائع ومميز."
                ),
                LessonVocabularyItem(
                    id = "sc_3",
                    english = "Book and Pen",
                    pronunciationArabic = "بوك أند پين",
                    darija = "كتاب وستيلو",
                    arabic = "كتاب وقلم",
                    exampleEnglish = "Open your book and take a pen.",
                    examplePronunciation = "أوبن يور بوك أند تيك أ پين.",
                    exampleDarija = "حل الكتاب ديالك وهز ستيلو.",
                    exampleArabic = "افتح كتابك وخذ قلماً."
                ),
                LessonVocabularyItem(
                    id = "sc_4",
                    english = "I learn English",
                    pronunciationArabic = "آي ليرن إنگلش",
                    darija = "كنتعلم الإنجليزية",
                    arabic = "أتعلم اللغة الإنجليزية",
                    exampleEnglish = "I learn English with English M3ak!",
                    examplePronunciation = "آي ليرن إنگلش وذ إنگلش معاك!",
                    exampleDarija = "كنتعلم الإنجليزية مع تطبيق إنگلش معاك!",
                    exampleArabic = "أتعلم الإنجليزية مع تطبيق English M3ak!"
                )
            ),
            exercise = LessonExercise(
                id = "ex_school",
                questionEnglish = "How do you say \"أستاذ\" in English?",
                questionDarija = "كيفاش كتقول \"أستاذ\" بالإنجليزية؟",
                questionArabic = "ما هي الكلمة المقابلة لـ \"معلم / أستاذ\"؟",
                options = listOf("Doctor", "Student", "Teacher", "Driver"),
                correctIndex = 2,
                explanationDarija = "\"Teacher\" كتعني أستاذ أو معلم، و \"Student\" كتعني تلميذ.",
                explanationArabic = "\"Teacher\" تعني معلماً أو أستاذاً."
            )
        ),
        Lesson(
            id = "travel_and_transport",
            number = 10,
            titleEnglish = "Travel and Transport",
            titleDarija = "السفر والمواصلات",
            titleArabic = "السفر ووسائل النقل",
            iconEmoji = "✈️",
            descriptionDarija = "المطار، المحطة، الطاكسي، الفندق وحجز التذاكر",
            descriptionArabic = "تعلم مصطلحات السفر والمطارات والتنقل والفنادق بكل سهولة",
            items = listOf(
                LessonVocabularyItem(
                    id = "tr_1",
                    english = "Airport and Station",
                    pronunciationArabic = "إيرپورت أند ستيشن",
                    darija = "المطار ولاگار (المحطة)",
                    arabic = "المطار والمحطة",
                    exampleEnglish = "Take me to Mohammed V airport.",
                    examplePronunciation = "تيك مي تو محمد في إيرپورت.",
                    exampleDarija = "ديني لمطار محمد الخامس عافاك.",
                    exampleArabic = "خذني إلى مطار محمد الخامس من فضلك."
                ),
                LessonVocabularyItem(
                    id = "tr_2",
                    english = "Taxi, Bus, Train",
                    pronunciationArabic = "تاكسي، باس، ترين",
                    darija = "طاكسي، طوبيس، التران (القطار)",
                    arabic = "سيارة أجرة، حافلة، قطار",
                    exampleEnglish = "The train arrives on time.",
                    examplePronunciation = "ذ ترين أرايڤز أون تايم.",
                    exampleDarija = "التران كيوصل فالوقت مضبوط.",
                    exampleArabic = "القطار يصل في الموعد المحدد."
                ),
                LessonVocabularyItem(
                    id = "tr_3",
                    english = "Where is the hotel?",
                    pronunciationArabic = "وير إز ذ هوتيل؟",
                    darija = "فين كاين لوطيل (الفندق)؟",
                    arabic = "أين يقع الفندق؟",
                    exampleEnglish = "Excuse me, where is the hotel?",
                    examplePronunciation = "إكسكيوز مي، وير إز ذ هوتيل؟",
                    exampleDarija = "سمح ليا، فين كاين لوطيل؟",
                    exampleArabic = "معذرة، أين يقع الفندق؟"
                ),
                LessonVocabularyItem(
                    id = "tr_4",
                    english = "Ticket",
                    pronunciationArabic = "تيكيت",
                    darija = "التيكي / التذكرة / الورقة",
                    arabic = "تذكرة السفر",
                    exampleEnglish = "One ticket to London, please.",
                    examplePronunciation = "وان تيكيت تو لاندن، بليز.",
                    exampleDarija = "تذكرة وحدة للندن عافاك.",
                    exampleArabic = "تذكرة واحدة إلى لندن من فضلك."
                )
            ),
            exercise = LessonExercise(
                id = "ex_travel",
                questionEnglish = "What does \"Where is the hotel?\" mean?",
                questionDarija = "شنو كتعني \"Where is the hotel?\" بالدارجة؟",
                questionArabic = "ما معنى جملة \"Where is the hotel?\"؟",
                options = listOf("بشحال لوطيل؟", "فين كاين لوطيل؟", "شكون فلوطيل؟", "واش لوطيل خاوي؟"),
                correctIndex = 1,
                explanationDarija = "\"Where is...\" كنسولو بيها على المكان (فين كاين...؟).",
                explanationArabic = "\"Where is the hotel?\" تعني أين يقع الفندق."
            )
        )
    )
}
