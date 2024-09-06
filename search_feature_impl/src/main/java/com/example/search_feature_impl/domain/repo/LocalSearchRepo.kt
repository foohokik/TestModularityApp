package com.example.search_feature_impl.domain.repo

import com.example.search_feature_impl.domain.model.VacancyUI

interface LocalSearchRepo {

    suspend fun getAllVacancies(): List<VacancyUI>

    suspend fun saveVacancy (item: VacancyUI)

    suspend fun getVacancyById (id: String) : VacancyUI

}