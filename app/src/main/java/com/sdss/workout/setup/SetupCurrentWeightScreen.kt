package com.sdss.workout.setup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.sdss.workout.R

@Composable
fun SetupCurrentWeightScreen() {
    SetupScreenLayout(
        onPrimaryClick = { /*TODO*/ },
        onSecondaryClick = { /*TODO*/ },
        onBackClick = { /*TODO*/ }) {
        Column(Modifier.padding(16.dp)) {
            Text(text = stringResource(id = R.string.setup_weight_text) )
        }
        
    }
}