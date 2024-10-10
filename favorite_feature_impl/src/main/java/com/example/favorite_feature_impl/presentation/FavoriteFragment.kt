package com.example.favorite_feature_impl.presentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.core_utils.extensions.lazyViewModel
import com.example.favorite_feature_impl.R
import com.example.favorite_feature_impl.databinding.FragmentFavoriteBinding
import com.example.favorite_feature_impl.di.FavoriteFeatureComponentHolder
import com.example.favorite_feature_impl.presentation.adapter.VacancyAdapter
import kotlinx.coroutines.launch

class FavoriteFragment : Fragment(R.layout.fragment_favorite) {

    private var _binding: FragmentFavoriteBinding ? = null
    private val binding get() = _binding!!

    private lateinit var favoriteAdapter: VacancyAdapter

    private val viewModel: FavoriteViewModel by lazyViewModel {
        FavoriteFeatureComponentHolder.getComponent().getFavoriteViewModelFactory().create()
    }

    init {
        FavoriteFeatureComponentHolder.getComponent().inject(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        observe()
        initUI()
    }

    private fun initUI() {
        val qty = viewModel.vacanciesFlow.value.size
        val vacanciesText = requireContext().resources.getQuantityString(
            com.example.core_utils.R.plurals.plurals_vacancies_full, qty, qty
        )
        binding.tvQtyVacancies.text = vacanciesText
    }
    private fun observe() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch { viewModel.vacanciesFlow.collect{
                    favoriteAdapter.items = it

                } }

                launch { viewModel.sideEffects.collect { handleSideEffects(it) } }
            }
        }
    }
    private fun initRecyclerView() {
        with(binding.rvFavorites) {
            favoriteAdapter = VacancyAdapter(viewModel)
            adapter = favoriteAdapter
            itemAnimator = null
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
        viewModel.getVacancies()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}