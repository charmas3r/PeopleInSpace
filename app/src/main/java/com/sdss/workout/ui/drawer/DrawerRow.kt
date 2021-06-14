package com.sdss.workout.ui.drawer

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ListItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.sdss.workout.R

@ExperimentalMaterialApi
@Composable
internal fun DrawerRow(
    isTextItem: Boolean = true,
    rowContent: @Composable () -> Unit = { Text(text = "General") },
    @StringRes titleRes: Int = R.string.drawer_home,
    selected: Boolean = false,
    onClick: () -> Unit = {}) {
    val background =
        if (selected) MaterialTheme.colors.primary.copy(alpha = 0.12f) else Color.Transparent
    val textColor = if (selected) MaterialTheme.colors.primary else MaterialTheme.colors.onSurface
    ListItem(modifier = Modifier
        .clickable(onClick = { if (isTextItem) onClick })
        .background(background)) {
        if (isTextItem) {
            Text(color = textColor, text = stringResource(id = titleRes))
        } else {
            rowContent()
        }
    }
}