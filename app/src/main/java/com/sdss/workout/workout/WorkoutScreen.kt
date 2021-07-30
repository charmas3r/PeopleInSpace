package com.sdss.workout.workout

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sdss.workout.ui.theme.WorkoutTheme

@ExperimentalMaterialApi
@Composable
fun WorkoutScreen(onClick: () -> Unit) {
    LazyColumn(Modifier.fillMaxSize().padding(8.dp)) {
        item {
            // For now, just a test item
            WorkoutCard(
                workoutName = "Bench Press",
                workoutDesc = "Some Description") {
                onClick.invoke()
            }
        }
    }
}
