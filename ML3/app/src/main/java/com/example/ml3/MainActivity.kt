package com.example.ml3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.util.Log
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.ml3.db.AppDatabase
import com.example.ml3.db.Delivery

class MainActivity : AppCompatActivity() {
    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initDatabase()
    }

    private fun initDatabase(){
        db = Room.databaseBuilder(applicationContext, AppDatabase::class.java,"test_db").allowMainThreadQueries().build()
    }

    override fun onResume() {
        super.onResume()
        testDB()
    }
    private fun testDB(){
        var f1=Delivery(1,"Kruta","9:00",22.20,true,5)
        var f2=Delivery(2,"Dashkevucha","10:00",15.20,false,3)
        var f3=Delivery(3,"Zelena","11:00",3.22,false,1)
        var f4=Delivery(4,"Korina","12:00",9.34,false,2)
        var f5=Delivery(5,"Zamarstunivska","13:00",32.20,true,6)

        // Insert
        db.DeliveryDao().insert(f1)
        log("first "+f1.adress)
        db.DeliveryDao().insert(f2)
        log("second "+f2.adress)
        db.DeliveryDao().insert(f3)
        log("third "+f3.adress)
        db.DeliveryDao().insert(f4)
        log("4th "+f4.adress)
        db.DeliveryDao().insert(f5)
        log("5th "+f5.adress)

        // Update
        db.DeliveryDao().update(Delivery(2,"Nobody_Know","00:00",100.0,false,10))
        log("Update second")
        //Delete
        db.DeliveryDao().delete(db.DeliveryDao().getById(1))
        log("Delete uid:1")
    }
    private fun log(message: String){
        Log.d("DataBaseTesting",message)
    }
}
