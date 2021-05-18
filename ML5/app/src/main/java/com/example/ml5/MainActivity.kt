package com.example.ml5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle




class MainActivity : AppCompatActivity() {
    lateinit var db : RetrofitApiHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        db  = RetrofitApiHelper(applicationContext)


        db.testDB()

    }
}