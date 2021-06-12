package com.sdss.workout.intro

sealed class IntroScreen(val title: String){
    object WelcomeCarousel: IntroScreen("IntroCarousel")
    object WeightScreen : IntroScreen("Weight")
    object OneRepMaxScreen : IntroScreen("OneRepMax")
    object UnitPreferenceScreen : IntroScreen("UnitPreference")
    object FinishScreen: IntroScreen("Finish")
}
