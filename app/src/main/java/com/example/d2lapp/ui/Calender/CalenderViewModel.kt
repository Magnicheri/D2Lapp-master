package com.example.d2lapp.ui.Calender

import androidx.lifecycle.ViewModel
import java.util.*

class CalendarViewModel : ViewModel() {

    // A map that stores the events for each date
    private val eventsMap = mutableMapOf<Long, MutableList<Event>>()

    fun getEventsForDate(year: Int, month: Int, dayOfMonth: Int): List<Event> {
        val calendar = Calendar.getInstance()
        calendar.set(year, month, dayOfMonth, 0, 0, 0)
        calendar.set(Calendar.MILLISECOND, 0)
        val dateInMillis = calendar.timeInMillis
        return eventsMap[dateInMillis] ?: emptyList()
    }

    fun addEvent(year: Int, month: Int, dayOfMonth: Int, event: Event) {
        val calendar = Calendar.getInstance()
        calendar.set(year, month, dayOfMonth, 0, 0, 0)
        calendar.set(Calendar.MILLISECOND, 0)
        val dateInMillis = calendar.timeInMillis
        val events = eventsMap[dateInMillis] ?: mutableListOf()
        events.add(event)
        eventsMap[dateInMillis] = events
    }

}







