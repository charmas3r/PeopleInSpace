package com.sdss.workout.settings

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sdss.workout.R
import com.sdss.workout.ui.screens.ListItem

@Composable
fun DataMgmtSettingsScreen() {
    LazyColumn(modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)) {
        item {
            ListItem(
                titleRes = R.string.settings_data_mgmt_clear_data,
                onListItemClick = {
                    // perform action
                }
            )
        }
        item {
            ListItem(
                titleRes = R.string.settings_import_csv,
                onListItemClick = {
                    // perform action
                }
            )
        }
        item {
            ListItem(
                titleRes = R.string.settings_export_csv,
                onListItemClick = {
                    // perform action
                }
            )
        }
    }
}
