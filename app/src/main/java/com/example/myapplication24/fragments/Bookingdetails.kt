package com.example.myapplication24.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication24.R
import com.example.myapplication24.databinding.FragmentBookingdetailsBinding
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.app.DatePickerDialog
import androidx.navigation.fragment.findNavController
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale





class Bookingdetails : Fragment() {

    private var _binding: FragmentBookingdetailsBinding? = null
    private val binding get() = _binding!!
    private val checkInCalendar = Calendar.getInstance()
    private val checkOutCalendar = Calendar.getInstance()
    private val navController by lazy { findNavController() }



    override
    fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBookingdetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.checkInDate.setOnClickListener {
            showDatePickerDialog(checkInCalendar, binding.checkInDate)
        }

        binding.checkOutDate.setOnClickListener {
            showDatePickerDialog(checkOutCalendar, binding.checkOutDate)
        }

        // Set up the calculate button click listener
        binding.confirmBotton.setOnClickListener {
            calculateDays()
        }

        binding.bkBtn.setOnClickListener(){
            navController.navigate(R.id.action_bookingdetails_to_detailed_profile)
        }

    }
    private fun showDatePickerDialog(calendar: Calendar, editText: EditText) {
        val datePickerDialog = DatePickerDialog(
            requireContext(),
            { _, year, month, dayOfMonth ->
                calendar.set(Calendar.YEAR, year)
                calendar.set(Calendar.MONTH, month)
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

                // Format the date as dd/MM/yyyy
                val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                editText.setText(dateFormat.format(calendar.time))
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.show()
    }

    private fun calculateDays() {
        try {
            val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
            val checkInDate = dateFormat.parse(binding.checkInDate.text.toString())
            val checkOutDate = dateFormat.parse(binding.checkOutDate.text.toString())

            if (checkInDate != null && checkOutDate != null) {
                val diffInMillis = checkOutDate.time - checkInDate.time
                val diffInDays = diffInMillis / (1000 * 60 * 60 * 24) // Convert to days
                binding.result.text = "Days Spent: $diffInDays"
            } else {
                binding.result.text = "Please select valid dates"
            }
        } catch (e: Exception) {
            binding.result.text = "Error calculating days"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Avoid memory leak by setting binding to null
        _binding = null
    }
}

