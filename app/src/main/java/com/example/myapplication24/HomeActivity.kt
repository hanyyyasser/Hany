package com.example.myapplication24

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication24.data.SharedPreferenceDatabase

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        SharedPreferenceDatabase.initSharedPrefDatabase(this)


    }
    }

