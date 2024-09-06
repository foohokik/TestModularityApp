package com.example.testmodularityapp.di

import android.content.Context
import android.util.Log
import com.example.core_database.api.AppDatabaseApi
import com.example.core_database.domain.VacancyDao
import com.example.core_database.impl.di.AppDatabaseComponentHolder
import com.example.core_database.impl.di.AppDatabaseDependencies
import com.example.core_network.api.AppNetworkApi
import com.example.core_network.impl.JobApi
import com.example.core_network.impl.di.AppNetworkComponent
import com.example.core_network.impl.di.AppNetworkComponentHolder
import com.example.core_network.impl.di.AppNetworkDependencies
import com.example.search_feature_api.SearchFeatureApi
import com.example.search_feature_impl.di.SearchFeatureComponentHolder
import com.example.search_feature_impl.di.SearchFeatureDependencies
import com.example.testmodularityapp.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

	@Singleton
	@Provides
	fun provideContext(): Context {
		return App.appContext
	}

	@Singleton
	@Provides
	fun provideAppDatabaseDependencies(context: Context): AppDatabaseDependencies {
		return object : AppDatabaseDependencies {
			override fun getContext(): Context {
				return context
			}
		}
	}

//	@Singleton
//	@Provides
//	fun provideAppDatabase(dependencies: AppDatabaseDependencies): AppDatabaseApi {
//		Log.i("myTag","kuk")
//		AppDatabaseComponentHolder.init(dependencies)
//		return AppDatabaseComponentHolder.get()
//	}
//
	@Singleton
	@Provides
	fun provideAppNetwork (dependencies: AppNetworkDependencies) : AppNetworkApi {
		AppNetworkComponentHolder.init(dependencies)
		Log.i("myTag","provideAppNetwork ")
		return AppNetworkComponentHolder.get()
	}

	@Singleton
	@Provides
	fun provideFeatureSearchDependencies(): SearchFeatureDependencies {
		Log.i("myTag", "provideFeatureSearchDependencies ")
		return object : SearchFeatureDependencies {
			override fun getVacanciesDao(): VacancyDao = AppDatabaseComponentHolder.get().getVacancyDao()
			override fun getJobApi(): JobApi = AppNetworkComponentHolder.get().getJobApi()
		}
	}

	@Provides
	fun provideFeatureSearch(dependencies: SearchFeatureDependencies): SearchFeatureApi {
		SearchFeatureComponentHolder.init(dependencies)
		return SearchFeatureComponentHolder.get()
	}

}