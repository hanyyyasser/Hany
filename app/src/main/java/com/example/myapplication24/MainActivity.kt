package com.example.myapplication24

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.myapplication24.data.UserViewModel
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var signupText: TextView
    private lateinit var mAuth: FirebaseAuth
    private val userViewModel: UserViewModel by viewModels()
    var userId: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAuth = FirebaseAuth.getInstance()

        usernameEditText = findViewById(R.id.username)
        passwordEditText = findViewById(R.id.password)
        loginButton = findViewById(R.id.loginButton)
        signupText = findViewById(R.id.signupText)

        loginButton.setOnClickListener { loginUser() }

        signupText.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }
    }

    private fun loginUser() {
        val email = usernameEditText.text.toString().trim()
        val password = passwordEditText.text.toString().trim()

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            return
        }

        try {
            mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
                        userId = mAuth.currentUser?.uid
                        Log.d("MainActivity", "Login successful")
                        checkUserProfile()
                    } else {
                        Toast.makeText(this, "Authentication failed: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                        Log.e("MainActivity", "Authentication failed: ${task.exception?.message}")
                    }
                }
        } catch (e: Exception) {
            Toast.makeText(this, "Error logging in: ${e.message}", Toast.LENGTH_SHORT).show()
            Log.e("MainActivity", "Error logging in: ${e.message}")
        }
    }

    private fun checkUserProfile() {
//        userId?.let { id ->
//            userViewModel.isUserProfileComplete(id.toInt()) { isComplete ->
//                if (isComplete) {
//                    startActivity(Intent(this@MainActivity, UserProfileActivity::class.java))
//                } else {
//                    startActivity(Intent(this@MainActivity, CompletingProfile::class.java))
//                }
//                finish()
//            }
//        }
    }
}