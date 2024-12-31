package dev.love.winter.catchbottle.activity.splash

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@SuppressLint("CustomSplashScreen")
class SplashActivity: AppCompatActivity() {

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