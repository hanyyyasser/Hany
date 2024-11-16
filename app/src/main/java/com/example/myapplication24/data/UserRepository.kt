package com.example.myapplication24.data

import androidx.lifecycle.LiveData

class UserRepository(private val userDao: UserDao) {

    val readAllData: LiveData<List<User>> = userDao.readAllData()

    suspend fun addUser(user: User) {
        userDao.addUser(user)
    }

//    suspend fun isUserProfileComplete(userId: Int): Boolean {
//        val user = userDao.getUserById(userId)
//        return user != null && user.name.isNotEmpty() && user.address.isNotEmpty() && user.noOfChildren.isNotEmpty()
//    }
}