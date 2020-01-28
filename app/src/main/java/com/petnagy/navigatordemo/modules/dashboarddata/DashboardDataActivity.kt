package com.petnagy.navigatordemo.modules.dashboarddata

import android.os.Bundle
import com.petnagy.navigatordemo.R
import dagger.android.support.DaggerAppCompatActivity

class DashboardDataActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboarddata)
    }

}