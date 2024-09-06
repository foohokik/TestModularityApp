package com.example.search_feature_impl.domain.repo

import com.example.search_feature_impl.domain.model.OffersUI

interface RemoteSearchRepo {

    suspend fun getOffers(): OffersUI
}