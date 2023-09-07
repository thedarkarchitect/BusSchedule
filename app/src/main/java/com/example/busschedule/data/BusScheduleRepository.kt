package com.example.busschedule.data

import kotlinx.coroutines.flow.Flow

interface BusScheduleRepository{
    fun getAllBusSchedules(): Flow<List<BusSchedule>>

    fun getBusSchedule(stopName: String): Flow<BusSchedule?>

    suspend fun insertSchedule(busSchedule: BusSchedule)

    suspend fun updateSchedule(busSchedule: BusSchedule)

    suspend fun deleteSchedule(busSchedule: BusSchedule)
}

