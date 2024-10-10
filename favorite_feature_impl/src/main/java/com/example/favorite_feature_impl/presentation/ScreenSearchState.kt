package com.example.favorite_feature_impl.presentation

import com.example.favorite_feature_impl.presentation.model.VacancyUI

data class ScreenSearchState (
    val errorMessage: String = "",
    val offers: List<VacancyUI> = emptyList(),
    val isFullVacanciesList : Boolean = false
)
