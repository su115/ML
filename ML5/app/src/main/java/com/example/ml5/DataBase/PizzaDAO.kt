package com.example.ml5.DataBase

import androidx.room.*

@Dao
interface PizzaDao{
    @Query("SELECT * FROM pizza")
    fun getAll():List<Pizza_d>

    @Query("SELECT * FROM pizza WHERE uid=(:num)")
    fun getById(num:Int):Pizza_d

    @Query(value = "SELECT * FROM pizza WHERE pizza_name=(:name)"    )
    fun getByName(name:String):Pizza_d

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(pizzaDao: Pizza_d)

    @Delete
    fun delete(Pizza:Pizza_d)
    @Update
    fun update(delivery: Pizza_d)
}