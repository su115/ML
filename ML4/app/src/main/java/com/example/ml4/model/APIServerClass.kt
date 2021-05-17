package com.example.ml4.model

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.crypto.Cipher.SECRET_KEY

class APIServerClass {
    //val my_secret_key: String ="\$2b\$10\$YP0i9MWBsQXfTDQHR.bEYOTiiB8zqJm7I7Cpii8xaMedbf5gc3G2."
    var api:APIServer
    companion object {
        const val my_secret_key: String ="\$2b\$10\$YP0i9MWBsQXfTDQHR.bEYOTiiB8zqJm7I7Cpii8xaMedbf5gc3G2."
    }
    init {
        val logging =  HttpLoggingInterceptor()
        logging.setLevel(BODY)
        val client : OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.jsonbin.io/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        api = retrofit.create(APIServer::class.java)
    }


   fun getLocalPizza(callback: PizzaCallBack)
   {
       api.run {
           getLocalPizza(my_secret_key).enqueue(object : Callback<Pizza_1>
           //.enqueue(object : Callback<Pizza_1>
           {
               override fun onResponse(call: Call<Pizza_1>, response: Response<Pizza_1>) {
                   if (response.code() == 200)
                       callback.OnSuccess(response.body()!!)
                   else
                       callback.OnFail()
               }

               override fun onFailure(call: Call<Pizza_1>, t: Throwable) {
                   callback.OnFail()
               }
           }
           )
       }
   }
    interface PizzaCallBack{
        fun OnSuccess(pizza:Pizza_1)
        fun OnFail()
    }
}