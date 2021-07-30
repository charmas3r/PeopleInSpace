package com.sdss.workout.program

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sdss.workout.ui.buttons.PrimaryButton

@Composable
fun ProgramSetupTemplate(
    primaryBtnTitle: String,
    onPrimaryClick: () -> Unit,
    content: @Composable BoxScope.() -> Unit
){
    Box(
        Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp)
    ) {
        Box(
            content = content, modifier = Modifier
                .align(Alignment.TopStart)
                .fillMaxWidth()
        )
        Box(modifier = Modifier.align(Alignment.BottomCenter)) {
            Column {
                PrimaryButton(
                    text = primaryBtnTitle,
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                        .fillMaxWidth(.75f)
                        .align(Alignment.CenterHorizontally),
                    onClick = onPrimaryClick

                )
            }
        }
    }
}