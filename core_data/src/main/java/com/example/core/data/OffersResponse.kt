package com.example.core.data

data class OffersResponse(
    val offers: List<OfferResponse> = emptyList(),
    val vacancies: List<VacancyResponse> = emptyList()
)