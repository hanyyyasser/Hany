package com.example.myapplication24.fragments

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.myapplication24.R
import com.example.myapplication24.databinding.FragmentMapsBinding

class mapsFragment : Fragment(), OnMapReadyCallback {

    private var _binding: FragmentMapsBinding? = null
    private val binding get() = _binding!!

    private lateinit var mMap: GoogleMap

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMapsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize the map
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

//        // Handle button click if needed
//        binding.someButton.setOnClickListener {
//            findNavController().navigate(R.id.some_destination)
//        }
    }

    // This method is called when the map is ready
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Enable location services if granted
        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            mMap.isMyLocationEnabled = true
        }

        // Define 5 pinned locations
        val locations = listOf(
            LatLng(37.7749, -122.4194), // San Francisco
            LatLng(34.0522, -118.2437), // Los Angeles
            LatLng(40.7128, -74.0060),  // New York
            LatLng(51.5074, -0.1278),   // London
            LatLng(48.8566, 2.3522)     // Paris
        )

        // Add markers for each location
        val titles = listOf("San Francisco", "Los Angeles", "New York", "London", "Paris")
        for (i in locations.indices) {
            mMap.addMarker(MarkerOptions().position(locations[i]).title(titles[i]))
        }

        // Move the camera to one of the locations (e.g., San Francisco)
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(locations[0], 10f))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
