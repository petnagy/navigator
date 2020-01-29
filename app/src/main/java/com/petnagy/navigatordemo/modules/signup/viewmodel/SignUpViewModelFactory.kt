package com.petnagy.navigatordemo.modules.signup.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.petnagy.navigatordemo.modules.signup.model.SignUpModel

class SignUpViewModelFactory(private val signUpModel: SignUpModel) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SignUpViewModel::class.java)) {
            return SignUpViewModel(signUpModel) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}