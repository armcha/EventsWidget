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
import androidx.glance.layout.Alignment
import androidx.glance.layout.Box
import androidx.glance.layout.Column
import androidx.glance.layout.ContentScale
import androidx.glance.layout.fillMaxHeight
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.height
import androidx.glance.layout.padding
import androidx.glance.layout.width
import androidx.glance.layout.wrapContentSize
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
    ) {
        Column(
            modifier = GlanceModifier
                .fillMaxSize()
                .background(ImageProvider(R.drawable.widget_background_web)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalAlignment = Alignment.CenterVertically,
        ) {

            Image(
                modifier = GlanceModifier
                    .width(100.dp)
                    .height(100.dp)
                    .padding(top = 25.dp),
                contentDescription = "",
                provider = ImageProvider(R.drawable.spider_logo),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = GlanceModifier
                    .wrapContentWidth()
                    .fillMaxHeight()
                    .padding(top = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    modifier = GlanceModifier
                        .padding(bottom = 3.dp)
                        .wrapContentSize(),
                    provider = ImageProvider(
                        context.textAsBitmap(
                            "SPIDER-MAN",
                            22f,
                            color = Color.Red,
                            font = R.font.good_times_rg
                        )
                    ),
                    contentDescription = ""
                )
                Image(
                    modifier = GlanceModifier
                        .padding(bottom = 3.dp)
                        .wrapContentSize(),
                    provider = ImageProvider(
                        context.textAsBitmap(
                            "Far From Home",
                            25f,
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