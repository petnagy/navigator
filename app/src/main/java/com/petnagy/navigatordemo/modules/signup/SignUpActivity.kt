package com.petnagy.navigatordemo.modules.signup

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.petnagy.navigatordemo.R
import dagger.android.support.DaggerAppCompatActivity

class SignUpActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        openFragment(SignupFragment())
    }

    fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.signup_container, fragment)
        transaction.commit()
    }
}