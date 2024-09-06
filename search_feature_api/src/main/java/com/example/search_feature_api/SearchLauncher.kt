package com.example.search_feature_api

import android.net.Uri
import androidx.navigation.NavController

interface SearchLauncher {
    fun startSearchFragment (navController : NavController, deepLink: Uri)
}