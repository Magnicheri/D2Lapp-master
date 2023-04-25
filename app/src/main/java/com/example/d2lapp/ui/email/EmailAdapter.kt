package com.example.d2lapp.ui.email


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.d2lapp.R

class EmailAdapter(
    private val emails: List<Email>,
    private val onEmailClickListener: OnEmailClickListener
) : RecyclerView.Adapter<EmailAdapter.EmailViewHolder>() {

    private var isFullScreen = false

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmailViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_email, parent, false)
        return EmailViewHolder(view)
    }

    override fun onBindViewHolder(holder: EmailViewHolder, position: Int) {
        val email = emails[position]
        holder.bind(email)

        holder.fullScreenButton.setOnClickListener {
            isFullScreen = true
            onEmailClickListener.onEmailClick(email)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return emails.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (isFullScreen) VIEW_TYPE_FULL_SCREEN_EMAIL else VIEW_TYPE_EMAIL
    }

    inner class EmailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val senderTextView: TextView = itemView.findViewById(R.id.senderTextView)
        val subjectTextView: TextView = itemView.findViewById(R.id.subjectTextView)
        val bodyTextView: TextView = itemView.findViewById(R.id.bodyTextView)
        private val topSeparatorView: View = itemView.findViewById(R.id.top_separator)
        private val bottomSeparatorView: View = itemView.findViewById(R.id.bottom_separator)
        val fullScreenButton: Button = itemView.findViewById(R.id.fullScreenButton)

        fun bind(email: Email) {
            // Set the sender, subject, and body texts
            senderTextView.text = email.sender
            subjectTextView.text = email.subject
            bodyTextView.text = email.body

            // Show/hide the top and bottom separators based on the position
            if (adapterPosition == 0) {
                topSeparatorView.visibility = View.GONE
            } else {
                topSeparatorView.visibility = View.VISIBLE
            }
            if (adapterPosition == emails.size - 1) {
                bottomSeparatorView.visibility = View.GONE
            } else {
                bottomSeparatorView.visibility = View.VISIBLE
            }
        }
    }

    companion object {
        private const val VIEW_TYPE_EMAIL = 0
        private const val VIEW_TYPE_FULL_SCREEN_EMAIL = 1
    }

    interface OnEmailClickListener {
        fun onEmailClick(email: Email)
    }
}
