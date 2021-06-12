package com.sdss.workout

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.sdss.workout.base.BaseActivity
import com.sdss.workout.intro.IntroScreens
import com.sdss.workout.intro.WelcomeCarousel
import com.sdss.workout.setup.SetupCurrentWeightScreen
import com.sdss.workout.setup.SetupFinishScreen
import com.sdss.workout.setup.SetupOneRepMaxScreen
import com.sdss.workout.setup.SetupUnitsScreen
import com.sdss.workout.ui.WorkoutTheme

@ExperimentalPagerApi
class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProvideWindowInsets {
                val systemUiController = rememberSystemUiController()
                val useDarkIcons = MaterialTheme.colors.isLight
                SideEffect {
                    systemUiController.setSystemBarsColor(
                        color = Color.Transparent,
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