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
import com.google.android.material.color.MaterialColors
import com.sdss.workout.R
import com.sdss.workout.intro.IntroScreens
import com.sdss.workout.main.MainScreenActivity

@ExperimentalPagerApi
@Composable
fun SetupCurrentWeightScreen(navController: NavController) {
    val context = LocalContext.current

    SetupScreenLayout(
        onPrimaryClick = { navController.navigate(IntroScreens.SetupOneRepMax.route) },
        onSecondaryClick = {
            context.startActivity(Intent(context, MainScreenActivity::class.java))
        },
        onBackClick = { navController.popBackStack() }) {
        val textState = remember { mutableStateOf(TextFieldValue()) }

        Column(Modifier.padding(16.dp)) {
            Text(text = stringResource(id = R.string.setup_weight_text))
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = textState.value,
                onValueChange = { textState.value = it },
                label = { Text(stringResource(id = R.string.tf_weight)) },
                modifier = Modifier
                    .width(88.dp),
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