package com.example.myapplication24.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Insert
    suspend fun addUser(user: User)

    @Query("SELECT * FROM user_data")
    fun readAllData(): LiveData<List<User>>

    @Query("SELECT * FROM user_data WHERE id = :userId LIMIT 1")
    suspend fun getUserById(userId: Int): User?
}