package com.example.search_feature_impl.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.search_feature_impl.di.IoDispatcher
import com.example.search_feature_impl.domain.SearchFeaureInteractor
import com.example.search_feature_impl.domain.model.Offers
import com.example.search_feature_impl.domain.model.Vacancy
import com.example.search_feature_impl.presentation.adapter.CommonItemListener
import com.example.search_feature_impl.presentation.model.NumberVacancies
import com.example.search_feature_impl.presentation.model.OffersUI
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SearchViewModel @AssistedInject constructor(
    private val interactor: SearchFeaureInteractor,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
): ViewModel(), CommonItemListener {

    private val _offersFlow = MutableStateFlow<List<OffersUI>>(emptyList())
    val offersFlow = _offersFlow.asStateFlow()

    init {
        Log.d("MYTAG", "init")
        getOffers()
        Log.d("MYTAG", " offersFlow.value   =   " + offersFlow.value)
    }

    private fun getOffers(){
        viewModelScope.launch(dispatcher) {
            Log.d("MYTAG", "enter in getOffers()")
            val result= interactor.getOffers()
            _offersFlow.value = result
            Log.d("MYTAG", "_offersFlow.value   =   " + _offersFlow.value)
        }
    }

    override fun onVacancyClickListener(vacancy: OffersUI.VacancyUI) {
        TODO("Not yet implemented")
    }

    override fun onFavoriteIconClick(vacancy: OffersUI.VacancyUI) {
        TODO("Not yet implemented")
    }

    override fun onClickButton(btn: NumberVacancies) {
        TODO("Not yet implemented")
    }


    @AssistedFactory
    interface Factory {
        fun create(): SearchViewModel
    }
}