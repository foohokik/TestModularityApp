package com.example.favorite_feature_impl.presentation.adapter

import androidx.appcompat.content.res.AppCompatResources
import androidx.core.view.isVisible
import com.example.favorite_feature_impl.databinding.ItemFavoriteVacancyBinding
import com.example.favorite_feature_impl.presentation.model.VacancyUI
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding


    fun vacancyDelegate(listener: VacancyItemListener) =
        adapterDelegateViewBinding<VacancyUI, VacancyUI, ItemFavoriteVacancyBinding>({ layoutInflater,
                                                                                    root ->
            ItemFavoriteVacancyBinding.inflate(layoutInflater, root, false)
        }) {

            with(binding) {

                root.setOnClickListener {
                    listener.onVacancyClickListener(item)
                }
                ivFavorite.setOnClickListener {
                    listener.onFavoriteIconClick(item)
                    ivFavorite.setImageDrawable(
                        if (item.isFavorite) AppCompatResources.getDrawable(
                            context,
                            com.example.core_utils.R.drawable.ic_favourite_fill
                        )
                        else AppCompatResources.getDrawable(
                            context,
                            com.example.core_utils.R.drawable.ic_favourite
                        )
                    )
                }
                }
            bind {
                with(binding) {

                        tvNowWatching.isVisible = item.lookingNumber > 0
                        val people: String =
                            context.resources.getQuantityString(
                                com.example.core_utils.R.plurals.plurals_vacancies,
                                item.lookingNumber,
                                item.lookingNumber
                            )
                        tvNowWatching.text = "Сейчас просматривает $people"
                        tvVacanyName.text = item.title
                        tvSalary.text = item.salary.full
                        tvCity.text = item.address?.town
                        tvCompany.text = item.company
                        tvExperience.text = item.experience.previewText
                        tvPublicated.text = item.publishedDate
                    ivFavorite.setImageDrawable(
                        if (item.isFavorite) AppCompatResources.getDrawable(
                            context,
                            com.example.core_utils.R.drawable.ic_favourite_fill
                        )
                        else AppCompatResources.getDrawable(
                            context,
                            com.example.core_utils.R.drawable.ic_favourite
                        )
                    )

                    }
                }
            }