package com.petnagy.navigatordemo.modules.dashboard.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.petnagy.navigatordemo.modules.dashboard.model.PreferenceModel

class PreferenceViewModelFactory(private val preferenceModel: PreferenceModel) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PreferenceViewModel::class.java)) {
            return PreferenceViewModel(preferenceModel) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}