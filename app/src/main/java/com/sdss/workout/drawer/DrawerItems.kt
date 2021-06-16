package com.sdss.workout.drawer

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import com.sdss.workout.R

sealed class DrawerItems(
    val isSeperator: Boolean = false,
    val isHeader: Boolean = false,
    @StringRes val titleRes: Int? = null,
    val icon: ImageVector? = null,
    val route: String = "Home"
) {
    object Home : DrawerItems(
        titleRes = R.string.drawer_home,
        icon = Icons.Filled.Home,
        route = "Home Drawer Item"
    )

    object WorkoutPrograms : DrawerItems(
        titleRes = R.string.drawer_program_setup,
        icon = Icons.Filled.Home,
        route = "Workout Programs Drawer Item"
    )

    object GoogleSync : DrawerItems(
        titleRes = R.string.drawer_google_sync,
        icon = Icons.Filled.Home,
        route = "Google Sync Drawer Item"
    )

    object Seperator : DrawerItems(
        isSeperator = true
    )

    object SettingsHeader : DrawerItems(
        titleRes = R.string.drawer_general,
        isHeader = true
    )

    object Settings : DrawerItems(
        titleRes = R.string.drawer_settings,
        icon = Icons.Filled.Home,
        route = "Settings Drawer Item"
    )

    object RateThisApp : DrawerItems(
        titleRes = R.string.drawer_rate_this_app,
        icon = Icons.Filled.Home,
        route = "Rate This App Drawer Item"
    )

    object Purchases : DrawerItems(
        titleRes = R.string.drawer_purchases,
        icon = Icons.Filled.Home,
        route = "Purchases Drawer Item"
    )

    object FAQ : DrawerItems(
        titleRes = R.string.drawer_faq,
        icon = Icons.Filled.Home,
        route = "FAQ Drawer Item"
    )

    companion object {
        fun getAllDrawerItems(): List<DrawerItems> {
            return listOf(
                Home,
                WorkoutPrograms,
                GoogleSync,
                Seperator,
                SettingsHeader,
                Settings,
                RateThisApp,
                Purchases,
                FAQ
            )
        }
    }
}

