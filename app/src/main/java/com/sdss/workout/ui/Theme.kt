package com.sdss.workout.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


private val DarkColorPalette = darkColors(
    primary = darkGray,
    primaryVariant = nightGray,
    secondary = teal,
    secondaryVariant = lightTeal,
    onSurface = Color.White,
    onBackground = Color.White,
    onError = errorRed
)

private val LightColorPalette = lightColors(
    primary = blue,
    primaryVariant = darkBlue,
    secondary = pink,
    secondaryVariant = darkPink,
    onSurface = gray,
    onBackground = gray,
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