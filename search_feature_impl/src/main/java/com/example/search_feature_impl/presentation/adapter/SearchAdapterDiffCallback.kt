package com.example.search_feature_impl.presentation.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.example.search_feature_impl.domain.model.RecycleViewOffersItem

internal class SearchAdapterDiffCallback : DiffUtil.ItemCallback<RecycleViewOffersItem>() {

    override fun areItemsTheSame(oldItem: RecycleViewOffersItem, newItem: RecycleViewOffersItem): Boolean =
        oldItem.javaClass == newItem.javaClass

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: RecycleViewOffersItem, newItem: RecycleViewOffersItem): Boolean =
        oldItem == newItem
}
