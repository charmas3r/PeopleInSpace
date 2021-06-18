package com.sdss.workout.ui.screens

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.sdss.workout.R
import com.sdss.workout.ui.buttons.PrimaryButton
import com.sdss.workout.ui.buttons.SecondaryButton

@Composable
fun ListScreen(
    onPrimaryClick: () -> Unit,
    onSecondaryClick: () -> Unit,
    @StringRes primaryButtonRes: Int = R.string.btn_continue,
    @StringRes secondaryButtonRes: Int = R.string.btn_skip,
    content: LazyListScope.() -> Unit
) {
    Box(
        Modifier
            .fillMaxSize()
    ) {
        LazyColumn(content = content, modifier = Modifier.padding(top = 16.dp, bottom = 16.dp))
        Box(modifier = Modifier.align(Alignment.BottomCenter)) {
            Column {
                PrimaryButton(
                    text = stringResource(id = primaryButtonRes),
                    modifier = Modifier
                        .fillMaxWidth(.75f)
                        .align(Alignment.CenterHorizontally),
                    onClick = onPrimaryClick

                )
                SecondaryButton(
                    text = stringResource(id = secondaryButtonRes),
                    modifier = Modifier
                        .fillMaxWidth(.75f)
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 16.dp, bottom = 16.dp),
                    onClick = onSecondaryClick
                )
            }
        }
    }
}