package com.example.xr.mykotlinmvp.rx.scheduler

object SchedulerUtils {
    fun <T> ioToMain(): IoMainScheduler<T> = IoMainScheduler()
}