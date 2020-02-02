package com.petnagy.navigatordemo.modules.userdata.viewmodel

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.petnagy.navigatordemo.event.AppEvents
import com.petnagy.navigatordemo.event.Event
import timber.log.Timber

class UserUserDataViewModel : ViewModel() {

    val userDataEvent = MutableLiveData<Event<AppEvents>>()
    val userData = MutableLiveData<String>("")

    fun addUserData(view: View) {
        Timber.d("Add User data pressed")
        userDataEvent.value = Event(AppEvents.ADDED_USER_DATA)
    }
}