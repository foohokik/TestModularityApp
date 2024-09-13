package com.example.search_feature_impl.presentation.adapter

import com.example.search_feature_impl.presentation.model.OffersUI
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class OfferAdapter () :
    AsyncListDifferDelegationAdapter<OffersUI.OfferUI>(
        OfferItemDiffCallback(), offerDelegate()
    )
{

}