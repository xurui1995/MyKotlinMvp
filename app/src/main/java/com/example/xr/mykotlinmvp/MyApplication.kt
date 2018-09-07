package com.example.xr.mykotlinmvp

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import android.util.Log
import kotlin.properties.Delegates

class MyApplication: Application() {

    companion object {

        private val TAG = "MyApplication"

        var context: Context by Delegates.notNull()
    }


    override fun onCreate() {
        super.onCreate()
        context = applicationContext

        registerActivityLifecycleCallbacks(object: Application.ActivityLifecycleCallbacks{
            override fun onActivityPaused(activity: Activity) {

            }

            override fun onActivityResumed(activity: Activity) {

            }

            override fun onActivityStarted(activity: Activity) {

            }

            override fun onActivityDestroyed(activity: Activity) {
                Log.d(TAG, "onDestroy: " + activity.componentName.className)
            }

            override fun onActivitySaveInstanceState(activity: Activity, p1: Bundle?) {

            }

            override fun onActivityStopped(activity: Activity) {

            }

            override fun onActivityCreated(activity: Activity, p1: Bundle?) {
                Log.d(TAG, "onCreated: " + activity.componentName.className)
            }

        })
    }
}