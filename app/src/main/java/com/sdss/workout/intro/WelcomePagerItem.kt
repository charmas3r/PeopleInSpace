package com.sdss.workout.intro

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.sdss.workout.R
import com.sdss.workout.ui.styles.titleTextStyle

@ExperimentalPagerApi
@Composable
internal fun WelcomePagerItem(
    page: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        Image(
            painter = painterResource(id = welcomeImageByPageNumber(page)),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = stringResource(id = welcomeTitleByPageNumber(page)),
            style = titleTextStyle(),
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(id = welcomeDescByPageNumber(page)),
            color = MaterialTheme.colors.onSurface,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
        )
        // little hack to fill remaining space so we can swipe anywhere on the page
        Box(modifier = Modifier.fillMaxHeight())
    }
}

@DrawableRes
private fun welcomeImageByPageNumber(page: Int) : Int = when (page) {
    0 -> R.drawable.workout_item_image_1
    1 -> R.drawable.workout_item_image_1
    2 -> R.drawable.workout_item_image_1
    4 -> R.drawable.workout_item_image_1
    else -> R.drawable.workout_item_image_1
}

@StringRes
private fun welcomeTitleByPageNumber(page: Int): Int = when (page) {
    0 -> R.string.welcome_carousel_title_1
    1 -> R.string.welcome_carousel_title_2
    2 -> R.string.welcome_carousel_title_3
    4 -> R.string.welcome_carousel_title_4
    else -> R.string.welcome_carousel_title_1
}

@StringRes
private fun welcomeDescByPageNumber(page: Int): Int = when (page) {
    0 -> R.string.welcome_carousel_desc_1
    1 -> R.string.welcome_carousel_desc_2
    2 -> R.string.welcome_carousel_desc_3
    4 -> R.string.welcome_carousel_desc_4
    else -> R.string.welcome_carousel_desc_1
}


