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
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication24.data.Babysitter
import com.example.myapplication24.data.BabysitterAdapter

class BabysitterListFragment : Fragment(R.layout.fragment_main__page) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        // Initialize RecyclerView
        val babysitterRecyclerView: RecyclerView = view.findViewById(R.id.topView)

        val babysitters = listOf(
            Babysitter("Alice", 25, R.drawable.babsitter),
            Babysitter("Bob", 30, R.drawable.babsitter),
            Babysitter("Charlie", 28, R.drawable.babsitter),
            Babysitter("David", 35, R.drawable.babsitter) ,
        Babysitter("Bob", 30, R.drawable.babsitter),
        Babysitter("Charlie", 28, R.drawable.babsitter),
        Babysitter("David", 35, R.drawable.babsitter)
        )

        // Set up RecyclerView with Adapter
//        babysitterRecyclerView.layoutManager = LinearLayoutManager(requireContext())
//        babysitterRecyclerView.adapter = BabysitterAdapter(babysitters)
    }
}
