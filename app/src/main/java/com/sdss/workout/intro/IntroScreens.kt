package com.sdss.workout.intro

sealed class IntroScreens(val route: String) {
    object WelcomeCarousel: IntroScreens("welcomeCarousel")
    object SetupWeight: IntroScreens("setupWeight")
    object SetupUnits: IntroScreens("setupUnits")
    object SetupOneRepMax: IntroScreens("setupOneRepMax")
    object SetupFinish: IntroScreens("setupFinish")
}