package com.example.widgetexample.widget.content

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.glance.GlanceModifier
import androidx.glance.ImageProvider
import androidx.glance.LocalContext
import androidx.glance.appwidget.cornerRadius
import androidx.glance.appwidget.lazy.LazyColumn
import androidx.glance.appwidget.lazy.items
import androidx.glance.background
import androidx.glance.layout.Alignment
import androidx.glance.layout.Box
import androidx.glance.layout.Column
import androidx.glance.layout.Row
import androidx.glance.layout.fillMaxHeight
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.height
import androidx.glance.layout.padding
import androidx.glance.layout.width
import androidx.glance.layout.wrapContentSize
import androidx.glance.layout.wrapContentWidth
import com.example.widgetexample.R
import com.example.widgetexample.model.Planning
import com.example.widgetexample.widget.GlanceText


@Composable
fun EventsContent(plannings: List<Planning>) {
    val context = LocalContext.current
    val itemPadding = 15.dp
    val itemHeight = 40.dp + itemPadding
    Row(
        modifier = GlanceModifier
            .fillMaxSize()
            .background(ImageProvider(R.drawable.widget_background))
    ) {

        Column(
            modifier = GlanceModifier
                .wrapContentWidth()
                .padding(start = 25.dp, top = 25.dp, end = 20.dp)
                .fillMaxHeight()
        ) {
            GlanceText(
                text = "UP",
                color = Color.Black,
                font = R.font.gill_sans_medium,
                fontSize = 15.sp
            )
            GlanceText(
                text = "NEXT",
                color = Color.Black,
                font = R.font.gill_sans_medium,
                fontSize = 15.sp
            )
            GlanceText(
                text = "TODAY",
                color = Color.Black,
                font = R.font.gill_sans_light,
                fontSize = 15.sp
            )
        }

        Box(modifier = GlanceModifier.padding(vertical = 15.dp)) {
            Box(
                modifier = GlanceModifier
                    .fillMaxHeight()
                    .width(1.2.dp)
                    .background(Color.Black)
            ) {
            }
        }

        Column(
            modifier = GlanceModifier.fillMaxHeight()
                .padding(start = 7.dp)
        ) {
            if (plannings.isEmpty()) {
                Box(
                    modifier = GlanceModifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    GlanceText(
                        modifier = GlanceModifier.wrapContentSize(),
                        text = "Nothing!",
                        color = Color.Black,
                        letterSpacing = 0.03f.sp,
                        font = R.font.tuesday_night_regular,
                        fontSize = 40.sp
                    )
                }
            } else {
                LazyColumn(
                    modifier = GlanceModifier,
                    horizontalAlignment = Alignment.Start
                ) {
                    items(plannings) { planning ->
                        Box(
                            modifier = GlanceModifier
                                .height(itemHeight)
                                .padding(start = 5.dp, end = 10.dp, top = itemPadding),
                            contentAlignment = Alignment.CenterStart,
                        ) {
                            Box(
                                modifier = GlanceModifier
                                    .fillMaxHeight()
                                    .cornerRadius(15.dp)
                                    .background(planning.highlight)
                            ) {
                                val fullTitle = "${planning.date} ${planning.title}"
                                GlanceText(
                                    modifier = GlanceModifier.fillMaxHeight()
                                        .padding(horizontal = 10.dp),
                                    text = fullTitle,
                                    color = Color.Black,
                                    letterSpacing = 0.03f.sp,
                                    font = R.font.gill_sans_light,
                                    fontSize = 17.sp
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}