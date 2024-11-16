package com.example.myapplication24.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.myapplication24.R
import com.example.myapplication24.data.UserViewModel
import com.example.myapplication24.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginFragment : Fragment() {

    private var _binding : FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private lateinit var mAuth: FirebaseAuth
    private val userViewModel: UserViewModel by viewModels()
    private var userId: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mAuth = FirebaseAuth.getInstance()

        onClicks()
    }

    private fun onClicks() {
        binding.apply {
            loginButton.setOnClickListener { loginUser() }
            signupText.setOnClickListener { findNavController().navigate(R.id.action_loginFragment_to_signUpFragment) }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun loginUser() {
        val email = binding.username.text.toString().trim()
        val password = binding.password.text.toString().trim()

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(requireActivity(), "Please fill in all fields", Toast.LENGTH_SHORT).show()
            return
        }

        try {
            mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(requireActivity()) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(requireActivity(), "Login successful", Toast.LENGTH_SHORT).show()
                        userId = mAuth.currentUser?.uid
                        Log.d("MainActivity", "Login successful")
                        findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToUserProfileFragment(userId!!))
                        // checkUserProfile()
                    } else {
                        Toast.makeText(
                            requireActivity(),
                            "Authentication failed: ${task.exception?.message}",
                            Toast.LENGTH_SHORT
                        ).show()
                        Log.e("MainActivity", "Authentication failed: ${task.exception?.message}")
                    }
                }
        } catch (e: Exception) {
            Toast.makeText(requireActivity(), "Error logging in: ${e.message}", Toast.LENGTH_SHORT).show()
            Log.e("MainActivity", "Error logging in: ${e.message}")
        }
    }

    private fun checkUserProfile() {

//        userId?.let { id ->
//            userViewModel.isUserProfileComplete(id) { isComplete ->
//                if (isComplete) {
//                    findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToUserProfileFragment(id))
//                } else {
//                    findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToCompleteProfileFragment(id))
//                }
//            }
//        }
    }

}