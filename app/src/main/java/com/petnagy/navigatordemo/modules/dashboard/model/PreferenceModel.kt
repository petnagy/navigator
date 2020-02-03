package com.petnagy.navigatordemo.modules.dashboard.model

import com.petnagy.navigatordemo.service.PreferenceService

class PreferenceModel(private val preferenceService: PreferenceService) {

    fun loadEmail() = preferenceService.loadEmail()

    fun loadUserData() = preferenceService.loadUserData()

    fun clearUsersData() = preferenceService.clearAll()

    fun saveUserData(userData: String) = preferenceService.saveUserData(userData)
}