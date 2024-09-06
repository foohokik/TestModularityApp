package com.example.core_database.domain

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.core_database.impl.data.VacancyEntity

@Dao
interface VacancyDao {

    @Query("SELECT * FROM vacancies")
    suspend fun getAllVacancies(): List<VacancyEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecord(vacancyEntity: VacancyEntity)

    @Query("SELECT * FROM vacancies WHERE vacancies.id = :id")
    suspend fun getVacanсyById (id: String): VacancyEntity

}