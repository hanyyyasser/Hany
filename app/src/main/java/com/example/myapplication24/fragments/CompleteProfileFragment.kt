package com.example.myapplication24.fragments

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.myapplication24.R
import com.example.myapplication24.data.SharedPreferenceDatabase
import com.example.myapplication24.data.User
import com.example.myapplication24.data.UserViewModel
import com.example.myapplication24.databinding.FragmentCompleteProfileBinding

class CompleteProfileFragment : Fragment() {

    private var _binding : FragmentCompleteProfileBinding? = null
    private val binding get() = _binding!!

    private val userViewModel: UserViewModel by viewModels()
    private var imageUri: Uri? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCompleteProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initialize()
        onClicks()
    }

    private fun initialize() {
        Toast.makeText(requireActivity(), " ${SharedPreferenceDatabase.getId()}", Toast.LENGTH_LONG).show()
    }

    private fun onClicks() {
        binding.apply {
            uploadImageButton.setOnClickListener {
                // Code to open gallery and select image
            }
            confirmButton.setOnClickListener {
                saveUserProfile()
            }
        }
    }

    private fun saveUserProfile() {
        val name = binding.name.text.toString().trim()
        val address = binding.noOfChild.text.toString().trim()
        val numberOfChildren = binding.address.text.toString().trim()

        if (name.isEmpty() || address.isEmpty() || numberOfChildren.isEmpty()) {
            Toast.makeText(requireActivity(), "Please fill in all fields", Toast.LENGTH_SHORT).show()
            return
        }

        val user = User(SharedPreferenceDatabase.getId(), name, numberOfChildren, address)

        userViewModel.addUser(user)
        findNavController().navigate(R.id.action_completeProfileFragment_to_userProfileFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}