package com.example.ml5.Server

import retrofit2.Call
import retrofit2.http.GET
//import retrofit2.http.Header
//import javax.crypto.SecretKey

interface TestAPI {
    @GET("json")
    fun getLocalJson():Call<LPizza>
}