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

        // Define 5 locations in Cairo, Egypt
        val locations = listOf(
            LatLng(30.1605, 31.6422),
            LatLng(30.1600, 31.6440),
            LatLng(30.1585, 31.6400),
            LatLng(30.1620, 31.6385),
            LatLng(30.1595, 31.6365)
        )

        // Names of 5 people for the location pins
        val names = listOf("Alice", "Sara", "victoria", "skyler", "anny")

        // Add markers for each location with a person's name as the title
        for (i in locations.indices) {
            mMap.addMarker(MarkerOptions().position(locations[i]).title(names[i]))
        }

        // Move the camera to the first location (Cairo Tower)
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(locations[0], 16f))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
