package com.petnagy.navigatordemo.modules.onboarding

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.petnagy.navigatordemo.R
import com.petnagy.navigatordemo.databinding.ActivityOnboardingBinding
import com.petnagy.navigatordemo.event.AppEvents
import com.petnagy.navigatordemo.modules.onboarding.viewmodel.OnboardingViewModel
import com.petnagy.navigatordemo.modules.onboarding.viewmodel.OnboardingViewModelFactory
import com.petnagy.navigatordemo.nav.goToLogin
import com.petnagy.navigatordemo.nav.goToSignUp
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class OnboardingActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: OnboardingViewModelFactory

    private lateinit var viewModel: OnboardingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory).get(OnboardingViewModel::class.java)
        val binding: ActivityOnboardingBinding = DataBindingUtil.setContentView(this, R.layout.activity_onboarding)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.userEvent.observe(this, Observer { event ->
            event.getContentIfNotHandled()?.let {
                when(it) {
                    AppEvents.LOGIN_PRESSED -> startLogin()
                    AppEvents.SIGN_UP_PRESSED -> startSignUp()
                }
            }
        })
    }

    private fun startLogin() {
        val intent = goToLogin(this)
        startActivity(intent)
        finish()
    }

    private fun startSignUp() {
        val intent = goToSignUp(this)
        startActivity(intent)
        finish()
    }
}