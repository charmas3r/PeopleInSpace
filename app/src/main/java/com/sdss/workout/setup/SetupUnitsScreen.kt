package com.sdss.workout.setup

import android.content.Intent
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
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
fun SetupUnitsScreen(navController: NavController) {
    val context = LocalContext.current

    SetupScreenLayout(
        onPrimaryClick = { navController.navigate(IntroScreens.SetupWeight.route) },
        onSecondaryClick = {
            context.startActivity(Intent(context, MainScreenActivity::class.java))
        },
        onBackClick = { navController.popBackStack() }) {

        Column(Modifier.padding(16.dp)) {
            Text(text = stringResource(id = R.string.setup_units_text))
            Spacer(modifier = Modifier.height(16.dp))
            PrimaryDropdownMenu(items = dropDownItems(), modifier = Modifier.width(120.dp))
        }
    }
}

private fun dropDownItems(): List<DropdownMenuItemContent> {
    return listOf(
        DropdownMenuItemContent(
            isFirstPosition = true,
            titleRes = R.string.units_std_long,
            onClick = {
                Log.d("DropdownMenu", "menu item clicked")
            }
        ),
        DropdownMenuItemContent(
            isFirstPosition = false,
            titleRes = R.string.units_si_long,
            onClick = {
                Log.d("DropdownMenu", "menu item clicked")
            },
        )
    )
}