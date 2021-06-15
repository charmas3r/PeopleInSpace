package com.sdss.workout.main

sealed class MainScreens(val route: String) {
    // see DrawerItems for home screen
    object ProgressScreen : MainScreens("Progress")
    object HistoryScreen : MainScreens("History")
}