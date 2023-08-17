package com.season.winter.catchbottle.activity.main

import android.util.Log
import androidx.activity.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.season.winter.catchbottle.R
import com.season.winter.catchbottle.activity.login.LoginActivity
import com.season.winter.catchbottle.activity.search.SearchActivity
import com.season.winter.catchbottle.databinding.ActivityMainBinding
import com.season.winter.common.activity.BaseActivity
import com.season.winter.common.extention.activity.cbStartActivity
import com.season.winter.common.extention.coroutine.repeatOnLifecycle
import com.season.winter.main_navigation_contents.viewmodels.MainNavigationViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity: BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val viewModel: MainNavigationViewModel by viewModels()

    override fun ActivityMainBinding.initView() {
        repeatOnLifecycle(viewModel.onLogoutListener) {
            if (it) {
                cbStartActivity(LoginActivity::class.java, true)
            }
        }
        repeatOnLifecycle(viewModel.onClickSearchListener) {
            if (it) {
                cbStartActivity(SearchActivity::class.java, false)
            }
        }
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_host) as NavHostFragment
        val navController = navHostFragment.findNavController()
        bottomNavigation.setupWithNavController(navController)
    }

    companion object {

        private const val TAG = "MainActivity"
    }

}