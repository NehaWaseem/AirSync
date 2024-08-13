package com.example.fly.ui.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fly.R
import com.example.fly.adapter.UserAdapter
import com.example.fly.ui.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

//@AndroidEntryPoint
//class UserListFragment : Fragment() {
//
//    private lateinit var userViewModel: UserViewModel
//    private lateinit var userAdapter: UserAdapter
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        val view = inflater.inflate(R.layout.fragment_user_list, container, false)
//
//        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
//        recyclerView.layoutManager = LinearLayoutManager(context)
//
//        // Pass the click listener lambda to the adapter
//        userAdapter = UserAdapter(emptyList()) { user ->
//            val intent = Intent(activity, UserUpdateActivity::class.java).apply {
//                putExtra("userId", user.id)
//            }
//            startActivity(intent)
//        }
//        recyclerView.adapter = userAdapter
//
//        userViewModel = ViewModelProvider(requireActivity()).get(UserViewModel::class.java)
//
//        userViewModel.users.observe(viewLifecycleOwner) { users ->
//            userAdapter.updateData(users)
//        }
//
//        userViewModel.fetchAllUsers()
//
//        // Handle Add User button click
//        val addUserButton: Button = view.findViewById(R.id.addUserButton)
//        addUserButton.setOnClickListener {
//            val intent = Intent(activity, AddUserActivity::class.java)
//            startActivity(intent)
//        }
//
//
//        return view
//    }
//    override fun onResume() {
//        super.onResume()
//        userViewModel.fetchAllUsers() // Refresh data when the fragment is resumed
//    }
//}
@AndroidEntryPoint
class UserListFragment : Fragment() {

    private lateinit var userViewModel: UserViewModel
    private lateinit var userAdapter: UserAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_user_list, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Pass the click listener lambda to the adapter
        userAdapter = UserAdapter(emptyList()) { user ->
            val intent = Intent(activity, UserUpdateActivity::class.java).apply {
                putExtra("userId", user.id)
            }
            startActivity(intent)
        }
        recyclerView.adapter = userAdapter

        userViewModel = ViewModelProvider(requireActivity()).get(UserViewModel::class.java)

        //update
        userViewModel.users.observe(viewLifecycleOwner) { users ->
            userAdapter.updateData(users)
        }

        userViewModel.fetchAllUsers()

        // Handle Add User button click
        val addUserButton: Button = view.findViewById(R.id.addUserButton)
        addUserButton.setOnClickListener {
            val intent = Intent(activity, AddUserActivity::class.java)
            startActivity(intent)
        }

        // Handle filtering by flight number or date
        val flightNumberInput: EditText = view.findViewById(R.id.flightNumberInput)
        val dateInput: EditText = view.findViewById(R.id.dateInput)

        val filterButton: ImageButton= view.findViewById(R.id.filterStart)
        filterButton.setOnClickListener {
            val flightNumber = flightNumberInput.text.toString()
            val date = dateInput.text.toString()

            if (flightNumber.isNotEmpty() || date.isNotEmpty()) {
                userViewModel.fetchUsersByFlightNumberAndDate(flightNumber, date)
            } else {
                userViewModel.fetchAllUsers() // Fetch all users if no filter is applied
            }
        }


        return view
    }

    override fun onResume() {
        super.onResume()
        userViewModel.fetchAllUsers() // Refresh data when the fragment is resumed
    }
}