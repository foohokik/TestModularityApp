package com.example.search_feature_impl.domain.repo

import com.example.search_feature_impl.domain.model.Vacancy

interface LocalSearchRepo {

    suspend fun getAllVacancies(): List<Vacancy>

    suspend fun saveVacancy (item: Vacancy)

    suspend fun getVacancyById (id: String) : Vacancy

}