package com.sdss.workout.setup

sealed class Screen(val title: String) {
    object WeightScreen : Screen("Weight")
    object OneRepMaxScreen : Screen("OneRepMax")
    object UnitPreferenceScreen : Screen("UnitPreference")
}