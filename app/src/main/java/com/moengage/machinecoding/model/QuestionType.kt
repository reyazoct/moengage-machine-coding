package com.moengage.machinecoding.model

import androidx.compose.ui.text.input.KeyboardType

sealed class QuestionType {
    data class QtString(val validationType: ValidationType) : QuestionType()
    object QtInteger : QuestionType()

    val keyboardType: KeyboardType
        get() = when(this) {
            QtInteger -> KeyboardType.Number
            is QtString -> validationType.keyboardType
        }

    companion object {
        fun getType(string: String): QuestionType? {
            return when (string) {
                "string" -> QtString(ValidationType.None)
                "integer" -> QtInteger
                "email" -> QtString(ValidationType.Email)
                else -> null
            }
        }
    }
}