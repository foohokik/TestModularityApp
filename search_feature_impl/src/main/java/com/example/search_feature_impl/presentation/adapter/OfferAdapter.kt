package com.example.search_feature_impl.presentation.adapter

import com.example.search_feature_impl.domain.model.OfferUI
import com.example.search_feature_impl.domain.model.VacancyUI
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class OfferAdapter () :
    AsyncListDifferDelegationAdapter<OfferUI> (
        OfferItemDiffCallback(), offerDelegate()
    )
{
}