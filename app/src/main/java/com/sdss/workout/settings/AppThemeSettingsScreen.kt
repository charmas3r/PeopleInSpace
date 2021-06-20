package com.sdss.workout.settings

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sdss.workout.R
import com.sdss.workout.settings.AppThemeOptions.Companion.getOptions
import com.sdss.workout.ui.screens.ListItem

@Composable
fun AppThemeSettingsScreen() {
    LazyColumn(modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)) {
        items(getOptions()) { item ->
            ListItem(
                titleRes = item.titleRes,
                icon = Icons.Default.Check,
                onListItemClick = {
                    when (item.id) {
                        0 -> {
                            // set default theme
                        }
                        1 -> {
                            // set light theme only
                        }
                        2 -> {
                            // set dark theme only
                        }
                    }
                }
            )
        }
    }
}

sealed class AppThemeOptions(val id: Int, @StringRes val titleRes: Int) {
    object Default: AppThemeOptions(0,  R.string.settings_app_theme_default)
    object LightTheme: AppThemeOptions(1,  R.string.settings_app_theme_light)
    object DarkTheme: AppThemeOptions(2, R.string.settings_app_theme_dark)
    companion object {
        fun getOptions() =
            listOf(
                Default,
                LightTheme,
                DarkTheme
            )
    }
}
