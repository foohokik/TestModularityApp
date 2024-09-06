package com.example.search_feature_impl.data

import android.util.Log
import com.example.core_network.impl.JobApi
import com.example.search_feature_impl.domain.model.OffersUI
import com.example.search_feature_impl.domain.model.toOffersUI
import com.example.search_feature_impl.domain.repo.RemoteSearchRepo
import javax.inject.Inject

class RemoteSearchRepoImpl @Inject constructor(private val api: JobApi):RemoteSearchRepo {

    override suspend fun getOffers(): OffersUI {
        val result = api.getOffers().toOffersUI()
        Log.d("MYTAG", "result   =   "+ result)
        return result
    }


}