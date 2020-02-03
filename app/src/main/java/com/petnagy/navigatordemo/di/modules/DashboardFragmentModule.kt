package com.petnagy.navigatordemo.di.modules

import com.petnagy.navigatordemo.modules.dashboard.viewmodel.DashboardViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class DashboardFragmentModule {

    @Provides
    fun provideViewModelFactory() = DashboardViewModelFactory()
}