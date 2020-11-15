package uz.pdp.quizapp.data

import uz.pdp.quizapp.R

object Constants {

    const val USER_NAME = "USERNAME"
    const val TOTAL_QUESTION: String = "total questions"
    const val CORRECT_ANS: String = "correct answers"
    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()
        val que1 = Question(
            1,
            "PDP qanday platforma?",
            R.drawable.pdpp,
            "Musiqa eshitish platformasi",
            "Kitob yuklab olish platformasi",
            "Online talim platformasi",
            "O'yin platformasi",
            3
        )

        questionsList.add(que1)


        val que2 = Question(
            1,
            "Xab (hub) nima?",
            R.drawable.hub,
            "Yulduz topologiyali tarmoqqa markaziy qurilma(kompyuter)",
            "Yulduz topologiyali tarmoqda yordamchi qurilma",
            "Shina topologiyali tarmoqqa yordamchi kompyuter",
            "Shina topologiyali tarmoqda markaziy kompyuter",
            1
        )

        questionsList.add(que2)

        val que3 = Question(
            1,
            "IP – adreslarning soni?",
            R.drawable.ip,
            "Chegaralanmagan",
            "Chegaralangan",
            "Chegaralanmagan, ammo aniqlash mumkin",
            "Chegaralangan, ammo ixtiyoriy foydalanuvchi kengaytirishi mumkin",
            2
        )

        questionsList.add(que3)

        val que4 = Question(
            1,
            "LAN va WAN nima?",
            R.drawable.lan,
            "LAN – bu global va WAN – lokal tarmoqlardir",
            "LAN – apparatura va WAN – programma ta’minotidir",
            "LAN – tarmoqning programma va WAN – tarmoqning apparatura ta’minotidir",
            "LAN– bu lokal va WAN – global tarmoqlardir",
            4
        )

        questionsList.add(que4)

        val que5 = Question(
            1,
            "Internet nima?",
            R.drawable.internet,
            "Xalqaro (butun dunyo) tarmog`i",
            "Yevropa va Osiyo orasidagi tarmoq",
            "AQSH va Yevropa orasida tashkil qilingan tarmoq",
            "Kompyuterlarning lokal tarmog`i",
            1
        )

        questionsList.add(que5)


        return questionsList
    }
}