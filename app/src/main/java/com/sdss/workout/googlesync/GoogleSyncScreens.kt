package com.sdss.workout.googlesync

sealed class GoogleSyncScreens(val route: String) {
    object SignIn: GoogleSyncScreens("Google Sync Sign In")
    object Settings: GoogleSyncScreens("Google Sync Settings")
}