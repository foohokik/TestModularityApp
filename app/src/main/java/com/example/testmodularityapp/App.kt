package com.example.testmodularityapp

import android.app.Application
import android.content.Context
import android.util.Log
import com.example.core_database.impl.di.AppDatabaseComponentHolder
import com.example.core_database.impl.di.AppDatabaseDependencies
import com.example.testmodularityapp.di.AppComponent
import com.example.testmodularityapp.di.DaggerAppComponent

class App: Application() {


    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
        AppComponent.init(
            DaggerAppComponent.builder()
                .build()
        )

//        AppDatabaseComponentHolder.init(object : AppDatabaseDependencies {
//            override fun getContext(): Context {
//                return applicationContext
//            }
//        })

        AppComponent.get().inject(this)

    }

    companion object {
        @Volatile
        lateinit var appContext: Context
            private set
    }
}