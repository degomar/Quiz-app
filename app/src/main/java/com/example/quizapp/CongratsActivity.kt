package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.quizapp.databinding.ActivityCongratsBinding

class CongratsActivity : AppCompatActivity() {
    lateinit var binding: ActivityCongratsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_congrats)

        var retrived_name = intent.getStringExtra(Constants.USER_NAME)
        var retrived_score = intent.getIntExtra(Constants.CORRECT_ANSWERS,0)
        var retrived_total = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)


        binding.tvName.text = retrived_name
        binding.tvScore.text = "Seu score foi de $retrived_score / $retrived_total"

        binding.btnFinish.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}