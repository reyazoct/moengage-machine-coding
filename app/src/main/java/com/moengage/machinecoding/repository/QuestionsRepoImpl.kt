package com.moengage.machinecoding.repository

import android.content.Context
import com.moengage.machinecoding.model.Question
import com.moengage.machinecoding.model.QuestionType
import com.moengage.machinecoding.network.OnboardingNetworkManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject

class QuestionsRepoImpl : QuestionsRepository {
    override suspend fun fetchQuestions(context: Context): List<Question> {
        return OnboardingNetworkManager.getOnboardingQuestions(context)?.let { inputStream ->
            val string = inputStream.decodeToString()
            val jsonObject = JSONObject(string)
            val questionsJsonArray = jsonObject.getJSONArray("questions")
            val questionsList = mutableListOf<Question>()
            for (i in 0 until questionsJsonArray.length()) {
                val obj = questionsJsonArray.getJSONObject(i)
                val text = obj.getString("text")
                val type = QuestionType.getType(obj.getString("type")) ?: return@let emptyList<Question>()
                val newQuestion = Question(
                    text,
                    type,
                )
                questionsList.add(newQuestion)
            }
            questionsList
        } ?: emptyList<Question>()
    }
}