package com.season.winter.catchbottle.activity.main

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.season.winter.catchbottle.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity: AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        repeatOnLifecycle(viewModel.onLogoutListener) {
//            if (it) {
//                cbStartActivity(LoginActivity::class.java, true)
//            }
//        }
    }

    companion object {

        private const val TAG = "MainActivity"
    }
}