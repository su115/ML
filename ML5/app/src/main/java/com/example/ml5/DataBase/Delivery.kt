package com.example.ml5.DataBase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Time

@Entity(tableName = "pizza")
data class Delivery (
    @PrimaryKey(autoGenerate = true)val uid:Int,
    @ColumnInfo(name="toAdress")val adress:String,
    @ColumnInfo(name="time")val time:String,
    @ColumnInfo(name="price")val price:Double,
    @ColumnInfo(name="isCard")val isCard:Boolean,
    @ColumnInfo val pizzaCount:Int,
)