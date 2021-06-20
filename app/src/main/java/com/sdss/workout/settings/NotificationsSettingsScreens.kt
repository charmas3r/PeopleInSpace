package com.sdss.workout.settings

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sdss.workout.R
import com.sdss.workout.ui.theme.WorkoutTheme

@Composable
fun NotificationsSettingsScreen() {
    Row(modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically) {
        Box {
            Text(
                text = stringResource(id = R.string.settings_notifications_text),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(48.dp)
            )
        }
    }
}

@Composable
@Preview
fun showNotificationSettingsPreview() {
    WorkoutTheme {
        Scaffold {
            NotificationsSettingsScreen()
        }
    }
}