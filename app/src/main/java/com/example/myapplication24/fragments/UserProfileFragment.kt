package com.example.myapplication24.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.myapplication24.data.User
import com.example.myapplication24.data.UserViewModel
import com.example.myapplication24.databinding.FragmentUserProfileBinding

class UserProfileFragment : Fragment() {

    private var _binding : FragmentUserProfileBinding? = null
    private val binding get() = _binding!!
    private var userId : String? = null
    private val userViewModel : UserViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initialize()
        onClicks()
        loadUserProfile()
    }

    private fun initialize() {
        userId = UserProfileFragmentArgs.fromBundle(requireArguments()).userId
    }

    private fun onClicks() {
        binding.editButton.setOnClickListener { openEditProfile() }
    }

    private fun loadUserProfile() {  }

    private fun openEditProfile() {
        // Start the Complete_BabySitter activity to edit user details
        findNavController().popBackStack()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}