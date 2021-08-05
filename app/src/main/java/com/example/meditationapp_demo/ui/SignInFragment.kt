package com.example.meditationapp_demo.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import com.example.meditationapp_demo.R
import com.google.android.material.textfield.TextInputEditText

class SignInFragment : Fragment() {

    lateinit var signIn_textView : ImageView
    lateinit var sign_Username : TextInputEditText
    lateinit var sign_Password : TextInputEditText
    lateinit var signIn_button : Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_in, container, false)

        signIn_button.setOnClickListener{
        }


    }


}