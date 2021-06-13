package com.sdss.workout.setup

import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.sdss.workout.R
import com.sdss.workout.WorkoutActivity
import com.sdss.workout.intro.IntroScreens

@ExperimentalPagerApi
@Composable
fun SetupOneRepMaxScreen(navController: NavController) {
    val context = LocalContext.current
    SetupScreenLayout(
        onPrimaryClick = { navController.navigate(IntroScreens.SetupFinish.route) },
        onSecondaryClick = {
            // clear back stack here.
            context.startActivity(Intent(context, WorkoutActivity::class.java))
        },
        onBackClick = { navController.popBackStack() }) {
        val benchState = remember { mutableStateOf(TextFieldValue()) }
        val squatState = remember { mutableStateOf(TextFieldValue()) }
        val deadState = remember { mutableStateOf(TextFieldValue()) }
        val shoulState = remember { mutableStateOf(TextFieldValue()) }

        Column(Modifier.padding(16.dp)) {
            Text(text = stringResource(id = R.string.setup_one_rep_max_text))
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = benchState.value,
                onValueChange = { benchState.value = it },
                label = { Text(stringResource(id = R.string.lift_bench_press))},
                modifier = Modifier
                    .fillMaxWidth(.5f),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = squatState.value,
                onValueChange = { squatState.value = it },
                label = { Text(stringResource(id = R.string.lift_squats)) },
                modifier = Modifier
                    .fillMaxWidth(.5f),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = deadState.value,
                onValueChange = { deadState.value = it },
                label = { Text(stringResource(id = R.string.lift_deadlifts)) },
                modifier = Modifier
                    .fillMaxWidth(.5f),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = shoulState.value,
                onValueChange = { shoulState.value = it },
                label = { Text(stringResource(id = R.string.lift_shoulder_press)) },
                modifier = Modifier
                    .fillMaxWidth(.5f),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent
                )
            )
        }
    }
}