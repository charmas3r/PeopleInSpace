package com.sdss.workout.program

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import com.sdss.workout.R
import com.sdss.workout.ui.lists.cards.CardItem
import kotlinx.coroutines.launch

@ExperimentalPagerApi
@Composable
fun InitialProgramSetupScreen(
    navController: NavController?
) {
    Box(
        Modifier
            .fillMaxSize()
    ) {
        Column {
            val scope = rememberCoroutineScope()
            val pagerState = rememberPagerState(pageCount = 4)
            ScrollableTabRow(
                // Our selected tab is our current page
                selectedTabIndex = pagerState.currentPage,
                // Override the indicator, using the provided pagerTabIndicatorOffset modifier
                indicator = { tabPositions ->
                    TabRowDefaults.Indicator(
                        color = MaterialTheme.colors.secondary,
                        modifier = Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
                    )
                }
            ) {
                Tab(
                    selectedContentColor = MaterialTheme.colors.secondary,
                    text = { Text("Beginner") },
                    selected = pagerState.currentPage == 0,
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(0)
                        }
                    },
                )
                Tab(
                    selectedContentColor = MaterialTheme.colors.secondary,
                    text = { Text("Intermediate") },
                    selected = pagerState.currentPage == 1,
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(1)
                        }
                    },
                )
                Tab(
                    selectedContentColor = MaterialTheme.colors.secondary,
                    text = { Text("Advanced") },
                    selected = pagerState.currentPage == 2,
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(2)
                        }
                    },
                )
                Tab(
                    selectedContentColor = MaterialTheme.colors.secondary,
                    text = { Text("Elite") },
                    selected = pagerState.currentPage == 3,
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(3)
                        }
                    },
                )
            }
            HorizontalPager(state = pagerState) { page ->
                LazyColumn(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    item {
                        CardItem(
                            navController = navController,
                            title = "Basic 5/3/1",
                            desc = stringResource(id = R.string.programs_beginner_desc),
                            primaryBtnOnClick = {
                                navController?.navigate(ProgramScreens.Overview.route)
                            },
                            secondaryBtnOnClick = {
                                navController?.navigate(ProgramScreens.OneRepMax.route)
                            }
                        )
                    }
                    item {
                        CardItem(
                            navController = navController,
                            title = "Another Basic Program",
                            desc = stringResource(id = R.string.programs_beginner_desc),
                            primaryBtnOnClick = {
                                navController?.navigate(ProgramScreens.Overview.route)
                            },
                            secondaryBtnOnClick = {
                                navController?.navigate(ProgramScreens.OneRepMax.route)
                            }
                        )
                    }
                }
            }
        }
    }
}