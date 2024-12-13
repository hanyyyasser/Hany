package com.example.myapplication24.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.myapplication24.R
import com.example.myapplication24.databinding.FragmentDetailedProfileBinding

class DetailedProfile : Fragment() {

    private var _binding : FragmentDetailedProfileBinding? = null
    private val binding get() = _binding!!
    private val navController by lazy { findNavController() }

    private var nameString : String = ""
    private var costString : Int = 0
    private var image : Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailedProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()
        setData()
        onClicks()
    }
    private fun onClicks() {

        binding.backBtn.setOnClickListener() {
            navController.navigate(R.id.action_detailed_profile_to_main_Page)
        }
        binding.makeBtn.setOnClickListener(){
            navController.navigate(DetailedProfileDirections.actionDetailedProfileToBookingdetails(costString, nameString, image))
        }
    }

    private fun getData() {
        nameString = DetailedProfileArgs.fromBundle(requireArguments()).name
        costString = DetailedProfileArgs.fromBundle(requireArguments()).cost
        image = DetailedProfileArgs.fromBundle(requireArguments()).image

    }

    private fun setData() {
        binding.apply {
            nameBabysiiter.text = nameString
            costBabysitter.text = costString.toString()
            img.setImageResource(image)
        }
    }
}