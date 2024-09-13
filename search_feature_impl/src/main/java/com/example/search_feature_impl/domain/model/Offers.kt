package com.example.search_feature_impl.domain.model

import java.io.Serializable

data class Offers(
    val offers: List<Offer>,
    val vacancies: List<Vacancy>
) : Serializable