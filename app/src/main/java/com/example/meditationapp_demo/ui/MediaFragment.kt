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
import androidx.databinding.DataBindingUtil.setContentView
import androidx.lifecycle.ViewModelProvider
import com.example.meditationapp_demo.R


lateinit var media_headerText : TextView
lateinit var media_detailText : TextView
lateinit var media_dateText : TextView
lateinit var playImage : TextView
private lateinit var playAnimation: AnimationDrawable



class MediaDesign : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_media_design)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_media_design, container, false)



        playImage.findViewById<TextView>(R.id.playImage).apply {
            setBackgroundResource(R.drawable.animation_play_pause)
            playAnimation = background as AnimationDrawable
        }

        playImage.setOnClickListener({ playAnimation.start() })

        val url = "https://d2r0ihkco3hemf.cloudfront.net/bgxupraW2spUpr_y2.mp3" // your URL here
        val mediaPlayer = MediaPlayer().apply {
            setAudioAttributes(
                AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .build()
            )
            setDataSource(url)
            prepare() // might take long! (for buffering, etc)
            start()
        }


    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


      //  viewModel = ViewModelProvider.
    }


}