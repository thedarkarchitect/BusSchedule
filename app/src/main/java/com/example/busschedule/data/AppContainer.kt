package com.example.busschedule.data

import android.content.Context

interface AppContainer {
    val busScheduleRepository: BusScheduleRepository
}

class ApplicationContainer(private val context: Context) : AppContainer {
    override val busScheduleRepository: BusScheduleRepository by lazy {
        ScheduleRepository(BusScheduleDatabase.getDatabase(context).scheduleDao())
    }
}