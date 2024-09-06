package v.shihanova.core_utils.extensions

import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.Navigator

/**
 * Безопасный переход по навигации.
 * Предотвращает краш при открытии более чем одного экрана (нажатие на несколько кнопок одновременно)
 * или если с текущего экрана нельзя попасть на запрашиваемый.
 */
fun NavController.navigateSafe(direction: NavDirections, extras: Navigator.Extras?) {
	when {
		currentDestination?.getAction(direction.actionId) == null -> {
			//Timber.e("Unexpected action '${direction.actionId}' for destination '$currentDestination'")
		}

		extras == null -> navigate(direction)
		else -> navigate(direction, extras)
	}
}