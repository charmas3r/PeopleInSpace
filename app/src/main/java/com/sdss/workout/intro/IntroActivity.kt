package com.sdss.workout.intro

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.pager.ExperimentalPagerApi
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
        WelcomeLayoutContent(pagerState = pagerState)
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