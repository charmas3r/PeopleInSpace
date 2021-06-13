package com.sdss.workout.setup

import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.DropdownMenu
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.sdss.workout.R
import com.sdss.workout.intro.IntroScreens
import com.sdss.workout.main.MainScreenActivity
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@ExperimentalPagerApi
@Composable
fun SetupUnitsScreen(navController: NavController) {
    val context = LocalContext.current
    SetupScreenLayout(
        onPrimaryClick = { navController.navigate(IntroScreens.SetupWeight.route)},
        onSecondaryClick = {
            context.startActivity(Intent(context, MainScreenActivity::class.java))
        },
        onBackClick = { navController.popBackStack() }) {
        var expanded by remember { mutableStateOf(false)}

        Column(Modifier.padding(16.dp)) {
            Text(text = stringResource(id = R.string.setup_units_text))
            Spacer(modifier = Modifier.height(16.dp))
            Row(Modifier.clickable { expanded = !expanded }) {
                Text(text = stringResource(id = R.string.units_std_long))
                Icon(imageVector = Icons.Filled.ArrowDropDown, null)
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = {expanded = false}) {
                    Text("Popup content \nhere", Modifier.padding(24.dp))
                }
            }
        }
    }
}