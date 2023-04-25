package com.example.d2lapp.ui.email

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.d2lapp.R
import com.example.d2lapp.ui.email.Email


class EmailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val senderTextView: TextView = itemView.findViewById(R.id.senderTextView)
    private val subjectTextView: TextView = itemView.findViewById(R.id.subjectTextView)
    private val bodyTextView: TextView = itemView.findViewById(R.id.bodyTextView)
    private val topSeparatorView: View = itemView.findViewById(R.id.top_separator)
    private val bottomSeparatorView: View = itemView.findViewById(R.id.bottom_separator)
    private val fullScreenButton: Button = itemView.findViewById(R.id.fullScreenButton)

    fun bind(email: Email, emails: List<Email>, fragmentManager: FragmentManager) {
        senderTextView.text = email.sender
        subjectTextView.text = email.subject
        bodyTextView.text = email.body

        if (adapterPosition == 0) {
            topSeparatorView.visibility = View.GONE
        }

        if (adapterPosition == emails.size - 1) {
            bottomSeparatorView.visibility = View.GONE
        }

        fullScreenButton.setOnClickListener {
            val bundle = Bundle()
            bundle.putParcelable("email", email)
            val emailFullScreenFragment = EmailFullScreenFragment.newInstance(email)
            emailFullScreenFragment.arguments = bundle
            fragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, emailFullScreenFragment)
                .addToBackStack(null)
                .commit()
        }
    }

}



