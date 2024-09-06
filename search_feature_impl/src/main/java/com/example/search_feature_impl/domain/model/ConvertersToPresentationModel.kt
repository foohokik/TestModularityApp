package com.example.search_feature_impl.domain.model

import com.example.core.data.Address
import com.example.core.data.Button
import com.example.core.data.Experience
import com.example.core.data.Offer
import com.example.core.data.OffersResponse
import com.example.core.data.Salary
import com.example.core.data.Vacancy
import com.example.core_database.impl.data.VacancyEntity
import com.example.search_feature_impl.R

fun Button.toButtonUI (): ButtonUI = ButtonUI (text)

fun Offer.toOfferUI (): OfferUI = OfferUI (button.toButtonUI(), id,link, icon = chooseIcon(id), title=title)


fun chooseIcon(id: String): Int {
    return when (id) {
        "near_vacancies" -> com.example.core_utils.R.drawable.ic_person_blue
        "level_up_resume" -> com.example.core_utils.R.drawable.ic_star
        "temporary_job" -> com.example.core_utils.R.drawable.ic_list
        else -> 0
    }
}

fun List<Offer>.toOffersListUI (): List<OfferUI> = this.map { it.toOfferUI() }

fun Address.toAddressUI(): AddressUI = AddressUI(house,street, town)

fun AddressUI.toAddress(): Address = Address(house,street, town)


fun Experience.toExperienceUI(): ExperienceUI = ExperienceUI(previewText, text)


fun ExperienceUI.toExperience(): Experience = Experience(previewText, text)

fun Salary.toSalaryUI (): SalaryUI = SalaryUI(full, short)

fun SalaryUI.toSalary (): Salary = Salary(full, short)


fun Vacancy.toVacancyUI(): VacancyUI {
    return VacancyUI(
        address.toAddressUI(),
        appliedNumber,
        company,
        description,
        experience.toExperienceUI(),
        id,
        isFavorite,
        lookingNumber,
        publishedDate,
        questions,
        responsibilities,
        salary.toSalaryUI(),
        schedules,
        title)
}

fun List<Vacancy>.toVacanciesListUI():List<VacancyUI> = this.map {it.toVacancyUI()}


fun OffersResponse.toOffersUI(): OffersUI = OffersUI(offers.toOffersListUI(), vacancies.toVacanciesListUI())


fun VacancyEntity.toVacancyUI(): VacancyUI {
  return VacancyUI(
        address.toAddressUI(),
        appliedNumber,
        company,
        description,
        experience.toExperienceUI(),
        id,
        isFavorite,
        lookingNumber,
        publishedDate,
        questions,
        responsibilities,
        salary.toSalaryUI(),
        schedules,
        title)
}

fun List<VacancyEntity>.toVacanciesUI():List<VacancyUI> = this.map {it.toVacancyUI()}

fun VacancyUI.toVacancyEntity(): VacancyEntity {
    return VacancyEntity(
        address.toAddress(),
        appliedNumber,
        company,
        description,
        experience.toExperience(),
        id,
        isFavorite,
        lookingNumber,
        publishedDate,
        questions,
        responsibilities,
        salary.toSalary(),
        schedules,
        title)
}