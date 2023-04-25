package com.example.d2lapp.ui.Calender


import android.app.AlertDialog
import com.example.d2lapp.R
import android.os.Bundle
import android.view.*
import android.widget.*

import androidx.fragment.app.Fragment

import androidx.lifecycle.ViewModelProvider

class CalenderFragment : Fragment() {

    private lateinit var calendarView: CalendarView
    private lateinit var eventView: TextView
    private lateinit var viewModel: CalendarViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calender, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Find the views by ID
        calendarView = view.findViewById(R.id.calendarView)
        eventView = view.findViewById(R.id.eventView)

        // Get the view model
        viewModel = ViewModelProvider(this).get(CalendarViewModel::class.java)

        // Set the calendar view date change listener
        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            // Call the onDayClick method to handle the day click event
            onDayClick(year, month, dayOfMonth)
        }
    }

    private fun showAddEventDialog(year: Int, month: Int, dayOfMonth: Int) {
        val dialogView = layoutInflater.inflate(R.layout.dialog_add_event, null)
        val editTextTitle = dialogView.findViewById<EditText>(R.id.editTextTitle)
        val editTextTime = dialogView.findViewById<EditText>(R.id.editTextTime)

        val dialog = AlertDialog.Builder(requireContext())
            .setView(dialogView)
            .setCancelable(false)
            .setPositiveButton("Add") { _, _ ->
                val title = editTextTitle.text.toString()
                val time = editTextTime.text.toString()
                val event = Event(title, time)

                viewModel.addEvent(year, month, dayOfMonth, event)
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }
            .create()

        dialog.show()
    }


    private fun onDayClick(year: Int, month: Int, dayOfMonth: Int) {
        val events = viewModel.getEventsForDate(year, month, dayOfMonth)

        if (events.isEmpty()) {
            // Show add event dialog if no events exist for the selected date
            showAddEventDialog(year, month, dayOfMonth)
        } else {
            // Display existing events for the selected date
            eventView.text = events.joinToString("\n")
        }
    }

}

















