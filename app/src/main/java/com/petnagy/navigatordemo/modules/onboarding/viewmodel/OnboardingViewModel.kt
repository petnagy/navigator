package com.petnagy.navigatordemo.modules.onboarding.viewmodel

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.petnagy.navigatordemo.event.Event
import com.petnagy.navigatordemo.event.OnboardingEvent
import timber.log.Timber

class OnboardingViewModel : ViewModel() {

    val userEvent: MutableLiveData<Event<OnboardingEvent>> = MutableLiveData()

    fun onLoginClicked(view: View) {
        Timber.d("Login pressed")
        userEvent.value = Event(OnboardingEvent.LOGIN)
    }

    fun onSingUpClicked(view: View) {
        Timber.d("Signup pressed")
        userEvent.value = Event(OnboardingEvent.SIGNUP)
    }
}