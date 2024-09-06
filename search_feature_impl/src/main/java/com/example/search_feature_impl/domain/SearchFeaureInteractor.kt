package com.example.search_feature_impl.domain

import com.example.search_feature_impl.di.IoDispatcher
import com.example.search_feature_impl.domain.model.OffersUI
import com.example.search_feature_impl.domain.repo.LocalSearchRepo
import com.example.search_feature_impl.domain.repo.RemoteSearchRepo
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class SearchFeaureInteractor @Inject constructor(
    private val localSearchRepo: LocalSearchRepo,
    private val remoteSearchRepo: RemoteSearchRepo
)  {

    suspend fun getOffers(): OffersUI = remoteSearchRepo.getOffers()


}