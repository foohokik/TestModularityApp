package com.example.testmodularityapp.di

import android.content.Context
import com.example.testmodularityapp.App
import com.example.testmodularityapp.MainActivity
import dagger.BindsInstance
import dagger.internal.Preconditions
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class])
@Singleton
interface AppComponent {
    fun inject(app: App)
    fun inject(activity: MainActivity)


    companion object {
        @Volatile
        private var instance: AppComponent? = null

        fun get(): AppComponent {
            return Preconditions.checkNotNull(instance,
                "AppComponent is not initialized yet. Call init first.")!!
        }

        fun init(component: AppComponent) {
            require(instance == null) { "AppComponent is already initialized." }
            instance = component
        }
    }
}