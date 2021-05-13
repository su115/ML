package com.example.ml4.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
//import javax.crypto.SecretKey

interface TestAPI {
    @GET("b/609c0c70e0aabd6e191d27c4/1")
    fun getLocalJson(@Header("secret-key") secretKey:String):Call<MyJson>
}