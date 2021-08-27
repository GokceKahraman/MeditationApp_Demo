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
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.meditationapp_demo.R
import com.example.meditationapp_demo.databinding.FragmentSignInBinding
import com.google.android.material.textfield.TextInputEditText

class SignInFragment : Fragment() {
    lateinit var signIn_textView : ImageView
    lateinit var sign_Username : TextInputEditText
    lateinit var sign_Password : TextInputEditText
    lateinit var signIn_button : Button
    lateinit var sharedPreferences: SharedPreferences
    private lateinit var binding: FragmentSignInBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignInBinding.inflate(inflater,container,false)



        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.signInButton.setOnClickListener {
            val direction = SignInFragmentDirections.actionSignInFragmentToHomeFragment()
            findNavController().navigate(direction)



        }
    }



}