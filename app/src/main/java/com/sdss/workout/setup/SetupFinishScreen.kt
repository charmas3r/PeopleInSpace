package com.sdss.workout.setup

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.sdss.workout.R
import com.sdss.workout.intro.IntroScreens
import com.sdss.workout.main.MainScreenActivity

@ExperimentalPagerApi
@Composable
fun SetupFinishScreen(navController: NavController?) {
    val context = LocalContext.current

    SetupScreenLayout(
        onPrimaryClick = { navController?.navigate(IntroScreens.SetupFinish.route) },
        secondaryButtonRes = R.string.btn_not_today,
        onSecondaryClick = {
            context.startActivity(Intent(context, MainScreenActivity::class.java))
        },
        onBackClick = { navController?.popBackStack() }) {
        Column(Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.height(16.dp))
            Image(painter = painterResource(id = R.drawable.workout_item_image_1), contentDescription = null)
            Spacer(modifier = Modifier.height(32.dp))
            Text(text = stringResource(id = R.string.setup_finish_intro_desc), textAlign = TextAlign.Center)
        }
    }
}

@ExperimentalPagerApi
@Preview
@Composable
fun SetupFinishPreview() {
    MaterialTheme {
        SetupFinishScreen(null)
    }
}