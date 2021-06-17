package com.sdss.workout.main

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
import com.sdss.workout.drawer.DrawerItems
import com.sdss.workout.googlesync.GoogleSyncScreens
import com.sdss.workout.googlesync.GoogleSyncSettingsScreen
import com.sdss.workout.googlesync.GoogleSyncSignInScreen
import com.sdss.workout.ui.WorkoutTheme
import com.sdss.workout.ui.drawer.DrawerRow
import com.sdss.workout.ui.styles.headerTextStyle
import com.sdss.workout.util.shouldShowBottomBarByCurrentRoute
import kotlinx.coroutines.launch

@ExperimentalPagerApi
class MainScreenActivity : BaseActivity() {
    @ExperimentalMaterialApi
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
        DrawerItems.Home.route,
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

val navDrawerItems = DrawerItems.getAllDrawerItems()

@ExperimentalPagerApi
@ExperimentalMaterialApi
@Composable
fun MainScreenLayout() {
    WorkoutTheme {
        val navController = rememberNavController()
        val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
        val scope = rememberCoroutineScope()
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        Scaffold(
            topBar = {
                TopAppBar(
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch {
                                scaffoldState.drawerState.open()
                            }
                        }) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_baseline_menu_24),
                                contentDescription = null,
                            )
                        }
                    },
                    title = {
                        currentDestination?.route?.let { Text(text = it) }
                    },
                )
            },
            scaffoldState = scaffoldState,
            drawerContent = {
                Box(
                    modifier = Modifier
                        .height(180.dp)
                        .fillMaxWidth()
                        .background(MaterialTheme.colors.primary)
                ) {
                    // Top level composables for header

                }
                navDrawerItems.forEach { drawerItem ->
                    if (drawerItem.isHeader) {
                        DrawerRow(
                            isListItem = false,
                            rowContent = {
                                Text(
                                    text = stringResource(id = R.string.drawer_general),
                                    modifier = Modifier.padding(
                                        start = 16.dp,
                                        top = 4.dp,
                                        bottom = 4.dp
                                    ),
                                    style = headerTextStyle()
                                )
                            }
                        )
                    } else if (drawerItem.isSeperator) {
                        DrawerRow(
                            isListItem = false,
                            rowContent = {
                                Divider(
                                    color = MaterialTheme.colors.onSurface,
                                    thickness = 1.dp,
                                )
                            }
                        )
                    } else {
                        DrawerRow(
                            icon = drawerItem.icon,
                            titleRes = drawerItem.titleRes!!,
                            selected = currentDestination?.hierarchy?.any { it.route == drawerItem.route } == true,
                            onClick = {
                                scope.launch {
                                    scaffoldState.drawerState.close()
                                }
                                navController.navigate(drawerItem.route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        )
                    }

                }
            },
            bottomBar = {
                if (shouldShowBottomBarByCurrentRoute(currentDestination?.route)) {
                    BottomNavigation {
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
            }
        ) { paddingValues ->
            NavHost(navController, startDestination = DrawerItems.Home.route) {
                composable(DrawerItems.Home.route) {
                    Text(text = "Workout Screen")
                }
                composable(MainScreens.ProgressScreen.route) {
                    Text(text = "Progress Screen")
                }
                composable(MainScreens.HistoryScreen.route) {
                    Text(text = "History Screen")
                }
                composable(DrawerItems.WorkoutPrograms.route) {
                    Text(text = "Programs Screen")
                }

                composable(DrawerItems.Settings.route) {
                    Text(text = "Settings Screen")
                }
                composable(DrawerItems.RateThisApp.route) {
                    Text(text = "RateThisApp Screen")
                }
                composable(DrawerItems.Purchases.route) {
                    Text(text = "Purchases Screen")
                }
                composable(DrawerItems.FAQ.route) {
                    Text(text = "FAQ Screen")
                }

                // Google Sync
                composable(DrawerItems.GoogleSync.route) {
                    GoogleSyncSignInScreen(navController = navController)
                }
                composable(GoogleSyncScreens.Settings.route) {
                    GoogleSyncSettingsScreen(navController = navController)
                }
            }
        }
    }
}

