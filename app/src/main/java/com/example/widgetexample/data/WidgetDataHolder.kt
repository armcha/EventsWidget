package com.example.widgetexample.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.widgetexample.model.Planning
import com.example.widgetexample.ui.theme.highlightLightColors
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import java.util.Random

class WidgetDataHolder {

    private val titles = listOf(
        "Launch Party",
        "Coding Workshop",
        "Book Club Meeting",
        "Movie Night",
        "Game Night",
        "Art Exhibit",
        "Music Concert",
        "Comedy Show",
        "Food Festival"
    )
    private val dateFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
    var plannings by mutableStateOf<List<Planning>>(emptyList())
        private set

    fun fetchPlannings() {
        plannings = titles.mapIndexed { index, title ->
            val date = generateRandomTime()
            val formattedDate = dateFormat.format(date)
            Planning(title, formattedDate, highlightLightColors[index])
        }.sortedBy { it.date }
    }

    private fun generateRandomTime(): Date {
        val random = Random()
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, random.nextInt(24))
        calendar.set(Calendar.MINUTE, random.nextInt(60))
        calendar.set(Calendar.SECOND, random.nextInt(60))
        return calendar.time
    }
}