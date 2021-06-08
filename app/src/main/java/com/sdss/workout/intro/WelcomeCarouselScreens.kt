package com.sdss.workout.intro

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Colors
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState

@ExperimentalPagerApi
@Composable
fun WelcomeLayoutContent(pagerState: PagerState) =
    HorizontalPager(state = pagerState) { page ->
        Text(
            text = "Page: $page",
            color = Color.White,
            modifier = Modifier.fillMaxWidth()
        )
    }