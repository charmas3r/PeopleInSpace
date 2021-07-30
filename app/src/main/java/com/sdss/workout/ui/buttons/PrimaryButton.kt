package com.sdss.workout.ui.buttons

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
internal fun PrimaryButton(
    text: String = "Primary Button",
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        colors =  ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.secondary
        ),
        onClick = onClick,
        shape = RoundedCornerShape(50),
        modifier = modifier
    ) {
        Text(text = text)
    }
}