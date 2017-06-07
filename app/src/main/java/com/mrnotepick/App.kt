package com.mrnotepick

import android.app.Application
import android.content.Context


class App : Application() {

    //// APPLICATION

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

    ////

    companion object {

        lateinit var context: Context
    }
}