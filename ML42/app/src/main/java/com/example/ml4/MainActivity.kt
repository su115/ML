package com.example.ml4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.example.ml4.model.MyJson
import com.example.ml4.model.TestApiService

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViev()
    }
    lateinit var nameTV:TextView
    lateinit var addressTV:TextView
    lateinit var phoneTV:TextView

    private  fun initViev(){
        nameTV = findViewById(R.id.name)
        addressTV = findViewById(R.id.address)
        phoneTV = findViewById(R.id.phone)
    }

    override fun onResume() {
        super.onResume()
        loadData()
    }
    private fun loadData() {
        Log.d("API","loadData")
        val service= TestApiService()
        service.getLocalJson(object:TestApiService.wCallback
        {
            override fun onSuccess(weather:MyJson)
            {
                displayJson(weather)
            }
            override fun onFailure() {displayError()}})
    }

    private fun displayJson(js:MyJson) {
        Log.d("API","${js.people?.name}")
        Log.d("API","${js.people?.address}")
        Log.d("API","${js.pizza?.price}")

        nameTV.setText("People name:${js.people?.name}")
        addressTV.setText("Address:${js.people?.address}*C")
        phoneTV.setText("Phone:${js.people?.phone}:PIIZZA price:${js.pizza?.price}")}
    private fun displayError()
    {
        Log.d("API","error loading data")
        Toast.makeText(MainActivity@this,"Some PROBLEMS!!!",Toast.LENGTH_LONG).show()}
}