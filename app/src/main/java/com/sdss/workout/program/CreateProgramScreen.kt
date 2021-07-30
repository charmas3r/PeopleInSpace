package com.sdss.workout.program

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.sdss.workout.R
import com.sdss.workout.ui.buttons.PrimaryButton
import com.sdss.workout.ui.lists.cards.ProgramDayCard
import com.sdss.workout.ui.styles.btnCardItemStyle
import com.sdss.workout.ui.theme.WorkoutTheme

@ExperimentalMaterialApi
@Composable
fun CreateProgramScreen(navController: NavController?) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        val textState = remember { mutableStateOf(TextFieldValue()) }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.Edit, contentDescription = null)
            }
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Text(text = "My Program", style = TextStyle(fontSize = 22.sp))
        }
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = textState.value,
            onValueChange = { textState.value = it },
            label = { Text(text = stringResource(id = R.string.programs_create_desc)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            singleLine = false,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(id = R.string.programs_week, 1),
            style = TextStyle(color = MaterialTheme.colors.onBackground),
            modifier = Modifier.padding(start = 8.dp)
        )
        ProgramDayCard(name = "Day 1") {
            navController?.navigate(ProgramScreens.EditDay.route)
        }
        ClickableText(
            modifier = Modifier.padding(start = 8.dp),
            style = btnCardItemStyle(),
            text = AnnotatedString(text = stringResource(id = R.string.program_add_day))
        ) {
            // on "Add Day" click
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            PrimaryButton(
                text = stringResource(id = R.string.program_add_week),
                modifier = Modifier.fillMaxWidth(.75f)
            ) {
                // On Click
            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
@Preview
fun ShowCreateProgramScreen() {
    WorkoutTheme() {
        Scaffold() {
            CreateProgramScreen(navController = null)
        }
    }
}