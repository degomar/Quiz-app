package com.example.quizapp

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.quizapp.databinding.ActivityQuizQuestionsBinding

class QuizQuestionsActivity : AppCompatActivity(), OnClickListener {

    lateinit var binding : ActivityQuizQuestionsBinding
    lateinit var questionList: ArrayList<Question>
    var currentPosition: Int = 1
    var mySelectedPosition : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_quiz_questions)

        questionList = Constants.getQuestions()
        setQuestion()

        binding.option1.setOnClickListener(this)
        binding.option2.setOnClickListener(this)
        binding.option3.setOnClickListener(this)
        binding.option4.setOnClickListener(this)
        binding.btnSubmit.setOnClickListener(this)

    }

    private fun setQuestion() {
        defaultOptionView()
        var question: Question = questionList[currentPosition - 1]
        binding.progressbar.progress = currentPosition!!
        binding.tvProgressBar.text = "Pergunta ${currentPosition}/${binding.progressbar.max}"
        binding.tvQuestion?.text = question.question
        binding.option1?.text = question.option1
        binding.option2?.text = question.option2
        binding.option3?.text = question.option3
        binding.option4?.text = question.option4
        binding.imgQuestion.setImageResource(question.image)
    }

    private fun defaultOptionView() {
        var options = ArrayList<TextView>()
        binding.option1.let { options.add(0, it) }
        binding.option2.let { options.add(1, it) }
        binding.option3.let { options.add(2, it) }
        binding.option4.let { options.add(3, it) }

        for (option in options!!) {
            option.setTextColor(Color.parseColor("#f6fff8"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.design_default_btn
            )
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNumber: Int){
        defaultOptionView()
        mySelectedPosition = selectedOptionNumber

        tv.setTextColor(Color.parseColor("#FFFFFF"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.design_selected_btn
        )

    }
    override fun onClick(view: View?) {
        when(view?.id){
            binding.option1.id -> {
                binding.option1.let {
                    selectedOptionView(it,1)
                }
            }
            binding.option2.id -> {
                binding.option2.let {
                    selectedOptionView(it,2)
                }
            }
            binding.option3.id -> {
                binding.option3.let {
                    selectedOptionView(it,3)
                }
            }
            binding.option4.id -> {
                binding.option4.let {
                    selectedOptionView(it,4)
                }
            }
            binding.btnSubmit.id -> {
                if ( mySelectedPosition == 0){
                    currentPosition++
                when{
                    currentPosition <= questionList.size -> {
                        setQuestion()
                    }
                    else -> {
                        Toast.makeText(this,
                            "Parabéns você encerrou o quiz", Toast.LENGTH_LONG).show()
                    }
                }
            } else {
                    var question = questionList.get(currentPosition - 1)
                    if (question.correctAnswer != mySelectedPosition) {
                        answerView(mySelectedPosition, R.drawable.design_wrong_answer_btn)
                    }
                    answerView(question.correctAnswer, R.drawable.design_correct_answer_btn)
                    if (currentPosition == questionList.size) {
                        binding.btnSubmit.text = "Finalizar"

                    } else {
                        binding.btnSubmit.text = "ir para próxima pergunta"
                    }
                    mySelectedPosition = 0
            }


            }

        }
    }

    private fun answerView(answer: Int, drawableView: Int){

        when(answer) {
            1 -> binding.option1.background = ContextCompat.getDrawable(this,drawableView)
            2 -> binding.option2.background = ContextCompat.getDrawable(this,drawableView)
            3 -> binding.option3.background = ContextCompat.getDrawable(this,drawableView)
            4 -> binding.option4.background = ContextCompat.getDrawable(this,drawableView)
        }
    }
}