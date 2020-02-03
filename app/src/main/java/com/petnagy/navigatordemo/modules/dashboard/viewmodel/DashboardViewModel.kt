package com.petnagy.navigatordemo.modules.dashboard.viewmodel

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.petnagy.navigatordemo.event.AppEvents
import com.petnagy.navigatordemo.event.Event
import timber.log.Timber

class DashboardViewModel : ViewModel() {

    val dashboardEvent = MutableLiveData<Event<AppEvents>>()

    fun onDataClicked(view: View) {
        Timber.d("on Data Clicked")
        dashboardEvent.value = Event(AppEvents.DASHBOARD_DATA)
    }

}