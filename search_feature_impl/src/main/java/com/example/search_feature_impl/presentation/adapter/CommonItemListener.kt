package com.example.search_feature_impl.presentation.adapter

import com.example.search_feature_impl.domain.model.NumberVacancies
import com.example.search_feature_impl.domain.model.VacancyUI

interface CommonItemListener : VacancyItemListener, ButtonItemListener
interface VacancyItemListener {

    fun onVacancyClickListener (vacancy: VacancyUI)

    fun onFavoriteIconClick (vacancy: VacancyUI)

}

interface ButtonItemListener {

    fun OnClickButton (btn: NumberVacancies)
}