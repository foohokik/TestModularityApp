package v.shihanova.core_utils.extensions

import android.app.Activity
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.core.content.getSystemService

fun View.requestKeyboardFocus() {
    requestFocus()
    val imm = context.getSystemService<InputMethodManager>()
    imm?.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
}

fun Activity.hideKeyboard() {
    val imm = getSystemService<InputMethodManager>()
    imm?.hideSoftInputFromWindow(window.decorView.findViewById<View>(android.R.id.content).windowToken, 0)
}

fun View.hideKeyboard() {
    val imm = context.getSystemService<InputMethodManager>()
    imm?.hideSoftInputFromWindow(windowToken, 0)
}