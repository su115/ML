package com.example.ml5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ml5.Server.LPizza
import com.example.ml5.Server.Pizza
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity(){
    lateinit var db : RoomApiHelper
    lateinit var serv: RetrofitApiHelper
    lateinit var lpizzas:LPizza
    lateinit var presenter: MainPresenter
    lateinit var listView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //DataBase init
        db  = RoomApiHelper(applicationContext)
        db.testDB()

        // init server
        serv = RetrofitApiHelper(applicationContext)

        // Network on main thread error !!! I change policy to alow it !!!
        var policy:StrictMode.ThreadPolicy
        policy =  StrictMode.ThreadPolicy.Builder()
                        .permitAll().build();
        StrictMode.setThreadPolicy(policy)

        // Pizza from server to database load and get list of pizza from server
        this.lpizzas = serv.loadData()!!
        db.addPizzas(lpizzas)
        this.lpizzas.pizzas?.get(0)




        //Adapter
        this.listView = findViewById(R.id.rcView_main)
        this.listView.hasFixedSize()
        this.listView.layoutManager = LinearLayoutManager(this)

        var grabli:Pizza? = null
        this.presenter = MainPresenter(this,lpizzas,grabli)
        this.listView.adapter = presenter
        //MainPresenter(this,lpizzas)

    }

    private fun tvListview(listView: ListView) {
        //base init
        var l_s = ArrayList<String>()
        l_s.add( "Igor")
        l_s.add( "Bogdan")
        l_s.add( "Nazar")
        l_s.add("Dima")
        l_s.add("Valentyn")
        val adapter =  ArrayAdapter(this,android.R.layout.simple_list_item_1,l_s)
        //var myListView = findViewById<ListView>(R.id.myListView)
        listView.adapter = adapter

        //listener
        listView.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this,"Presed istem positeon:$position ${l_s.get(position)}",Toast.LENGTH_LONG).show()
        }
    }


}