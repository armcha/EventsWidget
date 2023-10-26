package com.example.widgetexample.widget.event

import android.content.Context
import androidx.compose.runtime.LaunchedEffect
import androidx.glance.GlanceId
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.provideContent
import com.example.widgetexample.data.WidgetDataHolder
import com.example.widgetexample.widget.content.EventsContent

class EventsWidget : GlanceAppWidget() {

    private val widgetDataHolder = WidgetDataHolder()

    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            LaunchedEffect(Unit) {
                widgetDataHolder.fetchPlannings()
            }
            EventsContent(plannings = widgetDataHolder.plannings)
        }
    }
}
