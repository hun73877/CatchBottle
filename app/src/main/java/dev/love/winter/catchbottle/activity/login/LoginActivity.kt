//package com.season.winter.catchbottle.activity.login
//
//import android.os.Bundle
//import androidx.activity.viewModels
//import androidx.appcompat.app.AppCompatActivity
//import com.season.winter.catchbottle.activity.main.MainActivity
//import com.season.winter.catchbottle.databinding.ActivityLoginBinding
//import com.season.winter.common.extention.activity.cbStartActivity
//import com.season.winter.common.extention.coroutine.repeatOnLifecycle
//import com.season.winter.feature.login.LoginViewModel
//import dagger.hilt.android.AndroidEntryPoint
//
//@AndroidEntryPoint
//class LoginActivity: AppCompatActivity() {
//
//    private val viewModel: LoginViewModel by viewModels()
//
//    lateinit var binding: ActivityLoginBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityLoginBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        repeatOnLifecycle(viewModel.onSavedUserNameFlow) { isSaved ->
//            if(isSaved)
//                cbStartActivity(MainActivity::class.java, true)
//        }
//        binding.loginButton.setOnClickListener {
//            binding.nameEditText.text.toString().run {
//                if (isNotEmpty())
//                    viewModel.login(this)
//            }
//        }
//    }
//}