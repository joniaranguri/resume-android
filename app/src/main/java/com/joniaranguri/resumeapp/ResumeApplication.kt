package com.joniaranguri.resumeapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ResumeApplication : Application() {
    companion object {
        lateinit var instance: ResumeApplication
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}