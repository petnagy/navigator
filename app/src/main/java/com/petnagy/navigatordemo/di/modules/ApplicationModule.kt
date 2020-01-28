package com.petnagy.navigatordemo.di.modules

import android.content.Context
import com.petnagy.navigatordemo.ProjectApplication
import com.petnagy.navigatordemo.di.AppContext
import com.petnagy.navigatordemo.service.PreferenceService
import com.petnagy.navigatordemo.service.SharedPreferenceService
import dagger.Module
import dagger.Provides

@Module
class  ApplicationModule {

    @Provides
    @AppContext
    internal fun provideContext(application: ProjectApplication): Context = application.applicationContext

    @Provides
    fun providePreferenceService(@AppContext context: Context): PreferenceService = SharedPreferenceService(context)
}