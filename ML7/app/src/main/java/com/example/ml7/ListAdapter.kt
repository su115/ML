package com.example.ml7

import android.content.Context
import android.content.Intent
import android.net.wifi.ScanResult
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(context: Context,nets:List<ScanResult>): RecyclerView.Adapter<ListAdapter.ViewHolder>() {
    var context:Context=context
    var nets=nets


    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        var ssid = view.findViewById<TextView>(R.id.wifi_ssid_item)
        var bssid = view.findViewById<TextView>(R.id.bssid_item)
        var level =view.findViewById<TextView>(R.id.level_item)


        fun bind(result: ScanResult,context: Context,){
            Log.d("Scan",result.SSID.toString())
            ssid.text = result.SSID.toString()
            level.text = result.level.toString()
            bssid.text = result.BSSID
            itemView.setOnClickListener() {
                val i = Intent(context, ContentActivity::class.java).apply {
                    putExtra("ssid",ssid.toString())
                    putExtra("level",level.toString())
                    putExtra("bssid",bssid.toString())
                    putExtra("venueName",result.BSSID)
                    putExtra("frequency",result.frequency.toString())
                    putExtra("capabilities",result.capabilities.toString())

                }
                context.startActivity(i)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var inflater = LayoutInflater.from(context)
        return ViewHolder(inflater.inflate(R.layout.item_list, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var element = nets[position]
        holder.bind(element,context)
    }

    override fun getItemCount(): Int {
        return this.nets.size
    }

}