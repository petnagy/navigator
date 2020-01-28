package com.petnagy.navigatordemo.di.components

import com.petnagy.navigatordemo.ProjectApplication
import com.petnagy.navigatordemo.di.modules.ActivityModule
import com.petnagy.navigatordemo.di.modules.ApplicationModule
import com.petnagy.navigatordemo.di.modules.FragmentModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(AndroidSupportInjectionModule::class), (ApplicationModule::class), (ActivityModule::class), (FragmentModule::class)])
interface ApplicationComponent : AndroidInjector<ProjectApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<ProjectApplication>()
}