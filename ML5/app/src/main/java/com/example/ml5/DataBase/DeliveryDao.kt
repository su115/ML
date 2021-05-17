package com.example.ml5.DataBase

import androidx.room.*

@Dao
interface DeliveryDao{
    @Query("SELECT * FROM pizza")
    fun getAll():List<Delivery>

    @Query("SELECT * FROM pizza WHERE uid=(:num)")
    fun getById(num:Int):Delivery

    @Query(value = "SELECT * FROM pizza WHERE toAdress=(:address)"    )
    fun getByAddres(address:String):Delivery

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(delivery: Delivery)

    @Delete
    fun delete(delivery: Delivery)
    @Update
    fun update(delivery: Delivery)
}