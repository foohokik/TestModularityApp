package com.example.core_network.impl.di

import android.util.Log
import com.example.core_network.api.AppNetworkApi
import com.example.module_injector.ComponentHolder

object AppNetworkComponentHolder : ComponentHolder<AppNetworkApi, AppNetworkDependencies> {

    private var appNetworkComponent : AppNetworkComponent? = null
    override fun init(dependencies: AppNetworkDependencies) {
        if (appNetworkComponent == null) {
            Log.i("myTag","apNetworkComponent "+ appNetworkComponent)
            synchronized(this) {
                if (appNetworkComponent == null) {
                    Log.i("myTag","apNetworkComponent 2 "+ appNetworkComponent)
                    appNetworkComponent = AppNetworkComponent.get()
                }
            }
        }
    }

    override fun get(): AppNetworkApi = getComponent()

    internal fun getComponent(): AppNetworkComponent {
        Log.i("myTag","getapNetworkComponent "+ appNetworkComponent)
        checkNotNull(appNetworkComponent) { "AppNetworkComponent was not initialized!" }
        return appNetworkComponent!!
    }

    override fun reset() {
        appNetworkComponent = null
    }
}