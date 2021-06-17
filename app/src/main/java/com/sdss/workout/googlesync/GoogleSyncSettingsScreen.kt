package com.sdss.workout.googlesync

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.sdss.workout.R
import com.sdss.workout.ui.screens.ListScreen

@Composable
fun GoogleSyncSettingsScreen(navController: NavController?) {
        ListScreen(
            onPrimaryClick = { /*TODO*/ },
            onSecondaryClick = { /*TODO*/ }
        ) {
            item {
                Row {
                    Text(text = stringResource(id = R.string.google_sync_settings_start_up_item))
                }
            }
        }
}