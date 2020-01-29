package com.petnagy.navigatordemo.di.modules

import com.petnagy.navigatordemo.modules.dashboard.DashboardFragment
import com.petnagy.navigatordemo.modules.dashboard.ListFragment
import com.petnagy.navigatordemo.modules.dashboard.PreferenceFragment
import com.petnagy.navigatordemo.modules.signup.SignupFragment
import com.petnagy.navigatordemo.modules.signup.UserDataFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface FragmentModule {

    @ContributesAndroidInjector //(modules = [(MainActivityModule::class)])
    fun contributeDashboardFragment(): DashboardFragment

    @ContributesAndroidInjector //(modules = [(HistoryFragmentModule::class)])
    fun contributeListFragment(): ListFragment

    @ContributesAndroidInjector //(modules = [(HistoryFragmentModule::class)])
    fun contributePreferenceFragment(): PreferenceFragment

    @ContributesAndroidInjector(modules = [(SignUpFragmentModule::class)])
    fun contributeSignupFragment(): SignupFragment

    @ContributesAndroidInjector(modules = [(UserDataFragmentModule::class)])
    fun contributeUserDataFragment(): UserDataFragment
}