package com.petnagy.navigatordemo.di.modules

import com.petnagy.navigatordemo.modules.dashboard.model.PreferenceModel
import com.petnagy.navigatordemo.modules.dashboard.viewmodel.PreferenceViewModelFactory
import com.petnagy.navigatordemo.service.PreferenceService
import dagger.Module
import dagger.Provides

@Module
class PreferenceFragmentModule {

    @Provides
    fun providePreferenceModel(preferenceService: PreferenceService) = PreferenceModel(preferenceService)

    @Provides
    fun provideViewModelFactory(preferenceModel: PreferenceModel) = PreferenceViewModelFactory(preferenceModel)

}