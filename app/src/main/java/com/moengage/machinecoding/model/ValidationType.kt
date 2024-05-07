package com.moengage.machinecoding.model

import androidx.compose.ui.text.input.KeyboardType

sealed class ValidationType {
    object Email: ValidationType()
    object None: ValidationType()

    val keyboardType: KeyboardType
        get() = when(this) {
            Email -> KeyboardType.Email
            None -> KeyboardType.Text
        }
}