package com.example.myapplication24

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication24.data.User
import com.example.myapplication24.data.UserViewModel

class CompletingProfile : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var addressEditText: EditText
    private lateinit var numberOfChildrenEditText: EditText
    private lateinit var profileImageView: ImageView
    private lateinit var confirmButton: Button
    private lateinit var uploadImageButton: Button
    private val userViewModel: UserViewModel by viewModels()
    private var imageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_completing_profile)

        nameEditText = findViewById(R.id.namePRT)
        addressEditText = findViewById(R.id.NoOFChild)
        numberOfChildrenEditText = findViewById(R.id.Adress)
        profileImageView = findViewById(R.id.profileImageView)
        confirmButton = findViewById(R.id.confirmButton)
        uploadImageButton = findViewById(R.id.uploadImageButton)

        uploadImageButton.setOnClickListener {
            // Code to open gallery and select image
        }

        confirmButton.setOnClickListener {
            saveUserProfile()
        }
    }

    private fun saveUserProfile() {
        val name = nameEditText.text.toString().trim()
        val address = addressEditText.text.toString().trim()
        val numberOfChildren = numberOfChildrenEditText.text.toString().trim()

        if (name.isEmpty() || address.isEmpty() || numberOfChildren.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            return
        }


        val user = User("0", name, numberOfChildren, address)
        userViewModel.addUser(user)

        Log.d("CompletingProfile", "User profile saved: $name, $address, $numberOfChildren, $imageUri")

        val intent = Intent(this, UserProfileActivity::class.java)
        startActivity(intent)
        finish()
    }
}