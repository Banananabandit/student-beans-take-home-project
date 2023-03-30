package com.example.sbtechincaltest.offers

import android.app.Application
import android.content.Context

class OffersApplication: Application() {
    init { app = this }
    companion object {
        private lateinit var app: OffersApplication
        fun getAppContext(): Context = app.applicationContext
    }
}