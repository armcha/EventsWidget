package com.example.widgetexample

import android.appwidget.AppWidgetManager
import android.content.Context
import android.util.Log
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver

class EventsWidgetReceiver : GlanceAppWidgetReceiver() {
  
  override val glanceAppWidget: GlanceAppWidget = EventsWidget()

  override fun onUpdate(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetIds: IntArray
  ) {
    Log.e("On upodadtas", "SADASDASD")
    super.onUpdate(context, appWidgetManager, appWidgetIds)
  }
}