package com.example.geoquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: ImageButton
    private lateinit var questionTextView: TextView
    private var questionBank = listOf(
        Question(R.string.ques_text1,true),
        Question(R.string.ques_text2,true),
        Question(R.string.ques_text3,true),
        Question(R.string.ques_text4,true)
    )
    private var currentIndex = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        trueButton = findViewById(R.id.buttontrue)
        falseButton = findViewById(R.id.buttonfalse)
        nextButton = findViewById(R.id.buttonnext)
        questionTextView = findViewById(R.id.question_text_view)
        trueButton.setOnClickListener { view: View ->
            Toast.LENGTH_SHORT
            checkAnswer(true)
        }
        falseButton.setOnClickListener{view:View ->
                Toast.LENGTH_SHORT
            checkAnswer(false)
        }
        nextButton.setOnClickListener{
            currentIndex = (currentIndex + 1) % questionBank.size
            updateQuestion()
        }
        updateQuestion()
    }
    fun updateQuestion(){
        val questionTextResId = questionBank[currentIndex].textResId
        questionTextView.setText(questionTextResId)
    }

    private fun checkAnswer(userAnswer:Boolean){
        val correctAnswer = questionBank[currentIndex].answer
        val messageResId = if(userAnswer ==correctAnswer){
            R.string.correct_toast
        }else {
            R.string.incorrect_toast}

            Toast.makeText(this, messageResId,Toast.LENGTH_SHORT).show()
        }
    }
