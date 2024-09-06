package v.shihanova.core_utils.presentation.viewmodel

import androidx.core.net.toUri
import androidx.navigation.NavDirections
import androidx.navigation.Navigator
import v.shihanova.core_utils.presentation.SingleEvents

interface Dispatcher {

	val events: SingleEvents

	fun showMessage(message: String, urgent: Boolean = false, dispatchToActivity: Boolean = true) {
		events.postEvent(MessageEvent(message, urgent, dispatchToActivity))
	}

	fun showError(message: String, dispatchToActivity: Boolean = true) {
		events.postEvent(ErrorMessageEvent(message, dispatchToActivity))
	}

	fun navigateTo(direction: NavDirections, extras: Navigator.Extras? = null) {
		events.postEvent(NavigationEvent.ToDirection(direction, extras))
	}

	fun navigateToFeature(uri: String, extras: Navigator.Extras? = null) {
		events.postEvent(NavigationEvent.ToFeature(uri.toUri(), extras))
	}

	fun popBackStack(destinationId: Int, inclusive: Boolean = false) {
		events.postEvent(NavigationEvent.PopBackStack(destinationId, inclusive))
	}

	fun navigateUp() {
		events.postEvent(NavigationEvent.Up())
	}
}