package com.sdss.workout.intro

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.sdss.workout.base.BaseActivity
import com.sdss.workout.ui.WorkoutTheme


@ExperimentalPagerApi
class IntroActivity: BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IntroLayout()
        }
    }
}

@ExperimentalPagerApi
@Composable
fun IntroLayout() {
    val pagerState = rememberPagerState(pageCount = 3)
    WorkoutTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(Modifier.fillMaxSize()) {
                // Display 10 items
                val pagerState = rememberPagerState(
                    pageCount = 10,
                    // We increase the offscreen limit, to allow pre-loading of images
                    initialOffscreenLimit = 2,
                )

                HorizontalPager(
                    state = pagerState,
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                ) { page ->
                    WelcomePagerItem(
                        page = page,
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .aspectRatio(1f)
                    )
                }

                HorizontalPagerIndicator(
                    pagerState = pagerState,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(16.dp),
                )
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