package com.petnagy.navigatordemo.nav

import android.content.Context
import android.content.Intent
import com.petnagy.navigatordemo.modules.dashboard.DashboardActivity
import com.petnagy.navigatordemo.modules.dashboarddata.DashboardDataActivity
import com.petnagy.navigatordemo.modules.listdetail.ListDetailActivity
import com.petnagy.navigatordemo.modules.login.LoginActivity
import com.petnagy.navigatordemo.modules.onboarding.OnboardingActivity
import com.petnagy.navigatordemo.modules.signup.SignUpActivity
import com.petnagy.navigatordemo.modules.userdata.UserDataActivity

fun goToLogin(context: Context) = Intent(context, LoginActivity::class.java)

fun goToSignUp(context: Context) = Intent(context, SignUpActivity::class.java)

fun goToDashBoard(context: Context) = Intent(context, DashboardActivity::class.java)

fun goToDashboardData(context: Context) = Intent(context, DashboardDataActivity::class.java)

fun goToUserData(context: Context) = Intent(context, UserDataActivity::class.java)

fun goToListDetail(context: Context, value: String) = Intent(context, ListDetailActivity::class.java).apply {
    putExtra(ListDetailActivity.CARD_VIEW_DATA, value)
}

fun goToOnboarding(context: Context) = Intent(context, OnboardingActivity::class.java)