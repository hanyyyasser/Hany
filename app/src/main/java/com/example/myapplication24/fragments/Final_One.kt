package com.example.myapplication24.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplication24.R
import com.example.myapplication24.databinding.FragmentBookingdetailsBinding
import com.example.myapplication24.databinding.FragmentFinalOneBinding


class Final_One : Fragment() {

    private var _binding: FragmentFinalOneBinding? = null
    private val binding get() = _binding!!
    private val navController by lazy { findNavController() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentFinalOneBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClick()

    }
    private fun onClick() {
        binding.checkYourOrder.setOnClickListener {
            navController.navigate(R.id.action_final_One_to_order_Page)
        }
    }

}