package com.sdss.workout.ui.buttons

import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.DropdownMenu
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import com.sdss.workout.ui.styles.bodyTextStyle
import com.sdss.workout.ui.styles.selectedTextStyle

@Composable
internal fun PrimaryDropdownMenu(
    firstItemModifier: Modifier,
    menuModifier: Modifier,
    items: List<DropdownMenuItemContent>
) {
    var expanded by remember { mutableStateOf(false) }

    Row(
        Modifier
            .clickable { expanded = !expanded }.then(firstItemModifier)) {
        items.forEach { item ->
            if (item.isFirstPosition) {
                Text(
                    text = stringResource(id = item.titleRes),
                    style = bodyTextStyle()
                )
            }
        }
        Icon(imageVector = Icons.Filled.ArrowDropDown, null)
        DropdownMenu(
            modifier = Modifier
                .padding(start = 4.dp)
                .then(menuModifier),
            expanded = expanded,
            onDismissRequest = { expanded = false }) {
            items.forEach { menuItem ->
                ClickableText(
                    modifier = Modifier.padding(4.dp),
                    style = if (menuItem.isFirstPosition) selectedTextStyle() else bodyTextStyle(),
                    text = AnnotatedString(stringResource(id = menuItem.titleRes)),
                    onClick = {
                        items.forEach { it.isFirstPosition = false }
                        menuItem.isFirstPosition = true
                        menuItem.onClick
                        expanded = false
                    })
            }
        }
    }
}

data class DropdownMenuItemContent(
    @StringRes var titleRes: Int,
    var isFirstPosition: Boolean = false,
    val onClick: () -> Unit
)