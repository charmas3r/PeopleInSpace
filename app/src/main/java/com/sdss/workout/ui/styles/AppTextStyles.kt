package com.sdss.workout.ui.styles

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.sdss.workout.R

fun titleTextStyle() = TextStyle(
    fontSize = 18.sp
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

fun captureTitleStyle() = TextStyle (
    fontSize = 18.sp,
    fontFamily = FontFamily(
        Font(R.font.capture)
    )
)

fun captureDescStyle() = TextStyle (
    fontSize = 14.sp,
    fontFamily = FontFamily(
        Font(R.font.capture)
    )
)

@Composable
fun btnCardItemStyle() = MaterialTheme.typography.body1.copy(
    fontWeight = FontWeight.Normal,
    color = MaterialTheme.colors.secondary
)

@Composable
fun overviewCardStyle() = TextStyle(
    fontSize = 12.sp
)