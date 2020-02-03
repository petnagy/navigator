package com.petnagy.navigatordemo.di.modules

import com.petnagy.navigatordemo.modules.dashboard.viewmodel.ListViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ListFragmentModule {

    @Provides
    fun provideViewModelFactory() = ListViewModelFactory()
}