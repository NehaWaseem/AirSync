package com.example.fly.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

//@Entity(tableName = "users")
//data class User(
//    @PrimaryKey(autoGenerate = true) val id: Int = 0,
//    val name: String,
//    val age: Int
//)

@Entity(tableName = "flies")
data class Flight(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val age: Int,
    val flightNumber: String,
    val departure: String,
    val destination: String,
    val date: String
)