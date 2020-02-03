package com.petnagy.navigatordemo.modules.dashboard

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.petnagy.navigatordemo.R
import com.petnagy.navigatordemo.databinding.FragmentPreferenceBinding
import com.petnagy.navigatordemo.event.AppEvents
import com.petnagy.navigatordemo.modules.dashboard.viewmodel.PreferenceViewModel
import com.petnagy.navigatordemo.modules.dashboard.viewmodel.PreferenceViewModelFactory
import com.petnagy.navigatordemo.modules.userdata.UserDataActivity
import com.petnagy.navigatordemo.nav.goToOnboarding
import com.petnagy.navigatordemo.nav.goToUserData
import dagger.android.support.DaggerFragment
import timber.log.Timber
import javax.inject.Inject

class PreferenceFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: PreferenceViewModelFactory

    private lateinit var viewModel: PreferenceViewModel

    companion object {
        fun newInstance() = PreferenceFragment()

        private const val USER_DATA_REQUEST_CODE = 235
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory).get(PreferenceViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentPreferenceBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_preference, container, false)
        val view = binding.root
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.preferenceEvent.observe(viewLifecycleOwner, Observer { event ->
            event.getContentIfNotHandled()?.let {
                when(it) {
                    AppEvents.REQUEST_USER_DATA -> requestUserData()
                    AppEvents.LOGOUT_PRESSED -> logout()
                    else -> {
                        // do not implemented
                    }
                }
            }
        })
    }

    private fun logout() {
        context?.let {
            val intent = goToOnboarding(it)
            activity?.startActivity(intent)
            activity?.finish()
        }
    }

    private fun requestUserData() {
        context?.let {
            val intent = goToUserData(it)
            startActivityForResult(intent, USER_DATA_REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Timber.d("on activity result")
        if (requestCode == USER_DATA_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            data?.let {
                Timber.d("There is intent: $it")
                val userData = it.getStringExtra(UserDataActivity.USER_NAME_TEXT) ?: ""
                viewModel.saveUserData(userData)
            }
        }
    }
}