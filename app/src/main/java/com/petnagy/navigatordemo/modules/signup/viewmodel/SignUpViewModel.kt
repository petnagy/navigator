package com.petnagy.navigatordemo.modules.signup.viewmodel

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.petnagy.navigatordemo.event.AppEvents
import com.petnagy.navigatordemo.event.Event
import com.petnagy.navigatordemo.modules.signup.model.SignUpModel
import timber.log.Timber

class SignUpViewModel(private val model: SignUpModel) : ViewModel() {

    val signUpEvent = MutableLiveData<Event<AppEvents>>()
    val email = MutableLiveData<String>("")
    val signUpButtonEnabled = MutableLiveData<Boolean>(false)

    val emailTextWatcher = object : TextWatcher {
        override fun afterTextChanged(text: Editable?) {
            text?.let {
                signUpButtonEnabled.value = it.isNotEmpty()
            }
        }

        override fun beforeTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {
            // do not implement
        }

        override fun onTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {
            // do not implement
        }
    }

    fun onSignUpClicked(view: View) {
        Timber.d("Sing up pressed")
        model.saveEmail(email.value ?: "")
        signUpEvent.value = Event(AppEvents.SIGN_UP_PRESSED)
    }
}