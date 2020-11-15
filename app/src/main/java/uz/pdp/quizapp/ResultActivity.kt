package uz.pdp.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*
import uz.pdp.quizapp.data.Constants

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)


        val username = intent.getStringExtra(Constants.USER_NAME)
        resTvUsername.text = username
        val totalQues = intent.getIntExtra(Constants.TOTAL_QUESTION, 0)
        val correctAns = intent.getIntExtra(Constants.CORRECT_ANS, 0)

        restv.text =
            "Tabriklaymiz siz testni yakunladingiz siz $totalQues ta savoldan $correctAns tasiga to'g'ri topdingiz"

        btn_finish.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

    }
}