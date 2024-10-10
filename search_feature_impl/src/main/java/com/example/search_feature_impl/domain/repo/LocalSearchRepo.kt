package com.example.search_feature_impl.domain.repo

import com.example.core_database.impl.data.VacancyEntity
import com.example.search_feature_impl.domain.model.Offer
import com.example.search_feature_impl.domain.model.Vacancy

interface LocalSearchRepo {

    suspend fun getAllVacancies(): List<Vacancy>

    suspend fun saveVacancy (item: Vacancy)
    
    suspend fun saveVacancies (items: List<Vacancy>?)

    suspend fun getVacancyById (id: String) : Vacancy

    suspend fun deleteVacancyById (id: String)

    suspend fun updateVacancyIsFavorite (isFavorite: Boolean, id: String)

    suspend fun getAllOffers(): List<Offer>

    suspend fun saveOffers (items: List<Offer>?)

}