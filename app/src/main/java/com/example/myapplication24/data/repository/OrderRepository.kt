package com.example.myapplication24.data.repository

import com.example.myapplication24.data.dao.OrderDao
import com.example.myapplication24.data.model.Order

class OrderRepository (
    private val orderDao: OrderDao
) {

    suspend fun createOrder(order: Order) = orderDao.createOrder(order)

    fun getAllOrders() : List<Order> = orderDao.getAllOrders()
}