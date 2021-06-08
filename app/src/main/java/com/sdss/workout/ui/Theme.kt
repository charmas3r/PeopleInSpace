package com.sdss.workout.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable


private val DarkColorPalette = darkColors(
        primary = tealBlue,
        primaryVariant = blue,
        secondary = pinkBiege,
        onError = errorRed
)

private val LightColorPalette = lightColors(
        primary = blue,
        primaryVariant = tealBlue,
        secondary = pinkBiege,
        onError = errorRed
)

@Composable
fun WorkoutTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        content = content
    )
}