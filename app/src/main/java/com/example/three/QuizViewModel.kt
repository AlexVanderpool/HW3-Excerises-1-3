package com.example.three

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.three.R

private const val TAG = "QuizViewModel"
const val CURRENT_INDEX_KEY = "CURRENT_INDEX_KEY"
class QuizViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {

    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true)
    )

    var currentIndex: Int
        //use a getter and setter to get and set CURRENT_INDEX_KEY (if nothing set to 0)
        get() = savedStateHandle.get(CURRENT_INDEX_KEY) ?: 0
        set(value) = savedStateHandle.set(CURRENT_INDEX_KEY, value)

    val currentQuestionAnswer: Boolean
        get() = questionBank[currentIndex].answer //use getter to obtain current answer

    val currentQuestionText: Int
        get() = questionBank[currentIndex].textResId //use getter to obtain current question text

    fun moveToNext() {
        Log.d(TAG, "Updating question text")
        currentIndex = (currentIndex + 1) % questionBank.size
        Log.d(TAG, "Current question index: $currentIndex")

    }
}