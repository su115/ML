package com.example.ml5.Server


import android.util.Log
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
            .baseUrl("http://192.168.0.106:8000/")
            .client(client).addConverterFactory(GsonConverterFactory.create())
            .build()
        api=retrofit.create(TestAPI::class.java)
    }

    interface wCallback{
        fun onSuccess(json:LPizza)
        fun onFailure()}

    fun getLocalJson(callback:wCallback) {
        api.getLocalJson().enqueue(object: Callback<LPizza>
        {
            override fun onResponse(call:Call<LPizza>,response: Response<LPizza>)
            {
                if(response.code() ==200&& response.body()!=null)
                {
                    Log.d("API","Responce code"+response.code().toString())
                    callback.onSuccess(response.body()!!)
                }
                else
                    callback.onFailure()
            }
            override fun onFailure(call: Call<LPizza>, t:Throwable)
            {
                callback.onFailure()}
        })

    }
}