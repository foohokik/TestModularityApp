package v.shihanova.core_utils.presentation.ui

import android.view.View
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import com.google.android.material.snackbar.Snackbar

interface SnackbarHandler {

	/**
	 * Привязка [Snackbar] к конкретному
	 * [CoordinatorLayout][androidx.coordinatorlayout.widget.CoordinatorLayout].
	 *
	 * В случаях где [Snackbar] должен отрисовывается в другом контейнере, например, во вложенном
	 * фрагменте из раздела, нужно переопределить это поле.
	 *
	 * @see Snackbar.findSuitableParent
	 */
	@get:IdRes
	val snackbarContainer: Int

	/**
	 * Привязка [Snackbar] к конкретному элементу экрана.
	 * Например, чтобы показать его над кнопками или другими элементами.
	 *
	 * @see snackbarContainer
	 */
	@get:IdRes
	val snackbarAnchorView: Int?
		get() = null

	fun showSnackbar(
		text: String,
		duration: Int = Snackbar.LENGTH_LONG,
		@StringRes actionTitleId: Int? = null,
		action: ((View) -> Unit)? = null,
		@IdRes containerResId: Int = snackbarContainer,
		@IdRes anchorViewId: Int? = snackbarAnchorView
	)
}