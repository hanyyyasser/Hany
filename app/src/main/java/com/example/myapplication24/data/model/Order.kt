package com.example.myapplication24.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.myapplication24.Constants.ORDER_TABLE_NAME
import kotlinx.parcelize.Parcelize

@Entity(tableName = ORDER_TABLE_NAME)
@Parcelize
data class Order (
    @PrimaryKey(autoGenerate = true)
    val orderId : Int = 0,
    val name : String,
    val cost : Int,
    val image: Int
) : Parcelable
