package com.example.core_utils.presentation.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import com.example.core_utils.presentation.SingleEvents
import v.shihanova.core_utils.presentation.viewmodel.Dispatcher
import v.shihanova.core_utils.presentation.viewmodel.ViewState

abstract class BaseViewModel<T : ViewState>(
	initialState: T,
) : ViewModel(), Dispatcher {

	protected val liveState = MutableSharedFlow<T>(
		replay = 1,
		extraBufferCapacity = 0,
		onBufferOverflow = BufferOverflow.DROP_OLDEST
	).apply {
		tryEmit(initialState)
	}

	protected var state: T = initialState
		set(value) {
			liveState.tryEmit(value)
			field = value
		}

	override val events = SingleEvents()
}