package com.example.sbtechincaltest

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class OffersApplication: Application() {
    init { app = this }
    companion object {
        private lateinit var app: OffersApplication
        fun getAppContext(): Context = app.applicationContext
    }
}