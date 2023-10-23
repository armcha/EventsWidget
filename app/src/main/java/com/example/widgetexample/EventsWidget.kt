package com.example.widgetexample

import android.content.Context
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.Image
import androidx.glance.ImageProvider
import androidx.glance.LocalContext
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.appWidgetBackground
import androidx.glance.appwidget.lazy.LazyColumn
import androidx.glance.appwidget.lazy.items
import androidx.glance.appwidget.provideContent
import androidx.glance.appwidget.updateAll
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
import androidx.glance.state.GlanceStateDefinition
import androidx.glance.state.PreferencesGlanceStateDefinition
import com.example.widgetexample.ui.theme.highlightLightColors
import kotlinx.coroutines.delay

class EventsWidget : GlanceAppWidget() {

    override val stateDefinition: GlanceStateDefinition<*> = PreferencesGlanceStateDefinition

    private var plannings by mutableStateOf<List<Planning>>(emptyList())

    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            LaunchedEffect(Unit) {
                delay(1000)

                plannings = listOf(
                    Planning("Launch Party", "", highlightLightColors[0]),
                    Planning("Coding Workshop", "", highlightLightColors[1]),
                    Planning("Book Club Meeting", "", highlightLightColors[2]),
                    Planning("Movie Night", "", highlightLightColors[3]),
                    Planning("Game Night", "", highlightLightColors[4]),
                    Planning("Art Exhibit", "", highlightLightColors[5]),
                    Planning("Music Concert", "", highlightLightColors[6]),
                    Planning("Comedy Show", "", highlightLightColors[7]),
                    Planning("Food Festival", "", highlightLightColors[8]),
                )
                Log.e("ASFAS", "updateAll")
                EventsWidget().updateAll(context)
            }
            EventsContent()
//            SpiderManContent(context)
        }
    }

    @Composable
    private fun EventsContent() {
        val context = LocalContext.current
        val itemPadding = 15.dp
        val itemHeight = 40.dp + itemPadding
        Row(
            modifier = GlanceModifier
                .fillMaxSize()
                .background(ImageProvider(R.drawable.widget_background))
        ) {

            //Test
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
                            val fullTitle = planning.title
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

    @Composable
    private fun SpiderManContent(context: Context) {
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
                    .background(ImageProvider(R.drawable.widget_background_dark))
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
                                color = Color.White,
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
                                color = Color.White,
                                font = R.font.spider
                            )
                        ),
                        contentDescription = ""
                    )
                }
            }
        }
    }
}
