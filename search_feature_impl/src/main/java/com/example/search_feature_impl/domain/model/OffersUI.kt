package com.example.search_feature_impl.domain.model

import java.io.Serializable

data class OffersUI(
    val offers: OffersList = OffersList(offers = emptyList()),
    val title: Header = Header(),
    val vacancies: List<VacancyUI> = emptyList()
) : Serializable, RecycleViewOffersItem