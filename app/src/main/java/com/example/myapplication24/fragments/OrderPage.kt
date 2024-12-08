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
import com.example.myapplication24.data.OrdersAdapter
import com.example.myapplication24.databinding.FragmentOrderPageBinding

class OrderPage : Fragment() {

    private var _binding: FragmentOrderPageBinding? = null
    private val binding get() = _binding!!
    private val orderViewModel : OrderViewModel by viewModels()
    private lateinit var ordersAdapter: OrdersAdapter
    private val navController by lazy { findNavController() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOrderPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClick()
        orderViewModel.getAllOrders()
        observers()
    }

    private fun onClick(){
        binding.imageView.setOnClickListener{
            navController.navigate(R.id.action_order_Page_to_main_Page)
        }
    }

    private fun observers() {
        orderViewModel.getAllOrdersLiveData.observe(viewLifecycleOwner) {
            ordersAdapter = OrdersAdapter(it)
            binding.ordersRecyclerView.adapter = ordersAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
