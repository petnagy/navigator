package com.petnagy.navigatordemo.modules.login.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.petnagy.navigatordemo.modules.login.model.LoginModel

class LoginViewModelFactory(private val loginModel: LoginModel) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(loginModel) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}