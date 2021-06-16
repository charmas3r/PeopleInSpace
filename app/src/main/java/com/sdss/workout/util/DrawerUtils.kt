package com.sdss.workout.util

import com.sdss.workout.drawer.DrawerItems
import com.sdss.workout.main.MainScreens

fun shouldShowBottomBarByCurrentRoute(currentRoute: String?) =
    currentRoute == DrawerItems.Home.route
            || currentRoute == MainScreens.ProgressScreen.route
            || currentRoute == MainScreens.HistoryScreen.route

