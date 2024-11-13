package com.example.myapplication24.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
@Entity(tableName = "user_data")
data class User(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val noOfChildren: String,
    val address: String
) : Parcelable