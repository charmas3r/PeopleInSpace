package com.sdss.workout.googlesync

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.sdss.workout.R
import com.sdss.workout.setup.SetupFinishScreen
import com.sdss.workout.ui.styles.titleTextStyle

@Composable
fun GoogleSyncSignInScreen(onClick: () -> Unit) {

    val googleBtnColors = ButtonDefaults.buttonColors(
        backgroundColor = MaterialTheme.colors.surface,
        contentColor = MaterialTheme.colors.onSurface
    )

    Box {
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .fillMaxSize()
        ) {
            Column(Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                Spacer(modifier = Modifier.height(16.dp))
                Image(
                    painter = painterResource(id = R.drawable.workout_item_image_1),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.height(32.dp))
                Text(
                    text = stringResource(id = R.string.google_sync_sign_in_title),
                    textAlign = TextAlign.Center,
                    style = titleTextStyle(),
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.google_sync_sign_in_desc),
                    textAlign = TextAlign.Center
                )
            }
        }
        Box(modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = 32.dp)) {
            Button(
                colors = googleBtnColors,
                onClick = onClick,
                modifier = Modifier.fillMaxWidth(.75f)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.google_icon),
                    contentDescription = null,
                    modifier = Modifier.padding(end = 24.dp)
                )
                Text(
                    text = stringResource(id = R.string.google_sync_sign_in_btn),
                style = TextStyle(fontSize = 16.sp)
                )
            }
        }
    }
}

@ExperimentalPagerApi
@Preview
@Composable
fun GoogleSyncPreview() {
    MaterialTheme {
        GoogleSyncSignInScreen {

        }
    }
}