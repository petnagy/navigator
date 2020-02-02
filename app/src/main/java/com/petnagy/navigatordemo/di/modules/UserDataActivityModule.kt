package com.petnagy.navigatordemo.di.modules

import com.petnagy.navigatordemo.modules.userdata.viewmodel.UserUserDataViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class UserDataActivityModule {

    @Provides
    fun provideViewModelFactory() = UserUserDataViewModelFactory()
}