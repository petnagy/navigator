package com.petnagy.navigatordemo.modules.signup.viewmodel

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.petnagy.navigatordemo.event.AppEvents
import com.petnagy.navigatordemo.event.Event
import com.petnagy.navigatordemo.modules.signup.model.UserDataModel
import timber.log.Timber

class UserDataViewModel(private val model: UserDataModel) : ViewModel() {

    companion object {
        const val DEFAULT_USER_DATA = "Unknown user data"
    }

    val userDataEvent = MutableLiveData<Event<AppEvents>>()
    val userData = MutableLiveData<String>(DEFAULT_USER_DATA)

    fun onUserDataRequestClicked(view: View) {
        Timber.d("Request User data")
        userDataEvent.value = Event(AppEvents.REQUEST_USER_DATA)
    }

    fun onNextClicked(view: View) {
        Timber.d("Next Page pressed")
        model.saveUserData(userData.value ?: DEFAULT_USER_DATA)
        userDataEvent.value = Event(AppEvents.FINISH_USER_DATA)
    }

}