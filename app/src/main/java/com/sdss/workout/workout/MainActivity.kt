package com.sdss.workout.workout

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.*
import com.sdss.workout.R
import com.sdss.workout.base.BaseActivity
import com.sdss.workout.ui.WorkoutTheme

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainLayout()
        }
    }
}


sealed class Screen(val title: String) {
    object WorkoutScreen : Screen("Workout")
    object ProgressScreen : Screen("Progress")
    object HistoryScreen : Screen("History")
}

data class BottomNavigationitem(
    val route: String,
    val icon: ImageVector,
    val iconContentDescription: String
)

val bottomNavigationItems = listOf(
    BottomNavigationitem(
        Screen.WorkoutScreen.title,
        Icons.Default.Star,
        "Workout"
    ),
    BottomNavigationitem(
        Screen.ProgressScreen.title,
        Icons.Filled.Star,
        "Progress"
    ),
    BottomNavigationitem(
        Screen.HistoryScreen.title,
        Icons.Filled.Star,
        "History"
    )
)

@Composable
fun MainLayout() {
    val navController = rememberNavController()

    WorkoutTheme {
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
                    title = { Text(text = "Jetpack Compose") },
                )
            },

            bottomBar = {
                BottomNavigation {
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentRoute = navBackStackEntry?.arguments?.getString(KEY_ROUTE)

                    bottomNavigationItems.forEach { bottomNavigationitem ->
                        BottomNavigationItem(
                            icon = {
                                Icon(
                                    bottomNavigationitem.icon,
                                    contentDescription = bottomNavigationitem.iconContentDescription
                                )
                            },
                            selected = currentRoute == bottomNavigationitem.route,
                            onClick = {
                                navController.navigate(bottomNavigationitem.route) {
                                    popUpTo = navController.graph.startDestination
                                    launchSingleTop = true
                                }
                            }
                        )
                    }
                }
            }
        ) { paddingValues ->
            NavHost(navController, startDestination = Screen.WorkoutScreen.title) {
                composable(Screen.WorkoutScreen.title) {
                    // Screen
                }
                composable(Screen.ProgressScreen.title) {
                    // Screen
                }
                composable(Screen.HistoryScreen.title) {
                    //screen
                }
            }
        }
    }
}


@Preview
@Composable
fun DefaultPreview() {
    MaterialTheme {
        // Preview
    }
}