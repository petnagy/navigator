package com.petnagy.navigatordemo.modules.userdata.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class UserUserDataViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserUserDataViewModel::class.java)) {
            return UserUserDataViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}