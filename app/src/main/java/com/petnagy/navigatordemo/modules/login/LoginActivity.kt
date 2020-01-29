package com.petnagy.navigatordemo.modules.login

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.petnagy.navigatordemo.R
import com.petnagy.navigatordemo.databinding.ActivityLoginBinding
import com.petnagy.navigatordemo.event.AppEvents
import com.petnagy.navigatordemo.modules.login.viewmodel.LoginViewModel
import com.petnagy.navigatordemo.modules.login.viewmodel.LoginViewModelFactory
import com.petnagy.navigatordemo.nav.goToDashBoard
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class LoginActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: LoginViewModelFactory

    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory).get(LoginViewModel::class.java)
        val binding: ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.loginEvent.observe(this, Observer { event ->
            event.getContentIfNotHandled()?.let {
                when(it) {
                    AppEvents.LOGIN_PRESSED -> startLogin()
                    else -> {
                        // do nothing
                    }
                }
            }
        })
    }

    private fun startLogin() {
        val intent = goToDashBoard(this)
        startActivity(intent)
        finish()
    }
}