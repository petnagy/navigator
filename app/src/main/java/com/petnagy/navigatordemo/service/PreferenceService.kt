package com.petnagy.navigatordemo.service

interface PreferenceService {

    fun saveEmail(email: String)

    fun loadEmail(): String

    fun clearAll()

    fun saveUserData(userData: String)

    fun loadUserData(): String
}