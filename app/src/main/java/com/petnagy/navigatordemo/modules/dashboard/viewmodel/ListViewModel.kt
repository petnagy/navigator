package com.petnagy.navigatordemo.modules.dashboard.viewmodel

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.petnagy.navigatordemo.event.AppEvents
import com.petnagy.navigatordemo.event.Event
import timber.log.Timber

class ListViewModel : ViewModel() {

    val listEvent = MutableLiveData<Event<AppEvents>>()

    fun onCard1Clicked(view: View) {
        Timber.d("on Card1 clicked")
        listEvent.value = Event(AppEvents.LIST_ITEM_CARD_1)
    }

    fun onCard2Clicked(view: View) {
        Timber.d("on Card2 clicked")
        listEvent.value = Event(AppEvents.LIST_ITEM_CARD_2)
    }
}