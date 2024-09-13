package com.example.search_feature_impl.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.search_feature_impl.domain.model.Vacancy

internal class VacancyItemDiffCallback : DiffUtil.ItemCallback<Vacancy>() {

    override fun areItemsTheSame(oldItem: Vacancy, newItem: Vacancy): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Vacancy, newItem: Vacancy): Boolean =
        oldItem == newItem
}
