package com.sdss.workout.intro

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.sdss.workout.R
import com.sdss.workout.base.BaseActivity
import com.sdss.workout.setup.SetupCurrentWeightScreen
import com.sdss.workout.ui.WorkoutTheme
import com.sdss.workout.ui.buttons.PrimaryButton
import com.sdss.workout.workout.Screen

@ExperimentalPagerApi
class IntroActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProvideWindowInsets {
                val systemUiController = rememberSystemUiController()
                val useDarkIcons = MaterialTheme.colors.isLight

                SideEffect {
                    // Update all of the system bar colors to be transparent, and use
                    // dark icons if we're in light theme
                    systemUiController.setSystemBarsColor(
                        color = Color.Transparent,
                        darkIcons = useDarkIcons
                    )

                    // setStatusBarsColor() and setNavigationBarsColor() also exist
                }

                IntroLayout()
            }
        }
    }
}

data class IntroNavItem(
    val route: String
)

val introItems = listOf(
    IntroNavItem(route = IntroScreen.WelcomeCarousel.title),
    IntroNavItem(route = IntroScreen.WeightScreen.title),
    IntroNavItem(route = IntroScreen.UnitPreferenceScreen.title),
    IntroNavItem(route = IntroScreen.OneRepMaxScreen.title),
    IntroNavItem(route = IntroScreen.FinishScreen.title)
)

@ExperimentalPagerApi
@Composable
fun IntroLayout() {
    WorkoutTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize()
        ) {
            val navController = rememberNavController()



            NavHost(navController, startDestination = IntroScreen.WelcomeCarousel.title) {
                composable(IntroScreen.WeightScreen.title) {
                    // Screen
                }
                composable(IntroScreen.UnitPreferenceScreen.title) {
                    // Screen
                }
                composable(IntroScreen.OneRepMaxScreen.title) {
                    //screen
                }
                composable(IntroScreen.FinishScreen.title) {
                    //screen
                }
            }


        }
    }
}

@ExperimentalPagerApi
@Preview
@Composable
fun DefaultPreview() {
    MaterialTheme {
        IntroLayout()
    }
}