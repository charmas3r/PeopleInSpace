package com.sdss.workout.intro

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.sdss.workout.base.BaseActivity
import com.sdss.workout.setup.SetupCurrentWeightScreen
import com.sdss.workout.setup.SetupFinishScreen
import com.sdss.workout.setup.SetupOneRepMaxScreen
import com.sdss.workout.setup.SetupUnitsScreen
import com.sdss.workout.ui.theme.WorkoutTheme
import com.sdss.workout.ui.theme.nightGray
import com.sdss.workout.ui.theme.white

@ExperimentalPagerApi
class IntroActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProvideWindowInsets {
                val systemUiController = rememberSystemUiController()
                val useDarkIcons = MaterialTheme.colors.isLight
                val systemBarColor = if (useDarkIcons) nightGray else white
                SideEffect {
                    systemUiController.setSystemBarsColor(
                        color = systemBarColor,
                        darkIcons = useDarkIcons
                    )
                }
                IntroNavigation()
            }
        }
    }
}

@ExperimentalPagerApi
@Composable
fun IntroNavigation() {
    WorkoutTheme {
        val navController = rememberNavController()
        NavHost(navController, startDestination = IntroScreens.WelcomeCarousel.route) {
            composable(IntroScreens.WelcomeCarousel.route) {
                WelcomeCarousel(navController = navController)
            }
            composable(IntroScreens.SetupWeight.route) {
                SetupCurrentWeightScreen(navController = navController)
            }
            composable(IntroScreens.SetupUnits.route) {
                SetupUnitsScreen(navController = navController)
            }
            composable(IntroScreens.SetupOneRepMax.route) {
                SetupOneRepMaxScreen(navController = navController)
            }
            composable(IntroScreens.SetupFinish.route) {
                SetupFinishScreen(navController = navController)
            }
        }
    }
}


@ExperimentalPagerApi
@Preview
@Composable
fun DefaultPreview() {
    MaterialTheme {
        IntroNavigation()
    }
}