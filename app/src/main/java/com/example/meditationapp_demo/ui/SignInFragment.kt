package com.example.meditationapp_demo.ui

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.navigation.Navigation
import com.example.meditationapp_demo.R
import com.google.android.material.textfield.TextInputEditText

class SignInFragment : Fragment() {

    lateinit var signIn_textView : ImageView
    lateinit var sign_Username : TextInputEditText
    lateinit var sign_Password : TextInputEditText
    lateinit var signIn_button : Button
    lateinit var sharedPreferences: SharedPreferences


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_in, container, false)


       //sharedPreferences = this@SignInFragment.get
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        signIn_button.setOnClickListener {
            val action = SignInFragmentDirections.actionSignInFragmentToHomeFragment()
            Navigation.findNavController(it).navigate(action)
        }

    }



    //Toast



}