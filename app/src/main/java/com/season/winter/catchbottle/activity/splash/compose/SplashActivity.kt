package com.season.winter.catchbottle.activity.splash.compose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@SuppressLint("CustomSplashScreen")
class SplashActivity : ComponentActivity() {

//    private val viewModel: SplashViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)

//        viewModel.checkLaunchTargetActivity()
//        repeatOnLifecycle(viewModel.onLaunchActivityFlow) { activity ->
//            cbStartActivity(activity, true)
//        }
    }
}