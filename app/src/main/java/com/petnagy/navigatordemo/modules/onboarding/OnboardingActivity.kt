package com.petnagy.navigatordemo.modules.onboarding

import android.os.Bundle
import com.petnagy.navigatordemo.R
import com.petnagy.navigatordemo.nav.goToLogin
import com.petnagy.navigatordemo.nav.goToSignUp
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_onboarding.*
import timber.log.Timber

class OnboardingActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        onboarding_login_button.setOnClickListener {
            Timber.d("Login button pressed")
            val intent = goToLogin(this)
            startActivity(intent)
            finish()
        }

        onboarding_signup_button.setOnClickListener {
            Timber.d("Signup button pressed")
            val intent = goToSignUp(this)
            startActivity(intent)
            finish()
        }
    }

}