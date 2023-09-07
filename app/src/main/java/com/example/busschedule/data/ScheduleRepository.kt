package com.example.busschedule.data

import kotlinx.coroutines.flow.Flow

class ScheduleRepository(private val scheduleDao: ScheduleDao) : BusScheduleRepository{
    override fun getAllBusSchedules(): Flow<List<BusSchedule>> = scheduleDao.getAllSchedules()

    override fun getBusSchedule(stopName: String): Flow<BusSchedule?> = scheduleDao.getSchedule(stopName)

    override suspend fun insertSchedule(busSchedule: BusSchedule) = scheduleDao.insert(busSchedule)

    override suspend fun updateSchedule(busSchedule: BusSchedule) = scheduleDao.update(busSchedule)

    override suspend fun deleteSchedule(busSchedule: BusSchedule) = scheduleDao.delete(busSchedule)
}