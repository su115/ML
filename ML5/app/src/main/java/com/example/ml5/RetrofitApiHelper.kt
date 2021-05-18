package com.example.ml5

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.room.Room
import com.example.ml5.DataBase.AppDatabase
import com.example.ml5.DataBase.Delivery


class RetrofitApiHelper(context: Context){
     lateinit var db: AppDatabase
     lateinit var context: Context

   // initDatabase()
    init{
        this.context = context
        this.db = Room.databaseBuilder(context , AppDatabase::class.java,"test_db").allowMainThreadQueries().build()

    }


       // testDB()

    fun testDB(){
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