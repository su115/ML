package com.example.ml6

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.content_activity.*

class ContentActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_activity)

        ssid_cc.text = intent.getStringExtra("ssid")
        bssid_cc.text = intent.getStringExtra("security")
        level_cc.text = intent.getStringExtra("level")
        venueName_cc.text = intent.getStringExtra("venueName")
        frequency_cc.text = intent.getStringExtra("frequency")
        capabitities_cc.text = intent.getStringExtra("capabilities")
    }
}