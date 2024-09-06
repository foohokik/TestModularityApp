package com.example.search_feature_impl.domain.model

import java.io.Serializable

data class OffersUI(
    val offers: List<OfferUI> = emptyList(),
    val vacancies: List<VacancyUI> = emptyList()
) : Serializable