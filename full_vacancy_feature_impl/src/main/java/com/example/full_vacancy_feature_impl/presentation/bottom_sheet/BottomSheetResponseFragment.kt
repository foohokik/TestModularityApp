package com.example.full_vacancy_feature_impl.presentation.bottom_sheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.fragment.navArgs
import com.example.full_vacancy_feature_impl.R
import com.example.full_vacancy_feature_impl.databinding.BottomSheetResponseBinding
import com.example.full_vacancy_feature_impl.databinding.FragmentFullVacancyBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetResponseFragment: BottomSheetDialogFragment(R.layout.bottom_sheet_response) {

    private var _binding: BottomSheetResponseBinding? = null
    private val binding get() = _binding!!

    private val args by navArgs<BottomSheetResponseFragmentArgs>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = BottomSheetResponseBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }


    private fun initView () {
        with(binding) {
            tvJobTitle.text = args.title
            tvAddLetter.setOnClickListener {
                tvAddLetter.isVisible = false
                editTvLetter.isVisible = true
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}