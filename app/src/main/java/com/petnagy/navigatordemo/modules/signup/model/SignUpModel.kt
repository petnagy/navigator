package com.petnagy.navigatordemo.modules.signup.model

import com.petnagy.navigatordemo.service.PreferenceService

class SignUpModel(private val preferenceService: PreferenceService) {

    fun saveEmail(email: String) {
        preferenceService.saveEmail(email)
    }
}