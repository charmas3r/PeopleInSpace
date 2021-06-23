package com.sdss.workout.settings

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.sdss.workout.settings.SettingsScreens.Companion.getAllSettingsScreens
import com.sdss.workout.ui.theme.WorkoutTheme
import com.sdss.workout.ui.lists.ListItem

val items = getAllSettingsScreens()

@Composable
fun GeneralSettingsScreen(navController: NavController?) {
    LazyColumn(modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)) {
        items(items) { item ->
            ListItem(
                titleRes = item.titleRes,
                icon = Icons.Default.KeyboardArrowRight,
                hasArrow = true,
                onListItemClick = {
                    navController?.navigate(item.route)
                }
            )
        }
    }
}

@Preview
@Composable
fun showGeneralSettings() {
    WorkoutTheme {
        Scaffold {
            GeneralSettingsScreen(navController = null)
        }
    }
}
