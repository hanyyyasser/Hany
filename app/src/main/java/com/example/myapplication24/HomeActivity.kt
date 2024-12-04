package com.example.myapplication24

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication24.data.SharedPreferenceDatabase
import com.example.myapplication24.data.UserDataBase
import com.example.myapplication24.data.UserRepository
import com.example.myapplication24.data.UserViewModel
import com.example.myapplication24.fragments.BabysitterListFragment

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        SharedPreferenceDatabase.initSharedPrefDatabase(this)


    }
    }

