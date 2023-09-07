package com.example.busschedule.data

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class BusScheduleDatabase : RoomDatabase(){
    abstract fun scheduleDao() : ScheduleDao

    companion object {
        @Volatile
        private var Instance : BusScheduleDatabase? = null

        fun getDatabase(context: Context): BusScheduleDatabase{
            return Instance ?: synchronized(this){
                Room.databaseBuilder(context, BusScheduleDatabase::class.java, "bus_schedule")
                    .createFromAsset("database/bus_schedule.db")//this will prepopulate the database with data from the database assert
                    .build()
                    .also { Instance = it }
            }
        }
    }
}