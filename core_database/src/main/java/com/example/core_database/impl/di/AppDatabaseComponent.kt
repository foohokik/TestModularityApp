package com.example.core_database.impl.di

import android.content.Context
import com.example.core_database.api.AppDatabaseApi
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(
	modules = [DatabaseModule::class],
	dependencies = [AppDatabaseDependencies::class]
)
@Singleton
interface AppDatabaseComponent : AppDatabaseApi {

	companion object {
		fun initAndGet(appDatabaseDependencies: AppDatabaseDependencies): AppDatabaseComponent {
			return DaggerAppDatabaseComponent.builder()
				.appDatabaseDependencies(appDatabaseDependencies)
				.build()
		}
	}

}