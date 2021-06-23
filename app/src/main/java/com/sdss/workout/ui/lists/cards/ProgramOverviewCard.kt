package com.sdss.workout.ui.lists.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sdss.workout.ui.styles.overviewCardStyle
import com.sdss.workout.ui.theme.WorkoutTheme

@Composable
fun OverviewCard(
    title: String
) {
    Card(
        shape = RoundedCornerShape(4.dp),
        elevation = 6.dp,
        modifier = Modifier
            .padding(8.dp)
            .height(112.dp)
            .width(128.dp)
    ) {

            LazyColumn() {
                item {
                    Box(
                        Modifier
                            .height(40.dp)
                            .background(
                                Brush.verticalGradient(
                                    listOf(Color.Transparent, MaterialTheme.colors.secondary),
                                    275f,
                                    0f
                                )
                            )
                    ) {
                        Text(
                            text = title,
                            color = MaterialTheme.colors.onSecondary,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            textAlign = TextAlign.Center
                        )
                    }
                }
                item {
                    OverviewCardListItem(isHeader = true)
                }
                item {
                    OverviewCardListItem(
                        set = " 1 ",
                        reps = " 5  ",
                        percent = "   55%"
                    )
                }
                item {
                    OverviewCardListItem(
                        set = " 1 ",
                        reps = " 5  ",
                        percent = "   65%"
                    )
                }
                item {
                    OverviewCardListItem(
                        set = " 1 ",
                        reps = " 5  ",
                        percent = "   75%",
                        isLastItem = true
                    )
                }
            }

    }
}

@Composable
fun OverviewCardListItem(
    set: String = "",
    reps: String = "",
    percent: String = "",
    isLastItem: Boolean = false,
    isHeader: Boolean = false
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(text = if (isHeader) "Set" else set, style = overviewCardStyle())
            Text(text = if (isHeader) "Reps" else reps, style = overviewCardStyle())
            Text(text = if (isHeader) "Percent" else percent, style = overviewCardStyle())
        }
        if (!isLastItem) Divider(thickness = 1.dp)
    }

}

@Preview
@Composable
fun ShowOverviewCard() {
    Scaffold() {
        WorkoutTheme {
            OverviewCard(title = "Bench Press")
        }
    }
}