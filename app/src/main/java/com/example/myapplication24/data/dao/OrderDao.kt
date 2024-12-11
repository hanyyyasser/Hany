package com.example.myapplication24.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication24.data.model.Order

@Dao
interface OrderDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createOrder(order: Order)

    @Query("SELECT * FROM ORDERS_TABLE ORDER BY id DESC")
    fun getAllOrders() : List<Order>
}