package com.petnagy.navigatordemo.di.modules

import com.petnagy.navigatordemo.modules.onboarding.viewmodel.OnboardingViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class OnboardingModule {

    @Provides
    fun provideViewModelFactory() = OnboardingViewModelFactory()
}