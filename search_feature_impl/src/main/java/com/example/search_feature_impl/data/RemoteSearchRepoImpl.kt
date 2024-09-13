package com.example.search_feature_impl.data

import com.example.core_network.impl.JobApi
import com.example.search_feature_impl.domain.model.Offers
import com.example.search_feature_impl.domain.model.toOffers
import com.example.search_feature_impl.domain.repo.RemoteSearchRepo
import javax.inject.Inject

class RemoteSearchRepoImpl @Inject constructor(private val api: JobApi):RemoteSearchRepo {

    override suspend fun getOffers(): Offers {
        val result = api.getOffers().toOffers()
        return result
    }


}