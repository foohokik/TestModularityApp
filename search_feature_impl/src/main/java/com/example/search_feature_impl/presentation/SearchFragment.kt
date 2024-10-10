package com.example.search_feature_impl.presentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.net.toUri
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.core_utils.extensions.lazyViewModel
import com.example.search_feature_impl.R
import com.example.search_feature_impl.databinding.FragmentSearchBinding
import com.example.search_feature_impl.di.SearchFeatureComponentHolder
import com.example.search_feature_impl.presentation.adapter.SearchAdapter
import com.example.search_feature_impl.presentation.model.OffersUI
import kotlinx.coroutines.launch
import kotlin.properties.Delegates

class SearchFragment : Fragment(R.layout.fragment_search) {


    private val viewModel: SearchViewModel by lazyViewModel {
        SearchFeatureComponentHolder.getComponent().getSearchViewModelFactory().create()
    }

    private var _binding: FragmentSearchBinding ? = null
    private val binding get() = _binding!!

    private lateinit var searchAdapter: SearchAdapter

    init {
            SearchFeatureComponentHolder.getComponent().inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MYLOG", "oncreate fragment")
       // SearchFeatureComponentHolder.getComponent().inject(this)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSearchBinding.bind(view)
        initSearchRecycleView()
        observe()
      //  initUI()
    }

//    private fun initUI() {
//        val qty = viewModel.numberOfVacancies
//        Log.d("MYTAG", "numbers  "+ qty)
//        val vacanciesText = qty?.let {
//            requireContext().resources.getQuantityString(
//                com.example.core_utils.R.plurals.plurals_vacancies_full, qty, qty
//            )
//        }
//        binding.tvVacaancies.text = vacanciesText
//    }
    private fun observe() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch { viewModel.screenStateFlow.collect{
                    searchAdapter.items = it.offers
                } }

                launch { viewModel.sideEffects.collect { handleSideEffects(it) } }
            }
        }
    }


    private fun initSearchRecycleView() {
        with(binding?.rvSearchFragment) {
            searchAdapter = SearchAdapter(viewModel)
            this?.adapter = searchAdapter
            this?.itemAnimator = null
        }
    }

    private fun handleSideEffects(sideEffects: SideEffects) {
        when (sideEffects) {
            is SideEffects.ErrorEffect -> Unit
            is SideEffects.ExceptionEffect -> Unit
            is SideEffects.ClickEffectNavigation -> {
                findNavController().navigate("app://full_vacancy/${sideEffects.item.id}".toUri())
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.updateList()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}