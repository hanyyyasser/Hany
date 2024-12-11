package com.example.myapplication24.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.CASCADE
import com.example.myapplication24.Constants.USERS_TABLE_NAME

@Entity (
    tableName = USERS_TABLE_NAME,
)
@Parcelize
data class User(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val name: String,
    val noOfChildren: String,
    val address: String
) : Parcelable