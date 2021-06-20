package com.sdss.workout.settings

import androidx.annotation.StringRes
import com.sdss.workout.R

sealed class SettingsScreens(val route: String, @StringRes val titleRes: Int) {
    object AppTheme : SettingsScreens("App Theme", R.string.settings_app_theme)
    object Notifications : SettingsScreens("Notifications", R.string.settings_notifications)
    object DataManagement : SettingsScreens("Data Management", R.string.settings_data_mgmt)
    object ReportBug : SettingsScreens("Report Problems", R.string.settings_report_problem)
    object About : SettingsScreens("About", R.string.settings_about)
    object PrivacyPolicy : SettingsScreens("Privacy Policy", R.string.settings_privacy_policy)

    companion object {
        fun getAllSettingsScreens() =
            listOf(
                AppTheme,
                Notifications,
                DataManagement,
                ReportBug,
                About,
                PrivacyPolicy
            )
    }
}