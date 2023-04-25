package com.example.d2lapp.ui.notifications

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.d2lapp.R

class NotificationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(notification: Notification) {
        itemView.findViewById<TextView>(R.id.notificationTitleTextView).text = notification.title
        itemView.findViewById<TextView>(R.id.notificationMessageTextView).text = notification.message
    }
}