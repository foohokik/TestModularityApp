package v.shihanova.core_utils.extensions

import android.content.Context
import android.content.res.Resources
import android.view.View
import kotlin.math.roundToInt

fun Context.dpToPx(dp: Int): Int = resources.dpToPx(dp)

fun Resources.dpToPx(dp: Int): Int = (dp * displayMetrics.density).roundToInt()