package com.example.search_feature_impl.di

import com.example.core_network.impl.response.HttpResultToDataWrapperConverter
import com.example.core_utils.di.Feature
import com.example.search_feature_api.SearchLauncher
import com.example.search_feature_impl.data.LocalSearchRepoImpl
import com.example.search_feature_impl.data.RemoteSearchRepoImpl
import com.example.search_feature_impl.domain.repo.LocalSearchRepo
import com.example.search_feature_impl.domain.repo.RemoteSearchRepo
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module

interface SearchFeatureModule {

//    @Feature
//    @Binds
//    fun bindSearchLauncher(searchLauncher: SearchLauncherImpl): SearchLauncher

    @Feature
    @Binds
    fun bindRemoteRepository(repo: RemoteSearchRepoImpl): RemoteSearchRepo

    @Feature
    @Binds
    fun bindLocalRepository(repo: LocalSearchRepoImpl): LocalSearchRepo



}