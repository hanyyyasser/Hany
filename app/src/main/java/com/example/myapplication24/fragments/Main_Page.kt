package com.example.myapplication24.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.myapplication24.R
import com.example.myapplication24.data.SharedPreferenceDatabase
import com.example.myapplication24.data.UserViewModel
import com.example.myapplication24.databinding.FragmentMainPageBinding
import com.example.myapplication24.data.Babysitter
import com.example.myapplication24.data.BabysitterAdapter
class Main_Page : Fragment() {

    private var _binding: FragmentMainPageBinding? = null
    private val binding get() = _binding!!
    private val userViewModel: UserViewModel by viewModels()
    private lateinit var babysitterAdapter: BabysitterAdapter
    private  val  newArrayList= ArrayList<Babysitter>()

    // Use findNavController() to get the NavController instance
    private val navController by lazy { findNavController() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sayHi() // Show the greeting message
        setupBottomNavigation() // Set up Bottom Navigation item click listeners
        setRecycleerView() //recyclerView()
        onClick()
    }

    private fun onClick() {
        babysitterAdapter.onUserClick = object : BabysitterAdapter.OnUserClick {
            override fun onClick(babySitter: Babysitter) {
                findNavController().navigate (
                    Main_PageDirections.actionMainPageToDetailedProfile(babySitter.name, babySitter.price, babySitter.profileImageResId)
                )
            }
        }
    }

    private fun sayHi() {
        // Fetch the name using the userViewModel
        userViewModel.apply {
            val id = SharedPreferenceDatabase.getId()
            getName(id)
        }

        // Observe the name and update the greeting message
        binding.apply {
            userViewModel.name.observe(viewLifecycleOwner) { name ->
                textView3.text = "Hi, $name"
            }
        }
    }

    private fun setRecycleerView(){
        newArrayList.add(Babysitter("Alice", 25, R.drawable.babsitter))
        newArrayList.add(Babysitter("Alice", 25, R.drawable.babsitter))
        newArrayList.add(Babysitter("Alice", 25, R.drawable.babsitter))
        newArrayList.add(Babysitter("Alice", 25, R.drawable.babsitter))
        newArrayList.add(Babysitter("Alice", 25, R.drawable.babsitter))
        babysitterAdapter = BabysitterAdapter(newArrayList)
        binding.topView.adapter= babysitterAdapter
    }

    private fun setupBottomNavigation() {
        // Set up the BottomNavigationView's item selection listener
//        binding.bottomNavigationView2.setOnNavigationItemSelectedListener { menuItem ->
//            when (menuItem.itemId) {
//                R.id.nav_home -> {
//                    // Navigate to Main_Page
//                    navController.navigate(R.id.main_Page)
//                    true
//                }
//                R.id.profile -> {
//                    // Navigate to UserProfileFragment
//                    navController.navigate(R.id.action_main_Page_to_userProfileFragment)
//                    true
//                }
//                R.id.order -> {
//                    // Navigate to OrderPage
//                    navController.navigate(R.id.action_main_Page_to_order_Page)
//                    true
//                }
//                R.id.map -> {
//                    // Navigate to MapsFragment
//                    navController.navigate(R.id.action_main_Page_to_mapsFragment)
//                    true
//                }
//                else -> false
//            }
//        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
