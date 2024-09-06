package com.example.search_feature_impl.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.core_utils.extensions.lazyViewModel
import com.example.search_feature_impl.R
import com.example.search_feature_impl.databinding.FragmentSearchBinding
import com.example.search_feature_impl.di.SearchFeatureComponentHolder
import com.example.search_feature_impl.presentation.adapter.OfferAdapter
import com.example.search_feature_impl.presentation.adapter.VacancyAdapter
import kotlinx.coroutines.launch

class SearchFragment : Fragment(R.layout.fragment_search) {


    private val viewModel: SearchViewModel by lazyViewModel {
        SearchFeatureComponentHolder.getComponent().getSearchViewModelFactory().create()
    }

    private var binding: FragmentSearchBinding ? = null


    private lateinit var vacanciesAdapter: VacancyAdapter
    private lateinit var offersAdapter: OfferAdapter

//    init {
//        lifecycleScope.launch {
//            SearchFeatureComponentHolder.getComponent().inject(this)
//        }
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // SearchFeatureComponentHolder.getComponent().inject(this)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSearchBinding.bind(view)
//        initVacancyRecycleView()
//        initOfferRecycleView()
        observe()
    }

    private fun observe() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch { viewModel.offersFlow.collect{
                    vacanciesAdapter.items = it.vacancies
                    offersAdapter.items = it.offers
                } }
            }
        }
    }

//    private fun initVacancyRecycleView() {
//        with(binding?.rvVacanies) {
//            vacanciesAdapter = VacancyAdapter(viewModel)
//            this?.adapter = vacanciesAdapter
//        }
//    }
//
//    private fun initOfferRecycleView() {
//        with(binding?.rvRecomendations) {
//            offersAdapter = OfferAdapter()
//            this?.adapter = offersAdapter
//        }
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}