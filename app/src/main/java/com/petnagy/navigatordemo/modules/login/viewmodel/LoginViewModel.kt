package com.petnagy.navigatordemo.modules.login.viewmodel

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.petnagy.navigatordemo.event.AppEvents
import com.petnagy.navigatordemo.event.Event
import com.petnagy.navigatordemo.modules.login.LoginModel
import timber.log.Timber

class LoginViewModel(private val loginModel: LoginModel) : ViewModel() {

    val loginEvent = MutableLiveData<Event<AppEvents>>()
    val loginButtonEnabled = MutableLiveData<Boolean>(false)
    val email = MutableLiveData<String>("")

    val emailTextWatcher = object : TextWatcher {
        override fun afterTextChanged(text: Editable?) {
            text?.let {
                loginButtonEnabled.value = it.isNotEmpty()
            }
        }

        override fun beforeTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {
            // do not implement
        }

        override fun onTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {
            // do not implement
        }
    }

    fun onLoginClicked(view: View) {
        Timber.d("Login pressed")
        loginModel.saveEmail(email.value ?: "")
        loginEvent.value = Event(AppEvents.LOGIN_PRESSED)
    }
}