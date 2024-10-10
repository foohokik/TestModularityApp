package com.example.search_feature_impl.domain.model

import java.io.Serializable

data class Offers(
    val offers: List<Offer>? = emptyList(),
    val vacancies: List<Vacancy>? = emptyList()
)