package com.sdss.workout.program

sealed class ProgramScreens(val route: String) {
    object OneRepMax: ProgramScreens("Set 1RM")
    object RepeatCycle: ProgramScreens("Repeat program")
    object Overview: ProgramScreens("Overview")
    object Create: ProgramScreens("Create Program")
    object EditDay: ProgramScreens("Edit Workout")
}