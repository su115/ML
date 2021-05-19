package com.example.ml5.DataBase


import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Pizza_d::class),version = 2)
abstract class AppDatabase:RoomDatabase(){
    abstract fun PizzaDao():PizzaDao
}