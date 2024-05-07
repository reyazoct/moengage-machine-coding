package com.moengage.machinecoding.ui.screens.question

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.moengage.machinecoding.model.Question
import com.moengage.machinecoding.repository.QuestionsRepoImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class QuestionVM(application: Application): AndroidViewModel(application) {

    private val questionsRepo by lazy { QuestionsRepoImpl() }
    private val questionsList = MutableStateFlow<List<Question>>(emptyList())

    private val currentQuestionIndex = MutableStateFlow(0)
    val currentQuestion = questionsList.combine(currentQuestionIndex) { quesList, index ->
        if (index < quesList.size) {
            quesList[index]
        } else {
            null
        }
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(3000),
        null,
    )

    init {
        fetchQuestions()
    }

    fun nextQuestion() {
        viewModelScope.launch {
            val currentIndex = currentQuestionIndex.value
            currentQuestionIndex.emit(currentIndex + 1)
        }
    }

    private fun fetchQuestions() {
        viewModelScope.launch(Dispatchers.IO) {
            val questions = questionsRepo.fetchQuestions(getApplication<Application>().baseContext)
            questionsList.emit(questions)
        }
    }
}