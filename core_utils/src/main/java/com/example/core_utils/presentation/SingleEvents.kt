package com.example.core_utils.presentation

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import v.shihanova.core_utils.presentation.viewmodel.Event

class SingleEvents {

	private val _events = Channel<Event>()
	val values = _events.receiveAsFlow()

	fun postEvent(event: Event) {
		_events.trySend(event)
	}
}