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
import com.sdss.workout.MainScreen
import com.sdss.workout.R
import com.sdss.workout.intro.IntroScreens

@Composable
fun SetupOneRepMaxScreen(navController: NavController) {
    val context = LocalContext.current
    SetupScreenLayout(
        onPrimaryClick = { navController.navigate(IntroScreens.SetupFinish.route) },
        onSecondaryClick = {
            // clear back stack here.
            navController.navigate(MainScreen.WorkoutMainScreen.route)
        },
        onBackClick = { navController.popBackStack() }) {
        Column(Modifier.padding(16.dp)) {
            Text(text = stringResource(id = R.string.setup_one_rep_max_text))
        }
    }
}