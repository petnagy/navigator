package com.petnagy.navigatordemo.modules.signup.model

import com.petnagy.navigatordemo.service.PreferenceService

class UserDataModel(private val preferenceService: PreferenceService) {

    fun saveUserData(userData: String) {
        preferenceService.saveUserData(userData)
    }
}