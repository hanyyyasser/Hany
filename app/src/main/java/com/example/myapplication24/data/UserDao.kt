package com.example.myapplication24.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUser(user: User)

    @Query("SELECT name FROM USERS_TABLE WHERE id = :userId")
    suspend fun getName(userId: String): String

    @Query("SELECT address FROM USERS_TABLE WHERE id = :userId")
    suspend fun getAddress(userId: String): String

    @Query("SELECT noOfChildren FROM USERS_TABLE WHERE id = :userId")
    suspend fun getNoOfChildren(userId: String): String

    @Query("SELECT * FROM USERS_TABLE")
    fun readAllData(): LiveData<List<User>>

    @Query("SELECT * FROM USERS_TABLE WHERE id = :userId LIMIT 1")
    fun getUserById(userId: String): User?
}