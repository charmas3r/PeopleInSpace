package com.sdss.workout.program

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.sdss.workout.ui.theme.WorkoutTheme

@Composable
fun EditDayProgramScreen(navController: NavController?) {

}

@Composable
@Preview
fun ShowEditProgramScreen() {
    WorkoutTheme() {
        Scaffold {
            EditDayProgramScreen(navController = null)
        }
    }
}
