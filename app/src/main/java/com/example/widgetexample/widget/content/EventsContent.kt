package com.example.widgetexample.widget.content

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.glance.GlanceModifier
import androidx.glance.Image
import androidx.glance.ImageProvider
import androidx.glance.LocalContext
import androidx.glance.appwidget.lazy.LazyColumn
import androidx.glance.appwidget.lazy.items
import androidx.glance.background
import androidx.glance.layout.Alignment
import androidx.glance.layout.Box
import androidx.glance.layout.Column
import androidx.glance.layout.ContentScale
import androidx.glance.layout.Row
import androidx.glance.layout.fillMaxHeight
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.height
import androidx.glance.layout.padding
import androidx.glance.layout.width
import androidx.glance.layout.wrapContentSize
import androidx.glance.layout.wrapContentWidth
import com.example.widgetexample.model.Planning
import com.example.widgetexample.R
import com.example.widgetexample.widget.textAsBitmap
import com.example.widgetexample.widget.textAsBitmapWithBackground


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
            Image(
                provider = ImageProvider(
                    context.textAsBitmap(
                        "UP",
                        15f,
                        color = Color.Black,
                        font = R.font.gill_sans_medium
                    )
                ),
                contentDescription = ""
            )
            Image(
                provider = ImageProvider(
                    context.textAsBitmap(
                        "NEXT",
                        15f,
                        color = Color.Black,
                        font = R.font.gill_sans_medium
                    )
                ),
                contentDescription = ""
            )
            Image(
                provider = ImageProvider(
                    context.textAsBitmap(
                        "TODAY",
                        15f,
                        color = Color.Black,
                        font = R.font.gill_sans_light
                    )
                ),
                contentDescription = ""
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
                val emptyText = context.textAsBitmap(
                    text = "Nothing!",
                    font = R.font.tuesday_night_regular,
                    letterSpacing = 0.03f,
                    color = Color.Black,
                    textSize = 40f
                )
                Box(
                    modifier = GlanceModifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        modifier = GlanceModifier.wrapContentSize(),
                        provider = ImageProvider(emptyText),
                        contentScale = ContentScale.Fit,
                        contentDescription = ""
                    )
                }
            } else {
                LazyColumn(
                    modifier = GlanceModifier,
                    horizontalAlignment = Alignment.Start
                ) {
                    items(plannings) { planning ->
                        val fullTitle = "${planning.date} ${planning.title}"
                        val textAsBitmap = context.textAsBitmapWithBackground(
                            text = fullTitle,
                            font = R.font.gill_sans_light,
                            color = Color.Black,
                            letterSpacing = 0.03f,
                            backgroundColor = planning.highlight,
                            textSize = 16f
                        )
                        Box(
                            modifier = GlanceModifier.height(itemHeight)
                                .padding(start = 5.dp, end = 10.dp, top = itemPadding),
                            contentAlignment = Alignment.CenterStart,
                        ) {
                            Image(
                                modifier = GlanceModifier
                                    .fillMaxHeight(),
                                provider = ImageProvider(textAsBitmap),
                                contentScale = ContentScale.Fit,
                                contentDescription = ""
                            )
                        }
                    }
                }
            }
        }
    }
}