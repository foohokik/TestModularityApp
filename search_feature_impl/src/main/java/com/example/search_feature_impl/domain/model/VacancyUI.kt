package com.example.search_feature_impl.domain.model

import java.io.Serializable

data class VacancyUI(
    val address: AddressUI,
    val appliedNumber: Int,
    val company: String,
    val description: String,
    val experience: ExperienceUI,
    val id: String,
    val isFavorite: Boolean,
    val lookingNumber: Int,
    val publishedDate: String,
    val questions: List<String>,
    val responsibilities: String,
    val salary: SalaryUI,
    val schedules: List<String>,
    val title: String
): Serializable, RecycleViewOffersItem