package com.example.search_feature_impl.domain.model
import com.example.core.data.AddressResponse
import com.example.core.data.ExperienceResponse
import com.example.core.data.OfferResponse
import com.example.core.data.OffersResponse
import com.example.core.data.SalaryResponse
import com.example.core.data.VacancyResponse
import com.example.core_database.impl.data.VacancyEntity

//fun ButtonResponse.toButtonUI (): ButtonUI = ButtonUI (text.orEmpty())

fun OfferResponse.toOffer (): Offer = Offer (
    button = button?.text.toString(),
    id.orEmpty(),
    link.orEmpty(),
//    icon = chooseIcon(id),
    title=title.orEmpty())


//fun chooseIcon(id: String?): Int {
//    return when (id) {
//        "near_vacancies" -> com.example.core_utils.R.drawable.ic_person_blue
//        "level_up_resume" -> com.example.core_utils.R.drawable.ic_star
//        "temporary_job" -> com.example.core_utils.R.drawable.ic_list
//        else -> 0
//    }
//}

fun List<OfferResponse>.toOffersList (): List<Offer> = this.map { it.toOffer() }

fun AddressResponse.toAddress(): Address = Address(house,street, town)

fun Address.toAddress(): AddressResponse = AddressResponse(house,street, town)

fun ExperienceResponse.toExperience(): Experience = Experience(previewText.orEmpty(), text.orEmpty())


fun Experience.toExperience(): ExperienceResponse = ExperienceResponse(previewText, text)

fun SalaryResponse.toSalary (): Salary = Salary(full.orEmpty(), short.orEmpty())

fun Salary.toSalary (): SalaryResponse = SalaryResponse(full, short)


fun VacancyResponse.toVacancy(): Vacancy {
    return Vacancy(
        addressResponse?.toAddress(),
        appliedNumber,
        company.orEmpty(),
        description.orEmpty(),
        experience.toExperience(),
        id.orEmpty(),
        isFavorite,
        lookingNumber,
        publishedDate.orEmpty(),
        questions.orEmpty(),
        responsibilities.orEmpty(),
        salary.toSalary(),
        schedules.orEmpty(),
        title.orEmpty())
}

fun List<VacancyResponse>.toVacanciesListUI():List<Vacancy> = this.map {it.toVacancy()}


fun OffersResponse.toOffers(): Offers = Offers(
    offers.toOffersList(),
    vacancies.toVacanciesListUI())


fun VacancyEntity.toVacancyUI(): Vacancy {
  return Vacancy(
        addressResponse?.toAddress(),
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

fun List<VacancyEntity>.toVacanciesUI():List<Vacancy> = this.map {it.toVacancyUI()}

fun Vacancy.toVacancyEntity(): VacancyEntity {
    return VacancyEntity(
        address?.toAddress(),
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