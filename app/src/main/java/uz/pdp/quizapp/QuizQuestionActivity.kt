package uz.pdp.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import uz.pdp.quizapp.data.Question
import kotlinx.android.synthetic.main.activity_quiz_question.*
import uz.pdp.quizapp.data.Constants

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {


    private var mCurrentPos: Int = 1
    private var mQuesList: ArrayList<Question>? = null
    private var mSelectedOption: Int = 0
    private var correctAnswers: Int = 0
    var mUsername: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        mUsername = intent.getStringExtra(Constants.USER_NAME)

        mQuesList = Constants.getQuestions()
        setQuestion()
        tvOption1.setOnClickListener(this)
        tvOption2.setOnClickListener(this)
        tvOption3.setOnClickListener(this)
        tvOption4.setOnClickListener(this)
        btn_submit.setOnClickListener(this)

    }

    private fun setQuestion() {
        val question = mQuesList!![mCurrentPos - 1]
        defaultOptionView()
        if (mCurrentPos == mQuesList!!.size) {
            btn_submit.text = "Yakunlash"
        } else {
            btn_submit.text = "Keyingisi"
        }
        ProgressBar.progress = mCurrentPos
        tv_progressBar.text = "$mCurrentPos" + "/" + ProgressBar.max

        tvQuesID.text = question.question
        ivImg.setImageResource(question.img)

        tvOption1.text = question.Option1
        tvOption2.text = question.Option2
        tvOption3.text = question.Option3
        tvOption4.text = question.Option4
    }

    private fun defaultOptionView() {
        val options = ArrayList<TextView>()
        options.add(0, tvOption1)
        options.add(1, tvOption2)
        options.add(2, tvOption3)
        options.add(3, tvOption4)
        for (option in options) {
            option.setTextColor(Color.parseColor("#7a8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_bg
            )
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tvOption1 -> {
                selectedOptionView(tvOption1, 1)
            }
            R.id.tvOption2 -> {
                selectedOptionView(tvOption2, 2)
            }
            R.id.tvOption3 -> {
                selectedOptionView(tvOption3, 3)
            }
            R.id.tvOption4 -> {
                selectedOptionView(tvOption4, 4)
            }
            R.id.btn_submit -> {

                if (mSelectedOption == 0) {
                    mCurrentPos++

                    when {
                        mCurrentPos <= mQuesList!!.size -> {
                            setQuestion()
                        }
                        else -> {
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, mUsername)
                            intent.putExtra(Constants.CORRECT_ANS, correctAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTION, mQuesList!!.size)
                            startActivity(intent)
                        }
                    }
                } else {
                    val question = mQuesList?.get(mCurrentPos - 1)
                    if (question!!.correctOption != mSelectedOption) {
                        answerView(mSelectedOption, R.drawable.wrong_option_bg)
                    } else {
                        correctAnswers++
                    }
                    answerView(question.correctOption, R.drawable.correct_option_bg)

                    if (mCurrentPos == mQuesList!!.size) {
                        btn_submit.text = "Tanlash"
                    } else {
                        btn_submit.text = "Keyingisiga o'tish"
                    }
                    mSelectedOption = 0
                }

            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> {
                tvOption1.background = ContextCompat.getDrawable(this, drawableView)
            }
            2 -> {
                tvOption2.background = ContextCompat.getDrawable(this, drawableView)
            }
            3 -> {
                tvOption3.background = ContextCompat.getDrawable(this, drawableView)
            }
            4 -> {
                tvOption4.background = ContextCompat.getDrawable(this, drawableView)
            }

        }
    }

    private fun selectedOptionView(tv: TextView, selectedOption: Int) {
        defaultOptionView()
        mSelectedOption = selectedOption
        tv.setTextColor(Color.parseColor("#363a43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_bg
        )
    }
}