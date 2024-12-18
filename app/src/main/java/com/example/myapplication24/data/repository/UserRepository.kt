package com.example.myapplication24.data.repository

import androidx.lifecycle.LiveData
import com.example.myapplication24.data.dao.UserDao
import com.example.myapplication24.data.model.User

class UserRepository(private val userDao: UserDao) {

     val readAllData: LiveData<List<User>> = userDao.readAllData()

    suspend fun addUser(user: User) {
        userDao.addUser(user)
    }

    suspend fun getName(userId: String): String {
        return userDao.getName(userId)
    }

    suspend fun getAddress(userId: String): String {
        return userDao.getAddress(userId)
    }

    suspend fun getNoOfChildren(userId: String): String {
        return userDao.getNoOfChildren(userId)
    }

    fun isUserProfileComplete(userId: String): Boolean {
        val user = userDao.getUserById(userId)
        return user != null && user.name.isNotEmpty() && user.address.isNotEmpty() && user.noOfChildren.isNotEmpty()
    }
}