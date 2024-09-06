package v.shihanova.core_utils.presentation.ui

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.example.core_utils.presentation.ui.BaseActivity
import v.shihanova.core_utils.extensions.hideKeyboard

abstract class BaseFragment(@LayoutRes layoutId: Int) : Fragment(layoutId) {

    private val baseActivity by lazy { activity as BaseActivity }

    override fun onPause() {
        baseActivity.hideKeyboard()
        super.onPause()
    }
}