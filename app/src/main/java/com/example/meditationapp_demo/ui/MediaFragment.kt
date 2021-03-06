package com.example.meditationapp_demo.ui

import android.graphics.drawable.AnimationDrawable
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.graphics.drawable.DrawableCompat
import androidx.databinding.DataBindingUtil.setContentView
import androidx.lifecycle.ViewModelProvider
import com.example.meditationapp_demo.R
import com.example.meditationapp_demo.databinding.FragmentMediaDesignBinding
import com.example.meditationapp_demo.databinding.FragmentSignInBinding


lateinit var pauseButton : ImageButton
private lateinit var binding: FragmentMediaDesignBinding


val url = "https://d2r0ihkco3hemf.cloudfront.net/bgxupraW2spUpr_y2.mp3" // your URL here
class MediaDesign : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val mediaPlayer = MediaPlayer().apply {
            setAudioAttributes(
                AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .build()
            )
            setDataSource(url)
            prepare()
            start()
        }

        binding.pauseButton.setOnClickListener {
            mediaPlayer.stop()
            pauseButton.setBackgroundResource(R.drawable.ic_circle_filled_24play);

        }


        return inflater.inflate(R.layout.fragment_media_design, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }


}