package com.example.widgetexample.widget

import android.content.Context
import androidx.compose.runtime.LaunchedEffect
import androidx.glance.GlanceId
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.provideContent
import androidx.glance.appwidget.updateAll
import androidx.glance.state.GlanceStateDefinition
import androidx.glance.state.PreferencesGlanceStateDefinition
import com.example.widgetexample.data.WidgetDataHolder
import com.example.widgetexample.widget.content.EventsContent

class EventsWidget : GlanceAppWidget() {

    override val stateDefinition: GlanceStateDefinition<*> = PreferencesGlanceStateDefinition

    private val widgetDataHolder = WidgetDataHolder()

    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            LaunchedEffect(Unit) {
                widgetDataHolder.fetchPlannings()
                EventsWidget().updateAll(context)
            }
            EventsContent(widgetDataHolder.plannings)
//            SpiderManContent()
        }
    }
}
