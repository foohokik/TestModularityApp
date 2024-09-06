package com.example.search_feature_impl.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.search_feature_impl.data.RemoteSearchRepoImpl
import com.example.search_feature_impl.di.IoDispatcher
import com.example.search_feature_impl.domain.SearchFeaureInteractor
import com.example.search_feature_impl.domain.model.OffersUI
import com.example.search_feature_impl.domain.model.VacancyUI
import com.example.search_feature_impl.domain.repo.RemoteSearchRepo
import com.example.search_feature_impl.presentation.adapter.VacancyItemListener
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchViewModel @AssistedInject constructor(
    private val interactor: SearchFeaureInteractor,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
): ViewModel(), VacancyItemListener {

    private val _offersFlow = MutableStateFlow(OffersUI())
    val offersFlow = _offersFlow.asStateFlow()

    init {
        getOffers()
    }

    private fun getOffers(){
        viewModelScope.launch(dispatcher) {
            _offersFlow.value = interactor.getOffers()
        }
    }

    override fun onVacancyClickListener(vacancy: VacancyUI) {
        TODO("Not yet implemented")
    }

    override fun onFavoriteIconClick(vacancy: VacancyUI) {
        TODO("Not yet implemented")
    }

    @AssistedFactory
    interface Factory {
        fun create(): SearchViewModel
    }
}