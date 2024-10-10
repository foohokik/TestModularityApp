package com.example.full_vacancy_feature_impl.presentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.core_utils.extensions.assistedViewModel
import com.example.core_utils.extensions.lazyViewModel
import com.example.full_vacancy_feature_impl.R
import com.example.full_vacancy_feature_impl.databinding.FragmentFullVacancyBinding
import com.example.full_vacancy_feature_impl.di.FullVacancyFeatureComponentHolder
import com.example.full_vacancy_feature_impl.presentation.adapter.QuestionAdapter
import com.example.full_vacancy_feature_impl.presentation.model.VacancyUI
import kotlinx.coroutines.launch


class FullVacancyFragment : Fragment(R.layout.fragment_full_vacancy) {

    private var _binding: FragmentFullVacancyBinding? = null
    private val binding get() = _binding!!

//    private val args: FullVacancyFragmentArgs by navArgs()
    private val viewModel: FullVacancyViewModel by assistedViewModel {
        FullVacancyFeatureComponentHolder.getComponent().getDetailVacancyViewModelFactory().create(it)
    }

    private lateinit var questionsAdapter: QuestionAdapter

    init {
        FullVacancyFeatureComponentHolder.getComponent().inject(this)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentFullVacancyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initSearchRecycleView()
        observe()
    }

    private fun observe() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch { viewModel.contentVacancyState.collect{
                    initView(it)
                } }
            }
        }
    }

    private fun initSearchRecycleView() {
        with(binding.rvQuestions) {
            questionsAdapter = QuestionAdapter()
            adapter = questionsAdapter
        }
    }

    private fun initView (vacancy: VacancyUI) {
        with(binding) {
           tvTitle.text = vacancy.title
           tvSalary.text = vacancy.salary.full
            tvExperience.text = "Требуемый опыт: ${vacancy.experience.text}"
            tvSchedules.text = vacancy.schedules
            val peopleAppliedText = requireContext().resources.getQuantityString(
                com.example.core_utils.R.plurals.plurals_vacancies,
                vacancy.appliedNumber,
                vacancy.appliedNumber
            )
            tvAppliedPeople.text= "$peopleAppliedText человек уже откликнулось"
            val lookingNumberText = requireContext().resources.getQuantityString(
                com.example.core_utils.R.plurals.plurals_vacancies,
                vacancy.lookingNumber,
                vacancy.lookingNumber
            )
            tvLookingNumber.text = "${lookingNumberText} сейчас смотрят"
            tvCompanyName.text= vacancy.company
            tvAddress.text = "${vacancy.address.town}, ${vacancy.address.street}, ${vacancy.address.house}"
            tvDescripton.text = vacancy.description
            tvResponsibilities.text = vacancy.responsibilities
            questionsAdapter.items = vacancy.questions
            ivFavorite.setImageDrawable(
                if (vacancy.isFavorite) {
                    AppCompatResources.getDrawable(
                        requireContext(),
                        com.example.core_utils.R.drawable.ic_favourite_fill
                    )
                }
                else {
                    AppCompatResources.getDrawable(
                        requireContext(),
                        com.example.core_utils.R.drawable.ic_favourite
                    )
                }
            )

            ivFavorite.setOnClickListener {
                viewModel.onFavoriteIconClick()
            }

            btnBack.setOnClickListener {
                findNavController().popBackStack()
            }

            btnResponse.setOnClickListener {
                findNavController()
                    .navigate(
                        FullVacancyFragmentDirections.actionFullVacancyFragmentToResponseFragment(vacancy.title)
                    )
            }
        }
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}