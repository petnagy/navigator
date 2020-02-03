package com.petnagy.navigatordemo.modules.dashboard.viewmodel

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.petnagy.navigatordemo.event.AppEvents
import com.petnagy.navigatordemo.event.Event
import com.petnagy.navigatordemo.modules.dashboard.model.PreferenceModel
import timber.log.Timber

class PreferenceViewModel(private val model: PreferenceModel) : ViewModel() {

    val email = MutableLiveData<String>(model.loadEmail())
    val userdata = MutableLiveData<String>(model.loadUserData())
    val preferenceEvent = MutableLiveData<Event<AppEvents>>()

    fun onUserDataClicked(view: View) {
        Timber.d("on User data clicked")
        preferenceEvent.value = Event(AppEvents.REQUEST_USER_DATA)
    }

    fun onLogoutClicked(view: View) {
        Timber.d("on Logout clicked")
        model.clearUsersData()
        preferenceEvent.value = Event(AppEvents.LOGOUT_PRESSED)
    }

    fun saveUserData(userData: String) {
        this.userdata.value = userData
        model.saveUserData(userData)
    }
}