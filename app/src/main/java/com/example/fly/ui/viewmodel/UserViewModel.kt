package com.example.fly.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fly.data.local.entities.Flight
import com.example.fly.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

//@HiltViewModel
//class UserViewModel @Inject constructor(
//    private val userRepository: UserRepository
//) : ViewModel() {
//
//    private val _users = MutableLiveData<List<User>>()
//    val users: LiveData<List<User>> get() = _users
//
//    fun insertUser(user: User) {
//        viewModelScope.launch {
//            userRepository.insertUser(user)
//            fetchAllUsers() // Refresh data after inserting
//        }
//    }
//
//    init {
//        checkAndInsertDummyData() // Check and insert dummy data when ViewModel is created
//    }
//
//    // Method to check if the database is empty and insert dummy data if it is
//    private fun checkAndInsertDummyData() {
//        viewModelScope.launch {
//            // Fetch all users from the database
//            val currentUsers = userRepository.getAllUsers()
//            if (currentUsers.isEmpty()) {
//                // If no users are found, insert dummy data
//                insertUser(User(name = "Sohail Rizvi", age = 30))
//                insertUser(User(name="Clary Fairchild",age=16))
//                insertUser(User(name="Jocelyn Fairchild",age=14))
//                insertUser(User(name="Sarah Ahmad",age=56))
//                insertUser(User(name="Maheen Azeem",age=45))
//                insertUser(User(name="Ben Arnold",age=46))
//                insertUser(User(name="Jake Richard",age=32))
//
//
//            }
//        }
//    }
//
//    fun fetchAllUsers() {
//        viewModelScope.launch {
//            _users.value = userRepository.getAllUsers()
//        }
//    }
//
//    fun updateUser(user: User) {
//        viewModelScope.launch {
//            userRepository.updateUser(user) // Ensure this method is implemented in UserRepository
//            fetchAllUsers() // Refresh the data
//        }
//    }
//
//    fun getUserById(userId: Int): LiveData<User?> {
//        val result = MutableLiveData<User?>()
//        viewModelScope.launch {
//            val user = userRepository.getAllUsers().find { it.id == userId }
//            result.value = user
//        }
//        return result
//    }
//
//
//    fun deleteUserByName(name: String) {
//        viewModelScope.launch {
//            userRepository.deleteUserByName(name)
//            fetchAllUsers() // Refresh the data after deletion
//        }
//    }
//}

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    private val _users = MutableLiveData<List<Flight>>()
    val users: LiveData<List<Flight>> get() = _users

    fun insertUser(flight: Flight) {
        viewModelScope.launch {
            userRepository.insertUser(flight)
            fetchAllUsers() // Refresh data after inserting
        }
    }

    init {
        checkAndInsertDummyData() // Check and insert dummy data when ViewModel is created
    }

    private fun checkAndInsertDummyData() {
        viewModelScope.launch {
            val currentUsers = userRepository.getAllUsers()
            if (currentUsers.isEmpty()) {
                insertUser(Flight(name = "Sohail Rizvi", age = 30, flightNumber = "AI202", departure = "NYC", destination = "LAX", date = "2024-08-09"))
                insertUser(Flight(name = "Inshrah Imran", age = 20, flightNumber = "AI202", departure = "Pakistan", destination = "LAX", date = "2024-08-10"))
                insertUser(Flight(name = "Clary Fray", age = 16, flightNumber = "AI203", departure = "London", destination = "LAX", date = "2024-08-09"))
                insertUser(Flight(name = "Simon Brooke", age = 45, flightNumber = "AI201", departure = "Maldives", destination = "LAX", date = "2024-08-11"))
                insertUser(Flight(name = "Haris Nadeem", age = 27,  flightNumber = "AI203", departure = "Turkey", destination = "LAX", date = "2024-08-10"))
                insertUser(Flight(name = "Jace Campbell", age = 19,  flightNumber = "AI202", departure = "Canada", destination = "LAX", date = "2024-08-09"))
                insertUser(Flight(name = "Seema Jamshed", age = 23,  flightNumber = "AI201", departure = "Thailand", destination = "LAX", date = "2024-08-11"))

            }
        }
    }

    fun fetchAllUsers() {
        viewModelScope.launch {
            _users.value = userRepository.getAllUsers()
        }
    }

    fun updateUser(flight: Flight) {
        viewModelScope.launch {
            userRepository.updateUser(flight)
            fetchAllUsers() // Refresh the data
        }
    }

    fun getUserById(userId: Int): LiveData<Flight?> {
        val result = MutableLiveData<Flight?>()
        viewModelScope.launch {
            val user = userRepository.getAllUsers().find { it.id == userId }
            result.value = user
        }
        return result
    }
    fun fetchUsersByFlightNumberAndDate(flightNumber: String, date: String) {
        viewModelScope.launch {
            _users.value = userRepository.getUsersByFlightNumberAndDate(flightNumber, date)
        }
    }

    fun deleteUserByName(name: String) {
        viewModelScope.launch {
            userRepository.deleteUserByName(name)
            fetchAllUsers() // Refresh the data after deletion
        }
    }

}