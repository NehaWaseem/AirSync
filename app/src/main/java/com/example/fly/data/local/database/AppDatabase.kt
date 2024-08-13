package com.example.fly.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.fly.data.local.dao.UserDao
import com.example.fly.data.local.entities.Flight


@Database(entities = [Flight::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase()
{
    abstract fun userDao(): UserDao

    // ON UPDATE,,,, WHAT TO DO WHEN SCHEMA IS CHANGE

}