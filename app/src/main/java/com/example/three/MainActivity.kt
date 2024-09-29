package com.example.three

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import com.example.three.R
import com.example.three.databinding.ActivityMainBinding

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {


    private lateinit var binding:ActivityMainBinding
    private val quizViewModel: QuizViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate(Bundle?) called")
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d(TAG, "Got a QuizViewModel: $quizViewModel")

        binding.trueButton.setOnClickListener { view: View ->
            checkAnswer(true)
        }

        binding.falseButton.setOnClickListener { view: View ->
            checkAnswer(false)
        }


        binding.nextButton.setOnClickListener {
            Log.d(TAG, "binding.nextButton.setOnClickListener")
            quizViewModel.moveToNext() //use moveToNext from QuizViewModel class to traverse questions
            updateQuestion()
        }
        updateQuestion()
    }

    private fun updateQuestion(){
        //use currentQuestionText value to set text for next question
        val questionTextResId = quizViewModel.currentQuestionText
        binding.questionTextView.setText(questionTextResId)
    }
    private fun checkAnswer(userAnswer:Boolean) {
        //use currentQuestionAnswer value to check answer
        val correctAnswer = quizViewModel.currentQuestionAnswer
        val messageResId = if (userAnswer == correctAnswer) {
            R.string.correct_toast
        } else {
            R.string.incorrect_toast
        }

        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT)
            .show()
    }
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart() called")
    }
    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume() called")
    }
    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause() called")
    }
    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop() called")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy() called")
    }

}