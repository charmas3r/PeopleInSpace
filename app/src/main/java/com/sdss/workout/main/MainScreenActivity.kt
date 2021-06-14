package com.sdss.workout.main

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.sdss.workout.R
import com.sdss.workout.base.BaseActivity
import com.sdss.workout.ui.WorkoutTheme

@ExperimentalPagerApi
class MainScreenActivity : BaseActivity() {
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
                MainScreenLayout()
            }
        }
    }
}

data class BottomNavigationitem(
    val route: String,
    val icon: ImageVector,
    val iconContentDescription: String
)

val bottomNavigationItems = listOf(
    BottomNavigationitem(
        MainScreens.WorkoutScreen.route,
        Icons.Default.Star,
        "Workout"
    ),
    BottomNavigationitem(
        MainScreens.ProgressScreen.route,
        Icons.Filled.Star,
        "Progress"
    ),
    BottomNavigationitem(
        MainScreens.HistoryScreen.route,
        Icons.Filled.Star,
        "History"
    )
)

@Composable
fun MainScreenLayout() {
    WorkoutTheme {
        val navController = rememberNavController()
        Scaffold(
            topBar = {
                TopAppBar(
                    navigationIcon = {
                        IconButton(onClick = {}) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_baseline_menu_24),
                                contentDescription = null
                            )
                        }
                    },
                    title = { Text(text = "Workout App") },
                )
            },
            drawerContent = {
                // Top level composables for header
                Box(modifier = Modifier.height(120.dp)) {
                    Image(painter = painterResource(id = R.drawable.workout_item_image_1), contentDescription = null)
                }
//                DrawerRow()
            },
            bottomBar = {
                BottomNavigation {
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentDestination = navBackStackEntry?.destination

                    bottomNavigationItems.forEach { screen ->
                        BottomNavigationItem(
                            icon = {
                                Icon(
                                    screen.icon,
                                    contentDescription = screen.iconContentDescription
                                )
                            },
                            selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                            onClick = {
                                navController.navigate(screen.route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                }
                            }
                        )
                    }
                }
            }
        ) { paddingValues ->
            NavHost(navController, startDestination = MainScreens.WorkoutScreen.route) {
                composable(MainScreens.WorkoutScreen.route) {
                    Text(text = "Workout Screen")
                }
                composable(MainScreens.ProgressScreen.route) {
                    Text(text = "Progress Screen")
                }
                composable(MainScreens.HistoryScreen.route) {
                    Text(text = "History Screen")
                }
            }
        }
    }
}

