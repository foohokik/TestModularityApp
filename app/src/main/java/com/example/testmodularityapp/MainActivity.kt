package com.example.testmodularityapp

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.search_feature_api.SearchFeatureApi
import com.example.testmodularityapp.databinding.ActivityMainBinding
import com.example.core_utils.presentation.ui.BaseActivity
import com.example.favorite_feature_api.FavoriteApi
import com.example.full_vacancy_feature_api.FullVacancyApi
import com.example.testmodularityapp.di.AppComponent
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var searchFeature: SearchFeatureApi

    @Inject
    lateinit var detailFeature: FullVacancyApi

    @Inject
    lateinit var favoriteFeature: FavoriteApi

    private val navController: NavController by lazy { findNavController(R.id.nav_host_fragment) }


    private lateinit var _binding: ActivityMainBinding
    private val binding
        get() = _binding

    init {
        AppComponent.get().inject(this)
    }

//    private lateinit var controller: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MYLOG", "activity ")
        _binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        Log.d("MYLOG", "oncreate activity")

    }

    override fun onStart() {
        super.onStart()
        initBottomNavView()
    }


    private fun initBottomNavView() {
//        controller = this.findNavController(R.id.nav_host_fragment)
        val navView = binding.bottomNavView
        navView.setupWithNavController(navController)

//        navController.addOnDestinationChangedListener { _, destination, _ ->
//            when (destination.id) {
//                R.id.searchFragment -> navView.visibility = View.VISIBLE
//                else -> navView.visibility = View.GONE
//            }
//        }
//        navView.setOnItemSelectedListener {
//                item ->
//            when (item.itemId) {
//                R.id.searchFragment -> openSearch()
//                else -> openSearch()
//            }
//            true
//        }
    }

    private fun openSearch() {
//       controller.navigate("app://search".toUri())

//        searchFeature
//            .searchLauncher()
//            .startSearchFragment(controller, "app://search".toUri())
    }

}