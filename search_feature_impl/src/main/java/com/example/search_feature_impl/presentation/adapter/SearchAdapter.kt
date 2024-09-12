package com.example.search_feature_impl.presentation.adapter

import com.example.search_feature_impl.domain.model.RecycleViewOffersItem
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class SearchAdapter (listener: CommonItemListener) :
    AsyncListDifferDelegationAdapter<RecycleViewOffersItem> (
        SearchAdapterDiffCallback(),
        offerRecycleDelegate(),
        vacancyDelegate(listener),
        headerDelegate()
    )
{
}