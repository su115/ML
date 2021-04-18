package com.example.ml3.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Delivery::class),version = 1)
abstract class AppDatabase:RoomDatabase(){
    abstract fun DeliveryDao():DeliveryDao
}