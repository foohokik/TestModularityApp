package com.example.core.data

data class OffersResponse(
    val offers: List<Offer> = emptyList(),
    val vacancies: List<Vacancy> = emptyList()
)