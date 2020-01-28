package com.petnagy.navigatordemo.modules.signup

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.petnagy.navigatordemo.R
import com.petnagy.navigatordemo.service.PreferenceService
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_signup.*
import timber.log.Timber
import javax.inject.Inject

class SignupFragment : DaggerFragment() {

    @Inject
    lateinit var preferenceService: PreferenceService

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_signup, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        signup_email_text.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(text: Editable?) {
                text?.let {
                    signup_button.isEnabled = it.isNotEmpty()
                }
            }

            override fun beforeTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {
                // do not implement
            }

            override fun onTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {
                // do not implement
            }

        })

        signup_button.setOnClickListener {
            Timber.d("Singup pressed")
            preferenceService.saveEmail(signup_email_text.text.toString())
            val activity = activity as SignUpActivity
            activity.openFragment(UserDataFragment())
        }
    }
}