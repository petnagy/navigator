package com.petnagy.navigatordemo.modules.login.model

import com.petnagy.navigatordemo.service.PreferenceService

class LoginModel(private val preferenceService: PreferenceService) {

    fun saveEmail(email: String) {
        preferenceService.saveEmail(email)
    }
}