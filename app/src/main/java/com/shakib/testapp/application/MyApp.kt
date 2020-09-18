package com.shakib.testapp.application

import android.app.Application
import android.content.res.Resources

class MyApp : Application() {

    companion object {
        lateinit var myResources: Resources
    }

    override fun onCreate() {
        super.onCreate()
        myResources = resources
    }

}