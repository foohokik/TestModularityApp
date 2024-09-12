package com.example.search_feature_impl.presentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.core_utils.extensions.lazyViewModel
import com.example.search_feature_impl.R
import com.example.search_feature_impl.databinding.FragmentSearchBinding
import com.example.search_feature_impl.di.SearchFeatureComponentHolder
import com.example.search_feature_impl.domain.model.OffersUI
import com.example.search_feature_impl.presentation.adapter.SearchAdapter
import kotlinx.coroutines.launch

class SearchFragment : Fragment(R.layout.fragment_search) {


    private val viewModel: SearchViewModel by lazyViewModel {
        SearchFeatureComponentHolder.getComponent().getSearchViewModelFactory().create()
    }

    private var binding: FragmentSearchBinding ? = null


    private lateinit var searchAdapter: SearchAdapter

    init {
            SearchFeatureComponentHolder.getComponent().inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // SearchFeatureComponentHolder.getComponent().inject(this)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSearchBinding.bind(view)
        initSearchRecycleView()
        observe()
    }

    private fun observe() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch { viewModel.offersFlow.collect{
                    Log.d("MYTAG", "it   =   " + it)
                    val list : List<OffersUI> = listOf(it)
                    searchAdapter.items = list
                } }
            }
        }
    }


    private fun initSearchRecycleView() {
        with(binding?.rvSearchFragment) {
            searchAdapter = SearchAdapter(viewModel)
            this?.adapter = searchAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}