package com.example.ml5

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.example.ml5.Server.LPizza
import com.example.ml5.Server.Pizza
import com.example.ml5.Server.TestApiService

class RetrofitApiHelper(context: Context){
    var context: Context
    lateinit var lpizza:LPizza

    init {
        this.context = context

    }

    fun loadData(): LPizza? {
        //load data in log

        Log.d("API", "loadData")
        val service= TestApiService()
        service.getLocalJson(object : TestApiService.wCallback {
            override fun onSuccess(json: LPizza) {
                for (i in json.pizzas!!) {

                    displayJson(i)
                }

            }

            override fun onFailure() {
                displayError()
            }
        })

                var s = service.api.getLocalJson().execute().body()
                return s

    }

    private fun displayJson(pizza: Pizza) {
        Log.d("API", pizza.pizzaName.toString())
    }


    private fun displayError()
    {
        Log.d("API", "error loading data")
        Toast.makeText(this.context, "Some PROBLEMS!!!", Toast.LENGTH_LONG).show()
    }


}