package com.moengage.machinecoding.repository

import android.content.Context
import com.moengage.machinecoding.model.Question

interface QuestionsRepository {
    suspend fun fetchQuestions(context: Context): List<Question>
}