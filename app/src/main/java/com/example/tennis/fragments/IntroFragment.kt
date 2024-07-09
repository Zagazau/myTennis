package com.example.tennis.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mytennis.R

class IntroFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.first_page, container, false)

        val button: Button = view.findViewById(R.id.button)
        button.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_signupFragment)
        }

        return view
    }
}