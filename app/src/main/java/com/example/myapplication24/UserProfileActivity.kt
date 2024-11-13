package com.example.myapplication24

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.ImageView
import android.graphics.BitmapFactory
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class UserProfileActivity : AppCompatActivity() {

    private lateinit var userNameTextView: TextView
    private lateinit var userEmailTextView: TextView
    private lateinit var profileImageView: ImageView
    private lateinit var editButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile) // Ensure this matches your XML file name

        userNameTextView = findViewById(R.id.ET1)
        userEmailTextView = findViewById(R.id.ET2)
        try {
            profileImageView = findViewById(R.id.profileImageView) // Make sure this is in your XML
        } catch (e: Exception) {
            Log.e("UserProfileActivity", "Error finding profileImageView", e)
        }
        editButton = findViewById(R.id.ET3)

        // Load user data
        loadUserProfile()

        // Set up edit button click listener
        editButton.setOnClickListener {
            openEditProfile()
        }
    }

    private fun loadUserProfile() {

    }

    private fun openEditProfile() {
        // Start the Complete_BabySitter activity to edit user details
        val intent = Intent(this, CompletingProfile::class.java)
        startActivity(intent)
    }
}