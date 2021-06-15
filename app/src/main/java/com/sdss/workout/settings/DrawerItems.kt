package com.sdss.workout.settings

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
    val route: String = "DrawerHome"
) {
    object Home : DrawerItems(
        titleRes = R.string.drawer_home,
        icon = Icons.Filled.Home,
        route = "DrawerHome"
    )

    object ProgramSetup : DrawerItems(
        titleRes = R.string.drawer_program_setup,
        icon = Icons.Filled.Home,
        route = "ProgramSetup"
    )

    object GoogleSync : DrawerItems(
        titleRes = R.string.drawer_google_sync,
        icon = Icons.Filled.Home,
        route = "GoogleSync"
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
        route = "Settings"
    )

    object RateThisApp : DrawerItems(
        titleRes = R.string.drawer_rate_this_app,
        icon = Icons.Filled.Home,
        route = "RateThisApp"
    )

    object Purchases : DrawerItems(
        titleRes = R.string.drawer_purchases,
        icon = Icons.Filled.Home,
        route = "Purchases"
    )

    object FAQ : DrawerItems(
        titleRes = R.string.drawer_faq,
        icon = Icons.Filled.Home,
        route = "FAQ"
    )

    companion object {
        fun getAllDrawerItems(): List<DrawerItems> {
            return listOf(
                Home,
                ProgramSetup,
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

