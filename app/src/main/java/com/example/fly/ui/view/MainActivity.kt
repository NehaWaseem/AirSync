package com.example.fly.ui.view

import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.fly.R
import com.example.fly.ui.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

//@AndroidEntryPoint
//class MainActivity : AppCompatActivity() {
//
//    private val userViewModel: UserViewModel by viewModels()
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//
////        userViewModel.insertUser(User(name = "Samantha Riz", age = 30))
////        userViewModel.insertUser(User(name = "Jane Smith", age = 23))
////        userViewModel.insertUser(User(name = "Ronald Smith", age = 28))
////        userViewModel.insertUser(User(name = "Joe Smith", age = 12))
////        userViewModel.insertUser(User(name = "Jace Smith", age = 98))
//
//
//
//        val showRecyclerViewButton = findViewById<Button>(R.id.button_on_image)
//        showRecyclerViewButton.setOnClickListener {
//            // Insert dummy data
//
//            // Navigate to UserListFragment
//            supportFragmentManager.commit {
//                replace(android.R.id.content, UserListFragment()) // Replaces the entire content view
//                addToBackStack(null) // Optional: Allows navigation back to the previous screen
//            }
//        }
//    }
//}

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val showRecyclerViewButton = findViewById<Button>(R.id.button_on_image)
        showRecyclerViewButton.setOnClickListener {
            // Navigate to UserListFragment
            supportFragmentManager.commit {
                replace(android.R.id.content, UserListFragment()) // Replaces the entire content view
                addToBackStack(null) // Optional: Allows navigation back to the previous screen
            }
        }
    }
}