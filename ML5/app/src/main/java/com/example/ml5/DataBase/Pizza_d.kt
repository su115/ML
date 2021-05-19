package com.example.ml5.DataBase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Time

@Entity(tableName = "pizza")
data class Pizza_d (
    @PrimaryKey(autoGenerate = true)val uid:Int,
    @ColumnInfo(name="pizza_name")val pizza_name:String,
    @ColumnInfo(name="link")val link:String,
    @ColumnInfo(name="price")val price:Int,
    @ColumnInfo(name="mass")val mass:Int,
    @ColumnInfo(name="diameter") val diameter:Int,
)