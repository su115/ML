package com.example.ml5

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.room.Room
import com.example.ml5.DataBase.AppDatabase
import com.example.ml5.DataBase.Pizza_d
import com.example.ml5.Server.LPizza


class RoomApiHelper(context: Context){
     var db: AppDatabase
     var context: Context
     var uid:Int
   // initDatabase()
    init{
        this.uid = 0
        this.context = context
        this.db = Room.databaseBuilder(context , AppDatabase::class.java,"test_db").allowMainThreadQueries().build()

    }


       // testDB()

    fun testDB(){
        var f1=Pizza_d(1,"pizza1","wiki.org",100,510,40)
        var f2=Pizza_d(2,"Dashkevucha","10:00",400,700,30)
        var f3=Pizza_d(3,"Zelena","11:00",300,800,50)
        var f4=Pizza_d(4,"Korina","12:00",200,700,50)
        var f5=Pizza_d(5,"Zamarstunivska","13:00",300,600,50)

        // Insert
        db.PizzaDao().insert(f1)
        log("Pizza added: "+f1.pizza_name)
        db.PizzaDao().insert(f2)
        log("Pizza added: "+f2.pizza_name)
        db.PizzaDao().insert(f3)
        log("Pizza added: "+f3.pizza_name)
        db.PizzaDao().insert(f4)
        log("Pizza added: "+f4.pizza_name)
        db.PizzaDao().insert(f5)
        log("Pizza added: "+f5.pizza_name)

        // Update
        db.PizzaDao().update(Pizza_d(2,"Nobody_Know","00:00",100,500,30))
        log("Update second pizza")
        //Delete
        db.PizzaDao().delete(db.PizzaDao().getById(1))
        log("Delete uid:1")
    }
    private fun log(message: String){
        Log.d("DataBaseTesting",message)
    }


    fun addPizzas(lpizza: LPizza){

        lateinit var pizza:Pizza_d
        for (i in lpizza.pizzas!!){
            pizza = Pizza_d(this.uid, i.pizzaName!!,i.linkPhoto!!,i.price!!,i.mass!!,i.diameter!!)
            db.PizzaDao().insert(pizza)
            this.uid+=1
        }
    }

}