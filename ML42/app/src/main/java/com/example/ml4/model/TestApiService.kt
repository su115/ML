package com.example.ml4.model

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TestApiService {
    var api:TestAPI
    init{
        val logging= HttpLoggingInterceptor()

        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client:OkHttpClient= OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
        val retrofit= Retrofit.Builder()
            .baseUrl("https://api.jsonbin.io/")
            .client(client).addConverterFactory(GsonConverterFactory.create())
            .build()
        api=retrofit.create(TestAPI::class.java)
    }
    companion object{
        const val SECRET_KEY = "\$2b\$10\$YP0i9MWBsQXfTDQHR.bEYOTiiB8zqJm7I7Cpii8xaMedbf5gc3G2."
    }
    interface wCallback{
        fun onSuccess(json:MyJson)
        fun onFailure()}

    fun getLocalJson(callback:wCallback) {
        api.getLocalJson(SECRET_KEY).enqueue(object: Callback<MyJson>
        {
            override fun onResponse(call:Call<MyJson>,response: Response<MyJson>)
            {
                if(response.code() ==200&& response.body()!=null)
                    callback.onSuccess(response.body()!!)
                else
                    callback.onFailure()}
            override fun onFailure(call: Call<MyJson>, t:Throwable)
            {
                callback.onFailure()}
        })
    }
}