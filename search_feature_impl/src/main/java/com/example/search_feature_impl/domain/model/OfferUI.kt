package com.example.search_feature_impl.domain.model

import androidx.annotation.DrawableRes
import java.io.Serializable


data class OfferUI(
    val button: String = "",
    val id: String,
    val link: String,
    val title: String,
    @DrawableRes val icon: Int
): Serializable