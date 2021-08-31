package com.example.meditationapp_demo.ui

import android.app.backup.SharedPreferencesBackupHelper
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.meditationapp_demo.databinding.FragmentSignInBinding

class SignInFragment : Fragment() {
    private lateinit var binding: FragmentSignInBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val sharedPreferences: SharedPreferences = requireActivity().applicationContext.getSharedPreferences("com.example.meditationapp_demo.ui",   Context.MODE_PRIVATE) // kotlin


        binding.signInButton.setOnClickListener {
            if (signInTextViewControl()){
                val direction = SignInFragmentDirections.actionSignInFragmentToHomeFragment()
                findNavController().navigate(direction)
            }

        }
    }

    fun signInTextViewControl() : Boolean{
        // username includes at least 2 characters, 1 upper, 1 small
        // password includes at least 1 upper, 1 small 1 special character
        if (binding.signUserName.length() <= 2) {
            binding.signUserName.setError("Username must be longer than 2 characters")
        } else if (binding.signPassword.length() < 6 || !"([A-Za-z0-9]+)".toRegex()
                .matches(binding.signPassword.text.toString())
        ) {
            binding.signPassword.setError("Password should consist minimum 6 characters with at least 1 uppercase, 1 number")
        }
        else {
            binding.signUserName.setError(null)
            binding.signPassword.setError(null)
            return true
        }
        return false
    }


}