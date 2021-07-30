package com.sdss.workout.navigation

import com.sdss.workout.program.ProgramScreens

fun shouldShowBackArrowInTopAppBar(currentRoute: String) =
    currentRoute == ProgramScreens.EditDay.route

