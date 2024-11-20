package com.example.myapplication24.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.myapplication24.HomeActivity
import com.example.myapplication24.data.SharedPreferenceDatabase
import com.example.myapplication24.data.UserViewModel
import com.example.myapplication24.databinding.FragmentUserProfileBinding

class UserProfileFragment : Fragment() {

    private var _binding : FragmentUserProfileBinding? = null
    private val binding get() = _binding!!
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
        loadUserProfile()
    }

    private fun onClicks() {
        binding.editButton.setOnClickListener { openEditProfile() }
    }

    private fun loadUserProfile() {
        userViewModel.apply {
            val id = SharedPreferenceDatabase.getId()
            getName(id)
            getAddress(id)
            getNoOfChild(id)
        }

        binding.apply {
            userViewModel.name.observe(viewLifecycleOwner) { name.text = it }
            userViewModel.address.observe(viewLifecycleOwner) { address.text = it }
            userViewModel.noOfChild.observe(viewLifecycleOwner) { noOfChild.text = it }
        }
    }

    private fun openEditProfile() { }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}