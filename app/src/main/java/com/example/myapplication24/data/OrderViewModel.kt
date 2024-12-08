package com.example.myapplication24.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.myapplication24.data.model.Order
import com.example.myapplication24.data.repository.OrderRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class OrderViewModel (
    application: Application
) : AndroidViewModel(application) {

    private val orderRepository : OrderRepository

    private var _getAllOrdersLiveData = MutableLiveData<List<Order>>()
    val getAllOrdersLiveData : LiveData<List<Order>> get() = _getAllOrdersLiveData

    init {
        val orderDao = UserDataBase.getDataBase(application).orderDao()
        orderRepository = OrderRepository(orderDao)
    }

    fun createOrder(order: Order) {
        viewModelScope.launch(Dispatchers.IO) {
            orderRepository.createOrder(order)
        }
    }

    fun getAllOrders() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val data = orderRepository.getAllOrders()
                _getAllOrdersLiveData.postValue(data)
            } catch (exception : Exception) {
                exception.printStackTrace()
            }
        }
    }

}