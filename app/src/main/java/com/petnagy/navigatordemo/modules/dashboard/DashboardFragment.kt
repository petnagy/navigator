package com.petnagy.navigatordemo.modules.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.petnagy.navigatordemo.R
import com.petnagy.navigatordemo.databinding.FragmentDashboardBinding
import com.petnagy.navigatordemo.event.AppEvents
import com.petnagy.navigatordemo.modules.dashboard.viewmodel.DashboardViewModel
import com.petnagy.navigatordemo.modules.dashboard.viewmodel.DashboardViewModelFactory
import com.petnagy.navigatordemo.nav.goToDashboardData
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class DashboardFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: DashboardViewModelFactory

    private lateinit var viewModel: DashboardViewModel

    companion object {
        fun newInstance() = DashboardFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory).get(DashboardViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentDashboardBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_dashboard, container, false)
        val view = binding.root
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.dashboardEvent.observe(viewLifecycleOwner, Observer { event ->
            event.getContentIfNotHandled()?.let {
                when(it) {
                    AppEvents.DASHBOARD_DATA -> launchDashboardData()
                    else -> {
                        // do not implement
                    }
                }
            }
        })
    }

    private fun launchDashboardData() {
        context?.let {
            val intent = goToDashboardData(it)
            activity?.startActivity(intent)
        }
    }
}