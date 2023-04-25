package com.example.d2lapp.ui.email



import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.d2lapp.R


class EmailFragment : Fragment(R.layout.fragment_email), EmailAdapter.OnEmailClickListener {
    private var isFullScreen = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val emails = listOf(
            Email("John", "Meeting Reminder", "This is a reminder that our meeting is scheduled for tomorrow at 10am."),
            Email("Jane", "Important Information", "Please take a look at the attached document for important information."),
            Email("Bob", "Follow-Up", "Just wanted to follow up on the email I sent last week. Have you had a chance to review the information?"),
            Email("Alice", "Project Update", "Here's an update on the project we're working on. We're on track to meet the deadline."),
            Email("David", "Vacation Request", "I would like to request vacation time from June 1st to June 5th."),
            Email("Sarah", "New Opportunity", "I wanted to let you know about a new opportunity that I think we should explore."),
            Email("Tom", "Question", "I have a question about the new project. Can we schedule a meeting to discuss?")
        )

        val recyclerView = view.findViewById<RecyclerView>(R.id.emailRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = EmailAdapter(emails, this)
    }

    override fun onEmailClick(email: Email) {
        isFullScreen = true
        val emailFullScreenFragment = EmailFullScreenFragment.newInstance(email)
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, emailFullScreenFragment)
            .addToBackStack(null)
            .commit()
    }

    override fun onResume() {
        super.onResume()
        if (isFullScreen) {
            view?.findViewById<View>(R.id.emailRecyclerView)?.visibility = View.GONE
        }
    }

    override fun onPause() {
        super.onPause()
        if (isFullScreen) {
            view?.findViewById<View>(R.id.emailRecyclerView)?.visibility = View.VISIBLE
        }
    }
}
