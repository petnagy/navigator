package com.petnagy.navigatordemo.di.modules

import com.petnagy.navigatordemo.di.PerActivity
import com.petnagy.navigatordemo.modules.dashboard.DashboardActivity
import com.petnagy.navigatordemo.modules.dashboarddata.DashboardDataActivity
import com.petnagy.navigatordemo.modules.listdetail.ListDetailActivity
import com.petnagy.navigatordemo.modules.login.LoginActivity
import com.petnagy.navigatordemo.modules.onboarding.OnboardingActivity
import com.petnagy.navigatordemo.modules.signup.SignUpActivity
import com.petnagy.navigatordemo.modules.userdata.UserDataActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityModule {

    @PerActivity
    @ContributesAndroidInjector (modules = [(OnboardingModule::class)])
    fun contributeOnboardingActivity(): OnboardingActivity

    @PerActivity
    @ContributesAndroidInjector //(modules = [(MainActivityModule::class)])
    fun contributeLoginActivity(): LoginActivity

    @PerActivity
    @ContributesAndroidInjector //(modules = [(MainActivityModule::class)])
    fun contributeSingUpActivity(): SignUpActivity

    @PerActivity
    @ContributesAndroidInjector //(modules = [(MainActivityModule::class)])
    fun contributeDashboardActivity(): DashboardActivity

    @PerActivity
    @ContributesAndroidInjector //(modules = [(MainActivityModule::class)])
    fun contributeDashboardData(): DashboardDataActivity

    @PerActivity
    @ContributesAndroidInjector //(modules = [(MainActivityModule::class)])
    fun contributeUserDataActivity(): UserDataActivity

    @PerActivity
    @ContributesAndroidInjector //(modules = [(MainActivityModule::class)])
    fun contributeListDetailActivity(): ListDetailActivity
}