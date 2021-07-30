package com.sdss.workout.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = nightGray,
    primaryVariant = Color.Black,
    secondary = teal,
    secondaryVariant = lightTeal,
    onSurface = Color.White,
    onBackground = Color.White,
    onPrimary = white,
    onError = errorRed
)

private val LightColorPalette = lightColors(
    primary = white,
    primaryVariant = white,
    onPrimary = text,
    onSecondary = white,
    secondary = blue,
    secondaryVariant = darkBlue,
    onSurface = text,
    onBackground = lightText,
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