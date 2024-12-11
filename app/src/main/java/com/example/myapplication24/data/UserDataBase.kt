package com.example.myapplication24.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication24.Constants.DATABASE_NAME
import com.example.myapplication24.data.dao.OrderDao
import com.example.myapplication24.data.dao.UserDao
import com.example.myapplication24.data.model.Order
import com.example.myapplication24.data.model.User

@Database (
    entities = [User::class, Order::class],
    version = 7,
    exportSchema = false
)
abstract class UserDataBase : RoomDatabase() {

    abstract fun userDao() : UserDao
    abstract fun orderDao() : OrderDao

    companion object {
        @Volatile
        private var INSTANCE: UserDataBase? = null

        fun getDataBase(context: Context): UserDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDataBase::class.java,
                    DATABASE_NAME
                ).fallbackToDestructiveMigration()
                .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}