package com.example.core.data

import java.io.Serializable

data class Vacancy(
    val address: Address,
    val appliedNumber: Int = 0,
    val company: String?,
    val description: String?,
    val experience: Experience,
    val id: String?,
    val isFavorite: Boolean = false,
    val lookingNumber: Int = 0,
    val publishedDate: String?,
    val questions: List<String>?,
    val responsibilities: String?,
    val salary: Salary,
    val schedules: List<String> = emptyList(),
    val title: String?
) : Serializable