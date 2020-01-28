package com.petnagy.navigatordemo.modules.dashboard

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.petnagy.navigatordemo.R
import com.petnagy.navigatordemo.modules.userdata.UserDataActivity
import com.petnagy.navigatordemo.nav.goToOnboarding
import com.petnagy.navigatordemo.nav.goToUserData
import com.petnagy.navigatordemo.service.PreferenceService
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_preference.*
import timber.log.Timber
import javax.inject.Inject

class PreferenceFragment : DaggerFragment() {

    @Inject
    lateinit var preferenceService: PreferenceService

    companion object {
        fun newInstance() = PreferenceFragment()

        private const val USER_DATA_REQUEST_CODE = 235
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_preference, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pref_email.text = preferenceService.loadEmail()
        pref_userdata.text = preferenceService.loadUserData()

        pref_add_user_data_button.setOnClickListener {
            context?.let {
                val intent = goToUserData(it)
                startActivityForResult(intent, USER_DATA_REQUEST_CODE)
            }
        }

        pref_logout.setOnClickListener {
            preferenceService.clearAll()
            context?.let {
                val intent = goToOnboarding(it)
                activity?.startActivity(intent)
                activity?.finish()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Timber.d("on activity result")
        if (requestCode == USER_DATA_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            data?.let {
                Timber.d("There is intent: $it")
                val userData = it.getStringExtra(UserDataActivity.USER_NAME_TEXT) ?: ""
                pref_userdata.text = userData
                preferenceService.saveUserData(userData)
            }
        }
    }
}