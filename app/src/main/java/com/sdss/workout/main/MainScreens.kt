package com.sdss.workout.main

sealed class MainScreens(val route: String) {
    object EntryMain: MainScreens("Main")
    object WorkoutScreen : MainScreens("Workout")
    object ProgressScreen : MainScreens("Progress")
    object HistoryScreen : MainScreens("History")
}