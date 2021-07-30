package com.sdss.workout.ui.drawer

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import com.sdss.workout.R

@ExperimentalMaterialApi
@Composable
internal fun DrawerRow(
    isListItem: Boolean = true,
    rowContent: @Composable () -> Unit = { Text(text = "General") },
    @StringRes titleRes: Int = R.string.drawer_home,
    icon: ImageVector? = null,
    selected: Boolean = false,
    onClick: () -> Unit = {}
) {
    val background =
        if (selected) MaterialTheme.colors.secondary.copy(alpha = 0.1f) else Color.Transparent
    val textColor = if (selected) MaterialTheme.colors.secondaryVariant else MaterialTheme.colors.onSurface
    if (isListItem) {
        ListItem(modifier = Modifier
            .clickable { onClick() }
            .background(background),
            icon = {
                if (icon != null) {
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        tint = if (selected) MaterialTheme.colors.secondary else LocalContentColor.current.copy(alpha = LocalContentAlpha.current)
                    )
                }
            }) {
            Text(color = textColor, text = stringResource(id = titleRes))
        }
    } else {
        rowContent()
    }
}