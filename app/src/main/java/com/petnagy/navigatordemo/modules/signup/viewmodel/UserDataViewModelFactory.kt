package com.petnagy.navigatordemo.modules.signup.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.petnagy.navigatordemo.modules.signup.model.UserDataModel

class UserDataViewModelFactory(private val model: UserDataModel) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserDataViewModel::class.java)) {
            return UserDataViewModel(model) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}