package com.example.myapplication24.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.myapplication24.R
import com.example.myapplication24.data.OrderViewModel
import com.example.myapplication24.data.model.Order
import com.example.myapplication24.databinding.FragmentPaymentBinding
import kotlin.math.roundToInt

class Payment : Fragment() {

    private var _binding: FragmentPaymentBinding? = null
    private val binding get() = _binding!!
    private val orderViewModel: OrderViewModel by viewModels()
    private var totalPrice : Double = 0.0
    private var costString: Int = 0
    private var nameString: String = ""
    private var image: Int = 0
    private var days: Long = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPaymentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getData()
        onClicks()
        setData()
        setTax()
        calculateTotalPrice()
        Toast.makeText(requireContext(), "Name: $days, Cost: $$costString", Toast.LENGTH_LONG).show()
    }

    private fun onClicks() {
        binding.apply {
            backPayment.setOnClickListener {
               findNavController().navigate(R.id.action_payment_to_bookingdetails)
            }
            buttonPay.setOnClickListener {
                // Check if the radio button is selected
                if (!radioButton.isChecked) {
                    // Show Toast if the radio button is not selected
                    Toast.makeText(requireContext(), "Please select a payment method", Toast.LENGTH_SHORT).show()
                } else {
                    addOrder()
                    findNavController().navigate(R.id.action_payment_to_final_One)
                }
            }
        }
    }

    private fun addOrder() {
        val order = Order(0, nameString, totalPrice.toInt(), image)
        orderViewModel.createOrder(order)
    }

    private fun getData() {
        costString = PaymentArgs.fromBundle(requireArguments()).cost
        image = PaymentArgs.fromBundle(requireArguments()).image
        nameString = PaymentArgs.fromBundle(requireArguments()).name
        days =  PaymentArgs.fromBundle(requireArguments()).diffInDays
    }

    private fun setData() {
        binding.apply {
            orderValue.text = costString.toString()
        }
    }

    private fun setTax() {
        binding.apply {
            val orderValue = orderValue.text.toString().toIntOrNull() ?: 0
            val taxValue = orderValue * 0.14
            taxesvalue.text = String.format("%.2f", taxValue)
        }
    }
    
    private fun calculateTotalPrice() {
        binding.apply {
            val orderValue = orderValue.text.toString().toInt()
            totalPrice = orderValue + taxesvalue.text.toString().toDouble()
            totalPriceValue.text = totalPrice.toString()
            totalValue.text = totalPrice.roundToInt().toString()
            extrafeesValue.text = costString.toString()
        }
    }
}




