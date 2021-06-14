package com.sdss.workout.ui.styles

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

fun titleTextStyle() = TextStyle(
    fontSize = 18.sp,
    color = Color.Black
)

@Composable
fun selectedTextStyle() = MaterialTheme.typography.body1.copy(
    fontWeight = FontWeight.Bold,
    color = MaterialTheme.colors.secondary
)

@Composable
fun bodyTextStyle() = MaterialTheme.typography.body1.copy(
        fontWeight = FontWeight.Normal,
        color = MaterialTheme.colors.onSurface
)

fun headerTextStyle() = TextStyle(
    fontSize = 12.sp
)