package com.example.myapplication24.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplication24.R
import com.example.myapplication24.data.SharedPreferenceDatabase
import com.example.myapplication24.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {

    private var _binding : FragmentSplashBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView (
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        handleSplash()
    }

    private fun handleSplash() {
        Handler(Looper.myLooper()!!).postDelayed({
            if(SharedPreferenceDatabase.getId().isEmpty()) {
                findNavController().navigate(R.id.action_splashFragment_to_main_Page)
            } else {
                findNavController().navigate(R.id.action_splashFragment_to_main_Page)            }
        }, 1000)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}