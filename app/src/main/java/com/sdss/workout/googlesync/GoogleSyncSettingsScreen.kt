package com.sdss.workout.googlesync

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.sdss.workout.R
import com.sdss.workout.ui.screens.ListItem
import com.sdss.workout.ui.screens.ListScreen

@Composable
fun GoogleSyncSettingsScreen(navController: NavController?) {
        ListScreen(
            onPrimaryClick = { /*TODO*/ },
            onSecondaryClick = { /*TODO*/ }
        ) {
            item {
                ListItem(
                    titleRes = R.string.google_sync_settings_start_up_item,
                    descRes = R.string.google_sync_settings_start_up_desc,
                    hasSwitch = true,
                    onSwitchClick = {
                        // perform action
                    }
                )
            }

            item {
                ListItem(
                    titleRes = R.string.google_sync_settings_sync_item,
                    onListItemClick = {
                        // perform action
                    }
                )
            }
        }
}