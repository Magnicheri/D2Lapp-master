package com.example.d2lapp.ui.email


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.d2lapp.R
import javax.annotation.Nullable


class EmailFullScreenFragment : Fragment() {
    private var mEmail: Email? = null
    private var recyclerView: RecyclerView? = null

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mEmail = requireArguments().getParcelable(ARG_EMAIL)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_email_full_screen, container, false)
        val subjectTextView = view.findViewById<TextView>(R.id.subjectTextView)
        val senderTextView = view.findViewById<TextView>(R.id.senderTextView)
        val bodyTextView = view.findViewById<TextView>(R.id.bodyTextView)
        recyclerView = requireActivity().findViewById(R.id.emailRecyclerView)
        recyclerView?.visibility = View.GONE
        val backButton = view.findViewById<Button>(R.id.backButton)
        backButton.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
        if (mEmail != null) {
            subjectTextView.text = mEmail!!.subject
            senderTextView.text = mEmail!!.sender
            bodyTextView.text = mEmail!!.body
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        recyclerView?.visibility = View.VISIBLE
    }

    companion object {
        private const val ARG_EMAIL = "arg_email"
        fun newInstance(email: Email?): EmailFullScreenFragment {
            val fragment = EmailFullScreenFragment()
            val args = Bundle()
            args.putParcelable(ARG_EMAIL, email)
            fragment.arguments = args
            return fragment
        }
    }
}
