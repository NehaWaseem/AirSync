package com.example.fly.data.repository

import com.example.fly.data.local.dao.UserDao
import com.example.fly.data.local.entities.Flight


class UserRepository(private val userDao: UserDao) {

    suspend fun insertUser(flight: Flight) {
        userDao.insertUser(flight)
    }

    suspend fun getAllUsers(): List<Flight> {
        return userDao.getAllUsers()
    }

    suspend fun updateUser(flight: Flight) {
        userDao.updateUser(flight) // Ensure this method is implemented in UserDao
    }

    suspend fun deleteUserByName(name: String) {
        userDao.deleteUserByName(name)
    }

    suspend fun getUsersByFlightNumberAndDate(flightNumber: String, date: String): List<Flight> {
        return userDao.getUsersByFlightNumberAndDate(flightNumber, date)
    }

}

//class UserRepository(private val userDao: UserDao) {
//
//    suspend fun insertUser(user: User) {
//        userDao.insertUser(user)
//    }
//
//    suspend fun getAllUsers(): List<User> {
//        return userDao.getAllUsers()
//    }
//
//    suspend fun updateUser(user: User) {
//        userDao.updateUser(user)
//    }
//
//    suspend fun deleteUserByName(name: String) {
//        userDao.deleteUserByName(name)
//    }
//
//}