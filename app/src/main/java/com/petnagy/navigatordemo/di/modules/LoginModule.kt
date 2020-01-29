package com.petnagy.navigatordemo.di.modules

import com.petnagy.navigatordemo.modules.login.model.LoginModel
import com.petnagy.navigatordemo.modules.login.viewmodel.LoginViewModelFactory
import com.petnagy.navigatordemo.service.PreferenceService
import dagger.Module
import dagger.Provides

@Module
class LoginModule {
    @Provides
    fun provideLoginModel(preferenceService: PreferenceService) =
        LoginModel(preferenceService)

    @Provides
    fun provideViewModelFactory(loginModel: LoginModel) = LoginViewModelFactory(loginModel)
}