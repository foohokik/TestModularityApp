package com.example.search_feature_impl.domain.repo

import com.example.search_feature_impl.domain.model.Offers

interface RemoteSearchRepo {

    suspend fun getOffers(): Offers
}