package com.example.search_feature_impl.presentation.adapter

import androidx.appcompat.content.res.AppCompatResources
import androidx.core.view.isVisible
import com.example.search_feature_impl.databinding.ItemSearchHeaderBinding
import com.example.search_feature_impl.databinding.ItemSearchOfferRvBinding
import com.example.search_feature_impl.databinding.ItemSearchVacancyBinding
import com.example.search_feature_impl.presentation.model.OffersUI
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

fun offerRecycleDelegate() = adapterDelegateViewBinding<
        OffersUI.CommonList, OffersUI, ItemSearchOfferRvBinding>({
        layoutInflater,
        root ->
    ItemSearchOfferRvBinding.inflate(layoutInflater, root, false)}) {

    with(binding) {
        val adapter = OfferAdapter()
        offerBlocksRecyclerView.adapter = adapter
        adapter.items = item.offers
    }
}


fun vacancyDelegate (listener: VacancyItemListener) =
    adapterDelegateViewBinding<OffersUI.VacancyUI, OffersUI, ItemSearchVacancyBinding>({
            layoutInflater,
            root ->
        ItemSearchVacancyBinding.inflate(layoutInflater, root, false)}) {

        with(binding) {

            root.setOnClickListener{
                listener.onVacancyClickListener(item)
            }
            ivFavorite.setOnClickListener {
                listener.onFavoriteIconClick(item)
            }

            bind {
                tvNowWatching.isVisible = item.lookingNumber > 0
                val people: String =
                    context.resources.getQuantityString(
                        com.example.core_utils.R.plurals.plurals_vacancies, item.lookingNumber, item.lookingNumber
                    )
                tvNowWatching.text = "Сейчас просматривает $people"
                tvVacanyName.text = item.title
                tvSalary.text = item.salary.full
                tvCity.text = item.address?.town
                tvCompany.text = item.company
                tvExperience.text = item.experience.previewText
                tvPublicated.text = item.publishedDate
                ivFavorite.setImageDrawable(
                    if (item.isFavorite) AppCompatResources.getDrawable(context, com.example.core_utils.R.drawable.ic_favourite_fill)
                    else AppCompatResources.getDrawable(context, com.example.core_utils.R.drawable.ic_favourite)
                )
            }
        }
    }

fun headerDelegate () = adapterDelegateViewBinding<OffersUI.Header, OffersUI, ItemSearchHeaderBinding>({
        layoutInflater,
        root ->
    ItemSearchHeaderBinding.inflate(layoutInflater, root, false)}) {

    with(binding) {
        bind{
            tvVacanciesForYou.text = item.header
        }
    }
}
