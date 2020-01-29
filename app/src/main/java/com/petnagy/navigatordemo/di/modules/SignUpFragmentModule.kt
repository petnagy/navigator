package com.petnagy.navigatordemo.di.modules

import com.petnagy.navigatordemo.modules.signup.model.SignUpModel
import com.petnagy.navigatordemo.modules.signup.viewmodel.SignUpViewModelFactory
import com.petnagy.navigatordemo.service.PreferenceService
import dagger.Module
import dagger.Provides

@Module
class SignUpFragmentModule {
    @Provides
    fun provideSignUpModel(preferenceService: PreferenceService) = SignUpModel(preferenceService)

    @Provides
    fun provideViewModelFactory(signUpModel: SignUpModel) = SignUpViewModelFactory(signUpModel)
}