package com.example.core_database.impl.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.core.data.Address
import com.example.core.data.Experience
import com.example.core.data.Salary
import java.io.Serializable

@Entity(
    tableName = "vacancies"
)
data class VacancyEntity (
    val address: Address,
    val appliedNumber: Int,
    val company: String,
    val description: String,
    val experience: Experience,
    @PrimaryKey(autoGenerate = false) val id: String,
    val isFavorite: Boolean,
    val lookingNumber: Int,
    val publishedDate: String,
    val questions: List<String>,
    val responsibilities: String,
    val salary: Salary,
    val schedules: List<String>,
    val title: String): Serializable


