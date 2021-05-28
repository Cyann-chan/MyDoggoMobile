package com.example.mydoggomobile.presentation.list

import android.app.Application
import android.content.Context

class DoggoApplication : Application() {

    companion object{
        var context : Context? = null
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }
}