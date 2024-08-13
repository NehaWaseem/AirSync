package com.example.fly.ui.view

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.fly.R
import com.example.fly.data.local.entities.Flight
import com.example.fly.ui.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

//@AndroidEntryPoint
//class AddUserActivity : AppCompatActivity() {
//
//    private val userViewModel: UserViewModel by viewModels()
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_add_user)
//
//        val userNameInput = findViewById<EditText>(R.id.userNameInput)
//        val userAgeInput = findViewById<EditText>(R.id.userAgeInput)
//        val addButton = findViewById<Button>(R.id.addButton)
//
//        addButton.setOnClickListener {
//            val name = userNameInput.text.toString()
//            val age = userAgeInput.text.toString().toInt()
//
//            // Create a new user
//            val newUser = User(name = name, age = age)
//            userViewModel.insertUser(newUser)
//
//            // Finish activity and return to previous screen
//            finish()
//        }
//    }
//}
@AndroidEntryPoint
class AddUserActivity : AppCompatActivity() {

    private val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_user)

        val userNameInput = findViewById<EditText>(R.id.userNameInput)
        val userAgeInput = findViewById<EditText>(R.id.userAgeInput)
        //val passengerNameInput = findViewById<EditText>(R.id.passengerNameInput)
        val flightNumberInput = findViewById<EditText>(R.id.flightNumberInput)
        val departureInput = findViewById<EditText>(R.id.departureInput)
        val destinationInput = findViewById<EditText>(R.id.destinationInput)
        val dateInput = findViewById<EditText>(R.id.dateInput)
        val addButton = findViewById<Button>(R.id.addButton)

        addButton.setOnClickListener {
            val name = userNameInput.text.toString()
            val age = userAgeInput.text.toString().toInt()
           // val passengerName = passengerNameInput.text.toString()
            val flightNumber = flightNumberInput.text.toString()
            val departure = departureInput.text.toString()
            val destination = destinationInput.text.toString()
            val date = dateInput.text.toString()

            val newFlight = Flight(name = name, age = age,  flightNumber = flightNumber, departure = departure, destination = destination, date = date)
            userViewModel.insertUser(newFlight)

            finish()
        }
    }
}