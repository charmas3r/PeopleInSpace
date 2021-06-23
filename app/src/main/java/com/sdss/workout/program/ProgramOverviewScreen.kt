package com.sdss.workout.program

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import com.google.android.material.color.MaterialColors
import com.sdss.workout.R
import com.sdss.workout.ui.buttons.PrimaryButton
import com.sdss.workout.ui.buttons.SecondaryVariantButton
import com.sdss.workout.ui.lists.cards.OverviewCard
import kotlinx.coroutines.launch

@ExperimentalFoundationApi
@ExperimentalPagerApi
@Composable
fun ProgramOverviewScreen(navController: NavController?) {
    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                // try to consume before LazyColumn to collapse toolbar if needed, hence pre-scroll
//                val delta = available.y
//                val newOffset = toolbarOffsetHeightPx.value + delta
//                toolbarOffsetHeightPx.value = newOffset.coerceIn(-toolbarHeightPx, 0f)
                // here's the catch: let's pretend we consumed 0 in any case, since we want
                // LazyColumn to scroll anyway for good UX
                // We're basically watching scroll without taking it
                return Offset.Zero
            }
        }
    }
    Column(Modifier.nestedScroll(nestedScrollConnection)) {
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
                text = { Text("Week 1") },
                selected = pagerState.currentPage == 0,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(0)
                    }
                },
            )
            Tab(
                selectedContentColor = MaterialTheme.colors.secondary,
                text = { Text("Week 2") },
                selected = pagerState.currentPage == 1,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(1)
                    }
                },
            )
            Tab(
                selectedContentColor = MaterialTheme.colors.secondary,
                text = { Text("Week 3") },
                selected = pagerState.currentPage == 2,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(2)
                    }
                },
            )
            Tab(
                selectedContentColor = MaterialTheme.colors.secondary,
                text = { Text("Week 4") },
                selected = pagerState.currentPage == 3,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(3)
                    }
                },
            )
        }
        HorizontalPager(state = pagerState) { page ->
            Column {

                // Main grid
                LazyVerticalGrid(
                    cells = GridCells.Adaptive(156.dp)
                ) {
                    item {
                        OverviewCard(title = "Overhead Press")
                    }
                    item {
                        OverviewCard(title = "Bench Press")
                    }
                    item {
                        OverviewCard(title = "Deadlifts")
                    }
                    item {
                        OverviewCard(title = "Squats")
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))
                // divider
                Divider(thickness = 1.dp)
                Text(
                    modifier = Modifier.padding(start = 8.dp),
                    text = stringResource(id = R.string.programs_assistance_avail),
                    style = TextStyle(color = MaterialTheme.colors.onBackground)
                )

                // Assistance grid
                LazyVerticalGrid(
                    cells = GridCells.Adaptive(156.dp)
                ) {
                    item {
                        OverviewCard(title = "Boring But Big")
                    }
                    item {
                        OverviewCard(title = "Some Other Name")
                    }
                    item {
                        OverviewCard(title = "First Set Last")
                    }
                }
            }
        }

        PrimaryButton(
            text = stringResource(id = R.string.programs_edit_program_btn),
            modifier = Modifier
                .fillMaxWidth(.75f)
                .align(Alignment.CenterHorizontally),
            onClick = {
                navController?.navigate(ProgramScreens.OneRepMax.route)
            }
        )
        SecondaryVariantButton(
            text = stringResource(id = R.string.programs_end_program_btn),
            modifier = Modifier
                .fillMaxWidth(.75f)
                .align(Alignment.CenterHorizontally)
                .padding(top = 16.dp, bottom = 16.dp),
            onClick = {
                // do something (pop up checking if user is sure to delete..
            }
        )
    }
}