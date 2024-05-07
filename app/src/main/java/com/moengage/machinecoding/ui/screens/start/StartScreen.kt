package com.moengage.machinecoding.ui.screens.start

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.moengage.machinecoding.R

@Composable
fun StartScreen(
    onNext: () -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxWidth()
    ) {
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp),
            onClick = onNext
        ) {
            Text(text = stringResource(R.string.start))
        }
    }
}