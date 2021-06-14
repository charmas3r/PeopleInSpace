package com.sdss.workout.setup

import android.content.Intent
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.sdss.workout.R
import com.sdss.workout.intro.IntroScreens
import com.sdss.workout.main.MainScreenActivity
import com.sdss.workout.ui.buttons.DropdownMenuItemContent
import com.sdss.workout.ui.buttons.PrimaryDropdownMenu

@ExperimentalPagerApi
@Composable
fun SetupOneRepMaxScreen(navController: NavController?) {
    val context = LocalContext.current
    SetupScreenLayout(
        onPrimaryClick = { navController?.navigate(IntroScreens.SetupFinish.route) },
        onSecondaryClick = {
            context.startActivity(Intent(context, MainScreenActivity::class.java))
        },
        onBackClick = { navController?.popBackStack() }) {
        val benchState = remember { mutableStateOf(TextFieldValue()) }
        val squatState = remember { mutableStateOf(TextFieldValue()) }
        val deadState = remember { mutableStateOf(TextFieldValue()) }
        val shoulState = remember { mutableStateOf(TextFieldValue()) }

        Column(Modifier.padding(16.dp)) {
            Text(text = stringResource(id = R.string.setup_one_rep_max_text))
            Spacer(modifier = Modifier.height(8.dp))

            Row {
                TextField(
                    value = benchState.value,
                    onValueChange = { benchState.value = it },
                    label = { Text(stringResource(id = R.string.lift_bench_press)) },
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
                Spacer(modifier = Modifier.width(16.dp))
                PrimaryDropdownMenu(
                    items = dropDownItems(),
                    menuModifier = Modifier.width(60.dp),
                    firstItemModifier = Modifier
                        .height(60.dp)
                        .padding(start = 16.dp, top = 32.dp)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))
            Row {
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
                Spacer(modifier = Modifier.width(16.dp))
                PrimaryDropdownMenu(
                    items = dropDownItems(),
                    menuModifier = Modifier.width(60.dp),
                    firstItemModifier = Modifier
                        .height(60.dp)
                        .padding(start = 16.dp, top = 32.dp)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))
            Row {
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
                Spacer(modifier = Modifier.width(16.dp))
                PrimaryDropdownMenu(
                    items = dropDownItems(),
                    menuModifier = Modifier.width(60.dp),
                    firstItemModifier = Modifier
                        .height(60.dp)
                        .padding(start = 16.dp, top = 32.dp)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))
            Row {
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
                Spacer(modifier = Modifier.width(16.dp))
                PrimaryDropdownMenu(
                    items = dropDownItems(),
                    menuModifier = Modifier.width(60.dp),
                    firstItemModifier = Modifier
                        .height(60.dp)
                        .padding(start = 16.dp, top = 32.dp)
                )
            }
        }
    }
}

private fun dropDownItems(): List<DropdownMenuItemContent> {
    return listOf(
        DropdownMenuItemContent(
            isFirstPosition = true,
            titleRes = R.string.units_si,
            onClick = {
                Log.d("DropdownMenu", "menu item clicked")
            }
        ),
        DropdownMenuItemContent(
            isFirstPosition = false,
            titleRes = R.string.units_std,
            onClick = {
                Log.d("DropdownMenu", "menu item clicked")
            },
        )
    )
}

@ExperimentalPagerApi
@Preview
@Composable
fun OneRepPreview() {
    MaterialTheme {
        SetupOneRepMaxScreen(null)
    }
}