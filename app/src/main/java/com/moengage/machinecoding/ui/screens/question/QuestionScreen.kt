package com.moengage.machinecoding.ui.screens.question

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun QuestionScreen(questionsVM: QuestionVM) {

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp)
    ) {
        val currentQuestion by questionsVM.currentQuestion.collectAsState()

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = currentQuestion?.name ?: ""
        )
        Spacer(Modifier.height(12.dp))
        BasicTextField(
            modifier = Modifier.fillMaxWidth(),
            value = "",
            onValueChange = {},
            keyboardOptions = KeyboardOptions(
                keyboardType = currentQuestion?.type?.keyboardType ?: KeyboardType.Text
            )
        )
    }
}