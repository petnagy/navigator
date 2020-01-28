package com.petnagy.navigatordemo.modules.login

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.petnagy.navigatordemo.R
import com.petnagy.navigatordemo.nav.goToDashBoard
import com.petnagy.navigatordemo.service.PreferenceService
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*
import timber.log.Timber
import javax.inject.Inject

class LoginActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var preferenceService: PreferenceService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        email_text.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(text: Editable?) {
                text?.let {
                    login_button.isEnabled = it.isNotEmpty()
                }
            }

            override fun beforeTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {
                // do not implement
            }

            override fun onTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {
                // do not implement
            }

        })

        login_button.setOnClickListener {
            Timber.d("Login pressed")
            preferenceService.saveEmail(email_text.text.toString())
            val intent = goToDashBoard(this)
            startActivity(intent)
            finish()
        }
    }

}