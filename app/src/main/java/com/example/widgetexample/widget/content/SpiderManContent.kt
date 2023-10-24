package com.example.widgetexample.widget.content

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.glance.GlanceModifier
import androidx.glance.Image
import androidx.glance.ImageProvider
import androidx.glance.LocalContext
import androidx.glance.appwidget.appWidgetBackground
import androidx.glance.background
import androidx.glance.layout.Box
import androidx.glance.layout.Column
import androidx.glance.layout.Row
import androidx.glance.layout.fillMaxHeight
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.padding
import androidx.glance.layout.wrapContentWidth
import com.example.widgetexample.R
import com.example.widgetexample.widget.textAsBitmap

@Composable
fun SpiderManContent() {
    val context = LocalContext.current
    Box(
        modifier = GlanceModifier
            .fillMaxSize()
            .appWidgetBackground()
            .padding(vertical = 15.dp)
    ) {
        Row(
            modifier = GlanceModifier
                .fillMaxSize()
                .padding(20.dp)
                .background(ImageProvider(R.drawable.widget_background))
        ) {

            Column(
                modifier = GlanceModifier
                    .wrapContentWidth()
                    .padding(start = 5.dp, top = 40.dp, end = 18.dp)
                    .fillMaxHeight()
            ) {
                Image(
                    modifier = GlanceModifier.padding(bottom = 3.dp),
                    provider = ImageProvider(
                        context.textAsBitmap(
                            "SPIDER-MAN",
                            15f,
                            color = Color.Black,
                            font = R.font.spider_2
                        )
                    ),
                    contentDescription = ""
                )
                Image(
                    modifier = GlanceModifier.padding(bottom = 3.dp),
                    provider = ImageProvider(
                        context.textAsBitmap(
                            "Far From Home",
                            20f,
                            color = Color.Black,
                            font = R.font.spider
                        )
                    ),
                    contentDescription = ""
                )
            }
        }
    }
}