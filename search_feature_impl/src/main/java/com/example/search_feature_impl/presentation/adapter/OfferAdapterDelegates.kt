package com.example.search_feature_impl.presentation.adapter

import androidx.appcompat.content.res.AppCompatResources
import androidx.core.view.isVisible
import com.example.search_feature_impl.databinding.ItemOfferBinding
import com.example.search_feature_impl.domain.model.Offer
import com.example.search_feature_impl.presentation.model.OfferUI
import com.example.search_feature_impl.presentation.model.OffersUI
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

fun offerDelegate() = adapterDelegateViewBinding<OfferUI, OfferUI, ItemOfferBinding>({
        layoutInflater,
        root ->
    ItemOfferBinding.inflate(layoutInflater, root, false)}) {
    bind{
    with(binding) {

            if (item.icon > 0) {
                icon.setImageDrawable(AppCompatResources.getDrawable(context, item.icon))
            } else {
                icon.isVisible = false
            }

            binding.title.text = item.title
            btnOfferItem.isVisible = item.button.isBlank()
            binding.btnOfferItem.text = item.button
        }
    }
}