package com.example.d2lapp.ui.content

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.d2lapp.R

class WelcomeToTheClassFragment : Fragment() {

    companion object {
        fun newInstance() = WelcomeToTheClassFragment()
    }

    private lateinit var viewModel: WelcomeToTheClassViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_welcome_to_the_class, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(WelcomeToTheClassViewModel::class.java)
        // TODO: Use the ViewModel
    }

}