package com.example.search_feature_impl.data

import com.example.core_database.domain.VacancyDao
import com.example.search_feature_impl.domain.model.Vacancy
import com.example.search_feature_impl.domain.model.toVacanciesUI
import com.example.search_feature_impl.domain.model.toVacancyEntity
import com.example.search_feature_impl.domain.model.toVacancyUI
import com.example.search_feature_impl.domain.repo.LocalSearchRepo
import javax.inject.Inject

class LocalSearchRepoImpl @Inject constructor(private val dao: VacancyDao) : LocalSearchRepo

{
    override suspend fun getAllVacancies(): List<Vacancy> = dao.getAllVacancies().toVacanciesUI()

    override suspend fun saveVacancy(item: Vacancy) = dao.insertRecord(item.toVacancyEntity())

    override suspend fun getVacancyById(id: String): Vacancy = dao.getVacanсyById(id).toVacancyUI()

}