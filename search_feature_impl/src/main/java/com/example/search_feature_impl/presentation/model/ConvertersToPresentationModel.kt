package com.example.search_feature_impl.presentation.model
import com.example.core.data.AddressResponse
import com.example.core.data.ExperienceResponse
import com.example.core.data.OfferResponse
import com.example.core.data.OffersResponse
import com.example.core.data.SalaryResponse
import com.example.core.data.VacancyResponse
import com.example.core_database.impl.data.VacancyEntity
import com.example.core_utils.presentation.model.AddressUI
import com.example.core_utils.presentation.model.ExperienceUI
import com.example.core_utils.presentation.model.SalaryUI
import com.example.search_feature_impl.domain.model.Address
import com.example.search_feature_impl.domain.model.Experience
import com.example.search_feature_impl.domain.model.Offer
import com.example.search_feature_impl.domain.model.Offers
import com.example.search_feature_impl.domain.model.Salary
import com.example.search_feature_impl.domain.model.Vacancy

//fun ButtonResponse.toButtonUI (): ButtonUI = ButtonUI (text.orEmpty())

fun Offer.toOfferUI (): OfferUI = OfferUI(
    button,
    id.orEmpty(),
    link.orEmpty(),
    icon = chooseIcon(id),
    title = title.orEmpty()
)


fun chooseIcon(id: String?): Int {
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


fun Experience.toExperienceUI(): ExperienceUI = ExperienceUI(previewText.orEmpty(), text.orEmpty())


fun ExperienceUI.toExperience(): Experience = Experience(previewText, text)

fun Salary.toSalaryUI (): SalaryUI = SalaryUI(full.orEmpty(), short.orEmpty())

fun SalaryUI.toSalary (): Salary = Salary(full, short)


fun Vacancy.toVacancyUI(): OffersUI.VacancyUI {
    return OffersUI.VacancyUI(
        address.toAddressUI(),
        company.orEmpty(),
        experience.toExperienceUI(),
        id.orEmpty(),
        isFavorite,
        lookingNumber,
        publishedDate.orEmpty(),
        salary.toSalaryUI(),
        title.orEmpty()
    )
}

fun List<Vacancy>.toVacanciesListUI():List<OffersUI.VacancyUI> = this.map {it.toVacancyUI()}


fun Offers.toCommonList(): OffersUI.CommonList = OffersUI.CommonList(
    offers?.toOffersListUI())

//fun OffersUI.VacancyUI.toVacancy(): Vacancy = Vacancy(
//    address.toAddress(),
//    company.orEmpty(),
//    experience.toExperience(),
//    id.orEmpty(),
//    isFavorite,
//    lookingNumber,
//    publishedDate.orEmpty(),
//    salary.toSalary(),
//    title.orEmpty()
//)

//fun List<OffersUI.VacancyUI>.toVacanciesList():List<Vacancy> = this.map {it.toVacancy()}