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
//class UserUpdateActivity : AppCompatActivity() {
//
//    private val userViewModel: UserViewModel by viewModels()
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_user_update)
//
//        val userNameInput = findViewById<EditText>(R.id.userNameInput)
//        val userAgeInput = findViewById<EditText>(R.id.userAgeInput)
//        val updateButton = findViewById<Button>(R.id.updateButton)
//
//        // Retrieve userId from Intent
//        val userId = intent.getIntExtra("userId", -1)
//
//        // Fetch user details and populate fields
//        userViewModel.getUserById(userId).observe(this) { user ->
//            user?.let {
//                userNameInput.setText(it.name)
//                userAgeInput.setText(it.age.toString())
//            }
//        }
//
//        updateButton.setOnClickListener {
//            val updatedName = userNameInput.text.toString()
//            val updatedAge = userAgeInput.text.toString().toInt()
//            userViewModel.updateUser(User(id = userId, name = updatedName, age = updatedAge))
//
//            // Finish activity and return to previous screen
//            finish()
//        }
//    }
//}

@AndroidEntryPoint
class UserUpdateActivity : AppCompatActivity() {

    private val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_update)

        val userNameInput = findViewById<EditText>(R.id.userNameInput)
        val userAgeInput = findViewById<EditText>(R.id.userAgeInput)
        //val passengerNameInput = findViewById<EditText>(R.id.passengerNameInput)
        val flightNumberInput = findViewById<EditText>(R.id.flightNumberInput)
        val departureInput = findViewById<EditText>(R.id.departureInput)
        val destinationInput = findViewById<EditText>(R.id.destinationInput)
        val dateInput = findViewById<EditText>(R.id.dateInput)
        val updateButton = findViewById<Button>(R.id.updateButton)

        val userId = intent.getIntExtra("userId", -1)

        userViewModel.getUserById(userId).observe(this) { user ->
            user?.let {
                userNameInput.setText(it.name)
                userAgeInput.setText(it.age.toString())
                //passengerNameInput.setText(it.passengerName)
                flightNumberInput.setText(it.flightNumber)
                departureInput.setText(it.departure)
                destinationInput.setText(it.destination)
                dateInput.setText(it.date)
            }
        }

        updateButton.setOnClickListener {
            val updatedName = userNameInput.text.toString()
            val updatedAge = userAgeInput.text.toString().toInt()
            //val updatedPassengerName = passengerNameInput.text.toString()
            val updatedFlightNumber = flightNumberInput.text.toString()
            val updatedDeparture = departureInput.text.toString()
            val updatedDestination = destinationInput.text.toString()
            val updatedDate = dateInput.text.toString()

            userViewModel.updateUser(Flight(id = userId, name = updatedName, age = updatedAge, flightNumber = updatedFlightNumber, departure = updatedDeparture, destination = updatedDestination, date = updatedDate))

            finish()
        }
    }
}