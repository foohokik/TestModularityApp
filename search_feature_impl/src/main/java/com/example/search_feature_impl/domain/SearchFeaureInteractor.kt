package com.example.search_feature_impl.domain


import com.example.search_feature_impl.domain.repo.LocalSearchRepo
import com.example.search_feature_impl.domain.repo.RemoteSearchRepo
import com.example.search_feature_impl.presentation.model.OffersUI
import com.example.search_feature_impl.presentation.model.toOffersListUI
import com.example.search_feature_impl.presentation.model.toVacanciesListUI
import javax.inject.Inject

class SearchFeaureInteractor @Inject constructor(
    private val localSearchRepo: LocalSearchRepo,
    private val remoteSearchRepo: RemoteSearchRepo
)  {

    suspend fun getOffers(): List<OffersUI> {
        val offers = remoteSearchRepo.getOffers()
        val vacanciesUI = offers.vacancies.toVacanciesListUI()
        val offersUI = offers.offers.toOffersListUI()
        return vacanciesUI + listOf(OffersUI.CommonList(offersUI)) + listOf(OffersUI.Header())
    }


}