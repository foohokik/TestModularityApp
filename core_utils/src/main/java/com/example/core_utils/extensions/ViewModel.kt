package com.example.core_utils.extensions

import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.savedstate.SavedStateRegistryOwner

class Factory<T: ViewModel>(
	savedStateRegistryOwner: SavedStateRegistryOwner,
	private val create: (stateHandle: SavedStateHandle) -> T
) : AbstractSavedStateViewModelFactory(savedStateRegistryOwner, null) {

	override fun <T : ViewModel> create(
		key: String,
		modelClass: Class<T>,
		handle: SavedStateHandle
	): T {
		return create.invoke(handle) as T
	}

}

class FactoryWithoutParameters<T: ViewModel>(private val create: () -> T) : ViewModelProvider.Factory {
	override fun <T : ViewModel> create(modelClass: Class<T>): T {
		return create.invoke() as T
	}
}

inline fun <reified T : ViewModel> Fragment.lazyViewModel(
	noinline create: (stateHandle: SavedStateHandle) -> T
) = viewModels<T> {
	Factory(this, create)
}

inline fun <reified T : ViewModel> Fragment.assistedViewModel(
	crossinline viewModelProducer: (SavedStateHandle) -> T,
): Lazy<T> {
	return viewModels {
		object : AbstractSavedStateViewModelFactory(this, arguments) {
			override fun <T : ViewModel> create(key: String, modelClass: Class<T>, handle: SavedStateHandle): T {
				@Suppress("UNCHECKED_CAST")
				return viewModelProducer(handle) as T
			}
		}
	}
}


//inline fun <reified VM : ViewModel> Fragment.viewModelFactory(
//    noinline factory: () -> VM,
//): Lazy<VM> = viewModels {
//    ViewModelFactory(factory)
//}
//
//inline fun <reified VM : ViewModel> AppCompatActivity.viewModelFactory(
//    noinline factory: () -> VM,
//): Lazy<VM> = viewModels {
//    ViewModelFactory(factory)
//}
//
//class ViewModelFactory<VM : ViewModel>(
//    private val factory: () -> VM,
//) : ViewModelProvider.Factory {
//
//    @Suppress("UNCHECKED_CAST")
//    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T
//            = factory() as T
//}