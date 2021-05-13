package com.example.ml4.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface APIServer {
    @GET("b/609c0c70e0aabd6e191d27c4/2")
    fun getLocalPizza(@Header("secret-key") secretKey:String): Call<Pizza>
}