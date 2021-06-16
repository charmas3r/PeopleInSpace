package com.sdss.workout.drawer

sealed class DrawerScreens(val route: String) {
    object GoogleSyncSignIn : DrawerScreens("GoogleSyncSignIn")
    object GoogleSyncSettings : DrawerScreens("GoogleSyncSettings")
}