package com.example.fly.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.fly.data.local.entities.Flight

//@Dao
//interface UserDao {
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertUser(user: User)
//
//    @Query("SELECT * FROM users")
//    suspend fun getAllUsers(): List<User>
//
////    // resolve this issue
////    @Query("SELECT * FROM users WHERE ......")
////    suspend fun getUserByName(name: String): List<User>
//@Update
//suspend fun updateUser(user: User) // Method to update user
//
//
//    // Add a method to delete a user by name
//    @Query("DELETE FROM users WHERE name = :name")
//    suspend fun deleteUserByName(name: String)
//
//
//}

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(flight: Flight)

    @Query("SELECT * FROM flies")
    suspend fun getAllUsers(): List<Flight>

    @Update
    suspend fun updateUser(flight: Flight)

    @Query("DELETE FROM flies WHERE name = :name")
    suspend fun deleteUserByName(name: String)

    @Query("DELETE FROM flies")
    suspend fun deleteAllUsers()

    @Query("SELECT * FROM flies WHERE flightNumber = :flightNumber AND date = :date")
    suspend fun getUsersByFlightNumberAndDate(flightNumber: String, date: String): List<Flight>


}