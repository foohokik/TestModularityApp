package com.example.search_feature_impl.presentation.adapter

import com.example.search_feature_impl.domain.model.VacancyUI

interface VacancyItemListener {

    fun onVacancyClickListener (vacancy: VacancyUI)

    fun onFavoriteIconClick (vacancy: VacancyUI)

}