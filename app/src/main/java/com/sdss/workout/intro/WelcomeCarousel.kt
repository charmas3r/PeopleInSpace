package com.sdss.workout.intro

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.sdss.workout.R
import com.sdss.workout.ui.buttons.PrimaryButton

@ExperimentalPagerApi
@Composable
fun WelcomeCarousel(navController: NavController) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) {
        Box(
            Modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp)
        ) {

            // Display 10 items
            val pagerState = rememberPagerState(
                pageCount = 4,
                // We increase the offscreen limit, to allow pre-loading of images
                initialOffscreenLimit = 2,
            )

            Box(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .fillMaxHeight()
            ) {
                HorizontalPager(
                    state = pagerState,
                    modifier = Modifier
                        .padding(top = 48.dp)
                ) { page ->
                    WelcomePagerItem(
                        page = page,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                }
            }

            Box(modifier = Modifier.align(Alignment.BottomCenter)) {
                Column {
                    HorizontalPagerIndicator(
                        pagerState = pagerState,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(16.dp),
                    )

                    PrimaryButton(
                        text = stringResource(id = R.string.welcome_carousel_btn),
                        modifier = Modifier
                            .fillMaxWidth(.75f)
                            .align(Alignment.CenterHorizontally)
                            .padding(top = 16.dp, bottom = 16.dp)
                    ) {
                        navController.navigate(IntroScreens.SetupWeight.route)
                    }
                }
            }
        }
    }
}