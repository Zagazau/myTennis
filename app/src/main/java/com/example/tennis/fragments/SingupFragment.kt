package com.example.tennis.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.mytennis.R
import com.example.tennis.viewmodel.AuthViewModel

class SignupFragment : Fragment() {

    private val authViewModel: AuthViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.signup, container, false)

        val firstName: EditText = view.findViewById(R.id.first_name)
        val lastName: EditText = view.findViewById(R.id.last_name)
        val email: EditText = view.findViewById(R.id.email)
        val password: EditText = view.findViewById(R.id.password)
        val signupButton: Button = view.findViewById(R.id.signup_button)

        signupButton.setOnClickListener {
            val emailText = email.text.toString()
            val nameText = "${firstName.text} ${lastName.text}"
            val passwordText = password.text.toString()
            authViewModel.register(emailText, nameText, passwordText)
        }

        return view
    }
}
