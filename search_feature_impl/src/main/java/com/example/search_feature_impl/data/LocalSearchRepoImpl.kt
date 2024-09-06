package com.example.search_feature_impl.data

import com.example.core_database.domain.VacancyDao
import com.example.search_feature_impl.domain.model.VacancyUI
import com.example.search_feature_impl.domain.model.toVacanciesUI
import com.example.search_feature_impl.domain.model.toVacancyEntity
import com.example.search_feature_impl.domain.model.toVacancyUI
import com.example.search_feature_impl.domain.repo.LocalSearchRepo
import javax.inject.Inject

class LocalSearchRepoImpl @Inject constructor(private val dao: VacancyDao) : LocalSearchRepo

{
    override suspend fun getAllVacancies(): List<VacancyUI> = dao.getAllVacancies().toVacanciesUI()

    override suspend fun saveVacancy(item: VacancyUI) = dao.insertRecord(item.toVacancyEntity())

    override suspend fun getVacancyById(id: String): VacancyUI = dao.getVacanсyById(id).toVacancyUI()

}