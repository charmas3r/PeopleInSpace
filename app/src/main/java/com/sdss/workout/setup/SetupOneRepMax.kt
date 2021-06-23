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
import com.sdss.workout.program.OneRepMaxProgramSetup
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
        OneRepMaxProgramSetup()
    }
}


@ExperimentalPagerApi
@Preview
@Composable
fun OneRepPreview() {
    MaterialTheme {
        SetupOneRepMaxScreen(null)
    }
}