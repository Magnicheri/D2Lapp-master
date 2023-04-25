package com.example.d2lapp.ui.notifications

import android.app.Notification
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.d2lapp.R

class NotificationsFragment : Fragment() {
    private lateinit var notificationRecyclerView: RecyclerView
    private lateinit var notificationAdapter: NotificationAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_notifications, container, false)

        // Initialize RecyclerView
        notificationRecyclerView = view.findViewById(R.id.notificationRecyclerView)
        notificationAdapter = NotificationAdapter()
        notificationRecyclerView.adapter = notificationAdapter
        notificationRecyclerView.layoutManager = LinearLayoutManager(context)

        // Add some dummy data to the adapter
        val notifications = listOf(
            Notification("Assignment Due:", "Research paper is due 4/28/2023"),
            Notification("Lab report 2 Grade", "80/100"),
            Notification("New upload", "Mobile_app lesson 1 powerpoint"),
            Notification("Assignment Due: " ,"Lab report 3 is due 4/26/20233"),
            Notification("Class Notification", "no class on 4/26/2023"),
            Notification("Lab report 3 Grade", "95/100"),
        )
        notificationAdapter.submitList(notifications)

        return view
    }
}
