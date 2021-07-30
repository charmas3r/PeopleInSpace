package com.sdss.workout.workout

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sdss.workout.R
import com.sdss.workout.ui.theme.WorkoutTheme

@ExperimentalMaterialApi
@Composable
fun WorkoutCard(
    workoutName: String,
    workoutDesc: String,
    onClick: () -> Unit
) {
    Card(
        elevation = 6.dp,
        modifier = Modifier.fillMaxWidth().height(88.dp).padding(8.dp),
        onClick = { onClick.invoke() }
    ) {
        Row(
          modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.workout_item_image_1),
                contentDescription = null,
                modifier = Modifier.weight(1f))
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.weight(2f).fillMaxHeight()) {
                Text(text = workoutName, modifier = Modifier.padding(start = 8.dp, top = 8.dp), fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Text(text = workoutDesc, modifier = Modifier.padding(start = 8.dp, bottom = 8.dp))
            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
@Preview
fun ShowWorkoutCard() {
    WorkoutTheme {
        Scaffold {
            WorkoutCard(workoutName = "Test Name", workoutDesc = "Test Desc") {

            }
        }
    }
}