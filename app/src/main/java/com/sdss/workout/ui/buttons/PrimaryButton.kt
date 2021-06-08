package com.sdss.workout.ui.buttons

import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
internal fun PrimaryButton(
    modifier: Modifier = Modifier,
    action: () -> Unit)
{
    Button(
        onClick = action

    )
}