package com.sdss.workout.intro

import androidx.compose.foundation.layout.Box
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
internal fun WelcomePagerItem(
    page: Int,
    modifier: Modifier = Modifier
) {
    Box(modifier) {
        Text(
            text = "Page: $page",
            color = Color.White,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

