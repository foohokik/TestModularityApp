package com.example.search_feature_impl.presentation.model

import androidx.annotation.DrawableRes
import java.io.Serializable

sealed class OffersUI  {

    data class VacancyUI(
        val address: AddressUI?,
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
    ): Serializable, OffersUI()

    data class OfferUI(
        val button: String = "",
        val id: String,
        val link: String,
        val title: String,
        @DrawableRes val icon: Int
    ): Serializable, OffersUI()

    data class Header(
        val header: String = "Вакансии для Вас"
    ): Serializable, OffersUI()

    data class CommonList (
        val offers: List<OffersUI.OfferUI>,
       // val vacancies: List<OffersUI.VacancyUI>
    ) : OffersUI()


}