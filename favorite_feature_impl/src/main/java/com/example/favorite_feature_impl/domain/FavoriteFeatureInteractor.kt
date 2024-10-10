package com.example.favorite_feature_impl.domain

import com.example.favorite_feature_impl.domain.repo.LocalFavoriteRepo
import com.example.favorite_feature_impl.presentation.ScreenSearchState
import com.example.favorite_feature_impl.presentation.SideEffects
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class FavoriteFeatureInteractor @Inject constructor(
    private val localFavoriteRepo: LocalFavoriteRepo,
)
{
    suspend fun getAllVacancies () = localFavoriteRepo.getAllFavoriteVacancies()


    suspend fun updateVacancyIsFavorite (isFavorite: Boolean, id: String) = localFavoriteRepo.updateVacancyIsFavorite(isFavorite, id)


}