package com.petnagy.navigatordemo.di.modules

import com.petnagy.navigatordemo.modules.signup.model.UserDataModel
import com.petnagy.navigatordemo.modules.signup.viewmodel.UserDataViewModelFactory
import com.petnagy.navigatordemo.service.PreferenceService
import dagger.Module
import dagger.Provides

@Module
class UserDataFragmentModule {
    @Provides
    fun provideUserDataModel(preferenceService: PreferenceService) = UserDataModel(preferenceService)

    @Provides
    fun provideViewModelFactory(userDataModel: UserDataModel) = UserDataViewModelFactory(userDataModel)
}