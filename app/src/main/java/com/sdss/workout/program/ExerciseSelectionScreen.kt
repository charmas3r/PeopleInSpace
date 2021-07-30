package com.sdss.workout.program

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import com.sdss.workout.R
import com.sdss.workout.ui.lists.cards.CardItem
import com.sdss.workout.ui.theme.white
import kotlinx.coroutines.launch

@ExperimentalFoundationApi
@ExperimentalPagerApi
@Composable
fun ExerciseSelectionScreen(navController: NavController?) {
    Box(
        Modifier
            .fillMaxSize()
    ) {
        Column {
            val scope = rememberCoroutineScope()
            val pagerState = rememberPagerState(pageCount = 4)
            TabRow(
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
                    text = { Text("Alphabetical") },
                    selected = pagerState.currentPage == 0,
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(0)
                        }
                    },
                )
                Tab(
                    selectedContentColor = MaterialTheme.colors.secondary,
                    text = { Text("Category") },
                    selected = pagerState.currentPage == 1,
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(1)
                        }
                    },
                )
                Tab(
                    selectedContentColor = MaterialTheme.colors.secondary,
                    text = { Text("Assistance") },
                    selected = pagerState.currentPage == 2,
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(2)
                        }
                    },
                )
            }
            HorizontalPager(state = pagerState) { page ->
                when (page) {
                    0 -> {
                        LazyColumn(
                            modifier = Modifier
                                .fillMaxHeight(),
                        ) {
                            // exercise items
                            stickyHeader {
                                // Create header composable from this
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .background(white)
                                ) {
                                    Text(
                                        text = "A",
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(start = 24.dp),
                                        color = MaterialTheme.colors.secondaryVariant
                                    )
                                }
                            }
                            items(50) {
                                Text(
                                    text = "Aaaa Exercise",
                                    Modifier
                                        .fillMaxWidth()
                                        .padding(start = 16.dp)
                                )
                            }

                            stickyHeader {
                                // Create header composable from this
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .background(white)
                                ) {
                                    Text(
                                        text = "B",
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(start = 24.dp),
                                        color = MaterialTheme.colors.secondaryVariant
                                    )
                                }
                            }

                            items(50) {
                                Text(text = "Bench Press", Modifier.padding(start = 16.dp))
                            }

                            stickyHeader {
                                // Create header composable from this
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .background(white)
                                ) {
                                    Text(
                                        text = "C",
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(start = 24.dp),
                                        color = MaterialTheme.colors.secondaryVariant
                                    )
                                }
                            }

                            item {
                                ClickableText(text = AnnotatedString(text = "Custom")) {
                                    // create custom item for now
                                    navController?.popBackStack()
                                }
                            }

                        }
                    }
                    1 -> {
                        LazyColumn(
                            modifier = Modifier
                                .fillMaxHeight()
                        ) {

                        }
                    }
                    2 -> {

                    }
                }

            }
        }
    }
}
