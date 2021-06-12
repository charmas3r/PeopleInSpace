package com.sdss.workout.setup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.sdss.workout.R
import com.sdss.workout.intro.IntroScreens
import com.sdss.workout.main.MainScreens

@Composable
fun SetupCurrentWeightScreen(navController: NavController) {
    SetupScreenLayout(
        onPrimaryClick = { navController.navigate(IntroScreens.SetupUnits.route) },
        onSecondaryClick = {
            navController.navigate(MainScreens.WorkoutScreen.route) {
            }
        },
        onBackClick = { navController.popBackStack() }) {
        Column(Modifier.padding(16.dp)) {
            Text(text = stringResource(id = R.string.setup_weight_text))
        }
    }
}