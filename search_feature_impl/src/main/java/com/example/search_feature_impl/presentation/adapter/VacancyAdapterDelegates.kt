package com.example.search_feature_impl.presentation.adapter

//fun vacancyDelegate (listener: VacancyItemListener) =
//    adapterDelegateViewBinding<VacancyUI, VacancyUI, ItemSearchVacancyBinding>({
//        layoutInflater,
//        root ->
//        ItemSearchVacancyBinding.inflate(layoutInflater, root, false)}) {
//
//        with(binding) {
//
//            root.setOnClickListener{
//                listener.onVacancyClickListener(item)
//            }
//            ivFavorite.setOnClickListener {
//                listener.onFavoriteIconClick(item)
//            }
//
//            bind {
//                tvNowWatching.isVisible = item.lookingNumber > 0
//                val people: String =
//                    context.resources.getQuantityString(
//                        com.example.core_utils.R.plurals.plurals_vacancies, item.lookingNumber, item.lookingNumber
//                    )
//                tvNowWatching.text = "Сейчас просматривает $people"
//                tvVacanyName.text = item.title
//                tvSalary.text = item.salary.full
//                tvCity.text = item.addressResponse.town
//                tvCompany.text = item.company
//                tvExperience.text = item.experience.previewText
//                tvPublicated.text = item.publishedDate
//                ivFavorite.setImageDrawable(
//                    if (item.isFavorite) AppCompatResources.getDrawable(context, com.example.core_utils.R.drawable.ic_favourite_fill)
//                    else AppCompatResources.getDrawable(context, com.example.core_utils.R.drawable.ic_favourite)
//                )
//            }
//        }
//    }