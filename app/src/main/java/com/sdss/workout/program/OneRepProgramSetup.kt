package com.sdss.workout.program

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.sdss.workout.R
import com.sdss.workout.ui.buttons.DropdownMenuItemContent
import com.sdss.workout.ui.buttons.PrimaryDropdownMenu


@Composable
fun OneRepMaxProgramSetupScreen(navController: NavController?) {
    ProgramSetupTemplate(
        primaryBtnTitle = stringResource(id = R.string.btn_continue),
        onPrimaryClick = {
            navController?.navigate(ProgramScreens.RepeatCycle.route)
        }
    ) {
        OneRepMaxProgramSetup()
    }
}

@Composable
fun OneRepMaxProgramSetup() {
    val benchState = remember { mutableStateOf(TextFieldValue()) }
    val squatState = remember { mutableStateOf(TextFieldValue()) }
    val deadState = remember { mutableStateOf(TextFieldValue()) }
    val shoulState = remember { mutableStateOf(TextFieldValue()) }

    Column(Modifier.padding(16.dp)) {
        Text(text = stringResource(id = R.string.setup_one_rep_max_text))
        Spacer(modifier = Modifier.height(8.dp))

        Row {
            OutlinedTextField(
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
            OutlinedTextField(
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
            OutlinedTextField(
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
            OutlinedTextField(
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