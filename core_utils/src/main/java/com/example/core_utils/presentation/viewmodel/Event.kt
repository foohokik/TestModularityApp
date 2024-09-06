package v.shihanova.core_utils.presentation.viewmodel

import android.net.Uri
import androidx.navigation.NavDirections
import androidx.navigation.Navigator

interface Event

data class MessageEvent(val message: String, val urgent: Boolean, val dispatchToActivity: Boolean) : Event
data class ErrorMessageEvent(val message: String, val dispatchToActivity: Boolean) : Event

sealed class NavigationEvent : Event {

	data class Up(
		val placeholder: String? = null
	) : NavigationEvent()

	data class ToDirection(
		val direction: NavDirections,
		val extras: Navigator.Extras? = null
	) : NavigationEvent()

	data class ToFeature(
		val uri: Uri,
		val extras: Navigator.Extras? = null
	) : NavigationEvent()

	data class PopBackStack(
		val destinationId: Int,
		val inclusive: Boolean
	) : NavigationEvent()
}