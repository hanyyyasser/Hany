package com.example.myapplication24.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.myapplication24.R
import com.example.myapplication24.databinding.FragmentPaymentBinding

class payment : Fragment() {

    private var _binding : FragmentPaymentBinding? = null
    private val binding get() = _binding!!
    private val navController by lazy { findNavController() }
    private var costString : Int = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPaymentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        onClicks()
        setData()
        getData()
        setTax()
        calculateTotalPrice()
    }
    private fun onClicks() {

//            binding.() {
//                navController.navigate(R.id.action_payment_to_detailed_profile)
            }
    private fun getData() {
        costString = paymentArgs.fromBundle(requireArguments()).cost//edited
        Toast.makeText(requireActivity(), costString.toString(), Toast.LENGTH_SHORT).show()

    }

    private fun setData() {
        binding.apply {

            orderValue.text = costString.toString()//edited


        }
    }

    private fun setTax(){
        binding.apply {
            val orderValue = orderValue.text.toString().toInt()
            val taxValue = orderValue * 0.14
            taxesvalue.text = taxValue.toString()
        }

    }
    private fun calculateTotalPrice() {
        binding.apply {
            val orderValue = orderValue.text.toString().toInt()
            val TotalPriceValue = orderValue * 1.14

            totalPriceValue.text = TotalPriceValue.toString()
        }


    }
}




