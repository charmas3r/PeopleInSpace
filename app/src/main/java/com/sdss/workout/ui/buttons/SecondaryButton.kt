package com.sdss.workout.ui.buttons

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
internal fun SecondaryButton(
    text: String = "Secondary Button",
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    TextButton(
        colors =  ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.primary
        ),
        onClick = onClick,
        shape = RoundedCornerShape(50),
        modifier = modifier,
        elevation = ButtonDefaults.elevation(
            defaultElevation = 0.dp,
            pressedElevation = 2.dp,
            disabledElevation = 0.dp
        )
    ) {
        Text(text = text, color = MaterialTheme.colors.secondary)
    }
}

@Composable
internal fun SecondaryVariantButton(
    text: String = "Secondary Button",
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    TextButton(
        colors =  ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.primary
        ),
        onClick = onClick,
        shape = RoundedCornerShape(50),
        modifier = modifier,
        elevation = ButtonDefaults.elevation(
            defaultElevation = 0.dp,
            pressedElevation = 2.dp,
            disabledElevation = 0.dp
        )
    ) {
        Text(text = text, color = MaterialTheme.colors.error)
    }
}