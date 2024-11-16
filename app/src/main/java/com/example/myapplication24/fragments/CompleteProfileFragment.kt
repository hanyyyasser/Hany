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
import com.example.myapplication24.data.User
import com.example.myapplication24.data.UserViewModel
import com.example.myapplication24.databinding.FragmentCompleteProfileBinding

class CompleteProfileFragment : Fragment() {

    private var _binding : FragmentCompleteProfileBinding? = null
    private val binding get() = _binding!!

    private val userViewModel: UserViewModel by viewModels()
    private var imageUri: Uri? = null
    private var userId : Int? = 0

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
        userId = CompleteProfileFragmentArgs.fromBundle(requireArguments()).userId
        Toast.makeText(requireActivity(), " $userId", Toast.LENGTH_LONG).show()
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
        val name = binding.namePRT.text.toString().trim()
        val address = binding.NoOFChild.text.toString().trim()
        val numberOfChildren = binding.Adress.text.toString().trim()

        if (name.isEmpty() || address.isEmpty() || numberOfChildren.isEmpty()) {
            Toast.makeText(requireActivity(), "Please fill in all fields", Toast.LENGTH_SHORT).show()
            return
        }


        val user = User("0", name, numberOfChildren, address)
        userViewModel.addUser(user)

        Log.d("CompletingProfile", "User profile saved: $name, $address, $numberOfChildren, $imageUri")

        findNavController().navigate(R.id.action_completeProfileFragment_to_userProfileFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}