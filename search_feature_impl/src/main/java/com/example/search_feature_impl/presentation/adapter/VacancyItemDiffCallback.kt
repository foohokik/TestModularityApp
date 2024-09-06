package com.example.search_feature_impl.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.search_feature_impl.domain.model.VacancyUI

internal class VacancyItemDiffCallback : DiffUtil.ItemCallback<VacancyUI>() {

    override fun areItemsTheSame(oldItem: VacancyUI, newItem: VacancyUI): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: VacancyUI, newItem: VacancyUI): Boolean =
        oldItem == newItem
}
