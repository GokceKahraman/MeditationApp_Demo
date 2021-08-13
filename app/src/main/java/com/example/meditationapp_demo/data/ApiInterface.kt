package com.example.meditationapp_demo.data

import com.example.meditationapp_demo.model.DataClass
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiInterface {
    @GET("jsonBlob/{id}")
    fun listData(@Path("id") id: String): Call<DataClass>
}