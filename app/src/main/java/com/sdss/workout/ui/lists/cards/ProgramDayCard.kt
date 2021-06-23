package com.sdss.workout.ui.lists.cards

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sdss.workout.ui.theme.WorkoutTheme

@ExperimentalMaterialApi
@Composable
fun ProgramDayCard(
    name: String,
    onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .height(48.dp),
        border = BorderStroke(1.dp, MaterialTheme.colors.onBackground),
        elevation = 2.dp,
        backgroundColor = MaterialTheme.colors.surface,
        onClick = { onClick.invoke() }) {
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,) {
            Text(
                text = name,
                style = TextStyle(fontSize = 16.sp),
                modifier = Modifier.padding(start = 8.dp)
            )
        }
        Row(horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = null,
                modifier = Modifier.padding(end = 4.dp))
        }
    }
}

@ExperimentalMaterialApi
@Preview
@Composable
fun ShowProgramDayCard() {
    WorkoutTheme {
        Scaffold {
            ProgramDayCard(name = "Day 1") {
                // on click
            }
        }
    }
}