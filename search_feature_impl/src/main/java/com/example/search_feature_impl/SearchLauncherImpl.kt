package com.example.search_feature_impl

import android.net.Uri
import androidx.navigation.NavController
import com.example.core_utils.di.Feature
import com.example.search_feature_api.SearchLauncher
import javax.inject.Inject

@Feature
class SearchLauncherImpl @Inject constructor() :SearchLauncher {

    override fun startSearchFragment(navController: NavController, deepLink: Uri) {
        navController.navigate(deepLink)
    }

}