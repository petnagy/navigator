package com.petnagy.navigatordemo.modules.onboarding.viewmodel

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.petnagy.navigatordemo.event.AppEvents
import com.petnagy.navigatordemo.event.Event
import timber.log.Timber

class OnboardingViewModel : ViewModel() {

    val userEvent: MutableLiveData<Event<AppEvents>> = MutableLiveData()

    fun onLoginClicked(view: View) {
        Timber.d("Login pressed")
        userEvent.value = Event(AppEvents.LOGIN_PRESSED)
    }

    fun onSingUpClicked(view: View) {
        Timber.d("Signup pressed")
        userEvent.value = Event(AppEvents.SIGN_UP_PRESSED)
    }
}