package com.sdss.workout.ui.lists.cards

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.sdss.workout.R
import com.sdss.workout.ui.styles.btnCardItemStyle
import com.sdss.workout.ui.styles.captureDescStyle
import com.sdss.workout.ui.styles.captureTitleStyle
import com.sdss.workout.ui.theme.WorkoutTheme

@Composable
fun CardItem(
    navController: NavController?,
    title: String? = null,
    desc: String? = null,
    @DrawableRes iconRes: Int? = null,
    @StringRes primaryBtnRes: Int = R.string.programs_overview_btn,
    @StringRes secondaryBtnRes: Int = R.string.programs_setup_btn,
    primaryBtnOnClick: (Int) -> Unit = { },
    secondaryBtnOnClick: (Int) -> Unit = { }
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp),
        elevation = 6.dp,
        backgroundColor = MaterialTheme.colors.surface
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {

            Column {
//                Image(
//                    painter = rememberCoilPainter(request = "https://images.unsplash.com/photo-1586232710888-675866d80ad2?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=240&q=80"),
//                    contentDescription = "Some content desc"
//                )
                if (title != null) {
                    Text(
                        text = title,
                        style = captureTitleStyle(),
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                }
                if (desc != null) {
                    Text(text = desc)
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.End
            ) {
                ClickableText(
                    text = AnnotatedString(text = stringResource(id = primaryBtnRes)),
                    onClick = primaryBtnOnClick,
                    style = btnCardItemStyle()
                )
                Spacer(modifier = Modifier.width(8.dp))
                ClickableText(
                    text = AnnotatedString(text = stringResource(id = secondaryBtnRes)),
                    onClick = secondaryBtnOnClick,
                    style = btnCardItemStyle()
                )
            }
        }

    }
}

@Composable
@Preview
fun showCardItem() {
    WorkoutTheme {
        Scaffold {
            Row(Modifier.fillMaxWidth()) {
                CardItem(navController = null, title = "title", desc = "Some description")
            }
        }
    }
}