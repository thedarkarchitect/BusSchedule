package com.example.busschedule.data

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import androidx.room.OnConflictStrategy
import androidx.room.Update

interface ScheduleDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(schedule: BusSchedule)

    @Update
    suspend fun update(schedule: BusSchedule)

    @Delete
    suspend fun delete(schedule: BusSchedule)


    @Query("SELECT * from schedule WHERE stop_name = :stopName")
    fun getSchedule(stopName: String): Flow<BusSchedule>//will use the stopNAme to retrieve a single item from the db

    @Query("SELECT * from schedule ORDER BY arrival_time ASC")
    fun getAllSchedules(): Flow<List<BusSchedule>>
}