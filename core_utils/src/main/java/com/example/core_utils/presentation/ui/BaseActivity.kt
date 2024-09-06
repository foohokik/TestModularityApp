package com.example.core_utils.presentation.ui

import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import com.google.android.material.snackbar.Snackbar
import v.shihanova.core_utils.extensions.navigateSafe
import v.shihanova.core_utils.presentation.ui.SnackbarHandler
import v.shihanova.core_utils.presentation.viewmodel.ErrorMessageEvent
import v.shihanova.core_utils.presentation.viewmodel.Event
import v.shihanova.core_utils.presentation.viewmodel.MessageEvent
import v.shihanova.core_utils.presentation.viewmodel.NavigationEvent

abstract class BaseActivity(@LayoutRes layoutId: Int) : AppCompatActivity(layoutId),
	SnackbarHandler {

	private val mainView by lazy { window.decorView }

	lateinit var controller: NavController

	/** Функция для обработки событий, которые прилетают из ViewModel. */
	protected open fun onEvent(event: Event) {
		when (event) {
			is MessageEvent -> {
				showSnackbar(event.message)
			}

			is ErrorMessageEvent -> showSnackbar(event.message)

			is NavigationEvent -> handleNavigationEvent(event)
		}
	}

	override fun showSnackbar(
		text: String,
		duration: Int,
		actionTitleId: Int?,
		action: ((View) -> Unit)?,
		containerResId: Int,
		anchorViewId: Int?
	) {
		val viewGroup = mainView.findViewById(containerResId) as? ViewGroup ?: return
		Snackbar.make(viewGroup, text, duration)
			.apply {
				actionTitleId?.let { setAction(it, action) }
				anchorView = viewGroup.findViewById(anchorViewId ?: View.NO_ID)
			}
			.show()
	}

	protected open fun handleNavigationEvent(event: NavigationEvent) {
		when (event) {
			is NavigationEvent.ToDirection -> controller.navigateSafe(event.direction, extras = event.extras)
			is NavigationEvent.PopBackStack -> controller.popBackStack(event.destinationId, event.inclusive)
			is NavigationEvent.Up -> controller.navigateUp()
			is NavigationEvent.ToFeature -> TODO()
		}
	}
}