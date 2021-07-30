package com.sdss.workout.program

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.sdss.workout.R
import com.sdss.workout.drawer.DrawerItems
import com.sdss.workout.ui.buttons.DropdownMenuItemContent
import com.sdss.workout.ui.buttons.PrimaryDropdownMenu

@Composable
fun RepeatProgramSetupScreen(navController: NavController?) {
    ProgramSetupTemplate(
        primaryBtnTitle = stringResource(id = R.string.programs_finish_btn),
        onPrimaryClick = {
            navController?.navigate(DrawerItems.Home.route) {
                popUpTo(DrawerItems.Home.route)
            }
        }
    ) {
        RepeatProgramSetupLayout()
    }
}

@Composable
fun RepeatProgramSetupLayout() {
    Column(Modifier.padding(16.dp)) {
        Text(text = stringResource(id = R.string.programs_repeat_title))
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            PrimaryDropdownMenu(
                items = dropDownItems(),
                menuModifier = Modifier.width(120.dp),
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
            titleRes = R.string.programs_no_repeat,
            onClick = {
                Log.d("DropdownMenu", "menu item clicked")

            }
        ),
        DropdownMenuItemContent(
            isFirstPosition = false,
            titleRes = R.string.programs_repeats_one_time,
            onClick = {
                Log.d("DropdownMenu", "menu item clicked")
            },
        ),
        DropdownMenuItemContent(
            isFirstPosition = false,
            titleRes = R.string.programs_repeat_two_times,
            onClick = {
                Log.d("DropdownMenu", "menu item clicked")
            },
        ),
        DropdownMenuItemContent(
            isFirstPosition = false,
            titleRes = R.string.programs_repeat_three_times,
            onClick = {
                Log.d("DropdownMenu", "menu item clicked")
            },
        ),
        DropdownMenuItemContent(
            isFirstPosition = false,
            titleRes = R.string.programs_repeat_four_times,
            onClick = {
                Log.d("DropdownMenu", "menu item clicked")
            },
        )
    )
}