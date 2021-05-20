package com.example.ml6


import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.wifi.ScanResult
import android.net.wifi.WifiManager
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    lateinit var wifiManager: WifiManager


    lateinit var adapter:ListAdapter
    lateinit var listView:RecyclerView

    lateinit var scan_resa:List<ScanResult>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        detectWifi()

        //RecyclerView
        this.listView = findViewById(R.id.tvRcList)
        this.listView.hasFixedSize()
        this.listView.layoutManager = LinearLayoutManager(this)

        //Adapter
        Log.d("main",wifiManager.scanResults[0].SSID)
        this.adapter = ListAdapter(this,wifiManager.scanResults)
        this.listView.adapter = adapter

    }


    fun detectWifi(){
        this.wifiManager = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager

        val wifiScanReceiver = object : BroadcastReceiver() {

            override fun onReceive(context: Context, intent: Intent) {
                val success = intent.getBooleanExtra(WifiManager.EXTRA_RESULTS_UPDATED, false)
                if (success) {
                    scanSuccess()
                } else {
                    scanFailure()
                }
            }
        }
        wifiManager.startScan()
        //this.scan_resa=wifiManager.scanResults.




    }

    private fun scanSuccess() {
        this.scan_resa = wifiManager.scanResults
    }

    private fun scanFailure() {
        this.scan_resa = wifiManager.scanResults
    }
}