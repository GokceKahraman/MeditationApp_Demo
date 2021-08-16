package com.example.meditationapp_demo.model

data class DataClass(
    var isBannerEnabled: Boolean,
    val meditations: ArrayList<Meditation>,
    val stories: ArrayList<Story>
)

