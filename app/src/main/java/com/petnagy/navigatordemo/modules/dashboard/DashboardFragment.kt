package com.petnagy.navigatordemo.modules.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.petnagy.navigatordemo.R
import com.petnagy.navigatordemo.nav.goToDashboardData
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_dashboard.*
import timber.log.Timber

class DashboardFragment : DaggerFragment() {

    companion object {
        fun newInstance() = DashboardFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dashboard_data_button.setOnClickListener {
            Timber.d("Go to next screen from Dashboard")
            context?.let {
                val intent = goToDashboardData(it)
                activity?.startActivity(intent)
            }
        }
    }

}