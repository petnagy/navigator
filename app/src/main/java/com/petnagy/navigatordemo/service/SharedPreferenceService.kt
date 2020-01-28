package com.petnagy.navigatordemo.service

import android.app.Activity
import android.content.Context
import androidx.core.content.edit

class SharedPreferenceService(private val context: Context) : PreferenceService {

    companion object {
        private const val PREFERENCE_NAME = "demoPreference"
        private const val EMAIL = "email"
        private const val USER_DATA = "userData"
    }

    override fun saveEmail(email: String) {
        getSharedPreference().edit {
            putString(EMAIL, email)
        }
    }

    override fun loadEmail(): String = getSharedPreference().getString(EMAIL, "") ?: ""

    override fun clearAll() {
        getSharedPreference().edit {
            clear()
        }
    }

    override fun saveUserData(userData: String) {
        getSharedPreference().edit {
            putString(USER_DATA, userData)
        }
    }

    override fun loadUserData(): String = getSharedPreference().getString(USER_DATA, "") ?: ""

    private fun getSharedPreference() = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
}