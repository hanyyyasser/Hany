package com.example.myapplication24.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.myapplication24.R
import com.example.myapplication24.data.OrderViewModel
import com.example.myapplication24.data.model.Order
import com.example.myapplication24.databinding.FragmentPaymentBinding

class Payment : Fragment() {

    private var _binding : FragmentPaymentBinding? = null
    private val binding get() = _binding!!
    private val navController by lazy { findNavController() }
    private val orderViewModel : OrderViewModel by viewModels()
    private var costString : Int = 0
    private var nameString : String = ""
    private var image : Int = 0

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
        binding.apply {
            // navController.navigate(R.id.action_payment_to_detailed_profile)
            buttonPay.setOnClickListener {
                addOrder()
                findNavController().navigate(R.id.action_payment_to_order_Page)
            }
        }
    }

    private fun addOrder() {
        val order = Order(0, nameString, costString, image)
        orderViewModel.createOrder(order)
    }

    private fun getData() {
        costString = PaymentArgs.fromBundle(requireArguments()).cost
        nameString = PaymentArgs.fromBundle(requireArguments()).name
        image = PaymentArgs.fromBundle(requireArguments()).image
    }

    private fun setData() {
        binding.apply {
            orderValue.text = costString.toString() // edited
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




