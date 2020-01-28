package com.petnagy.navigatordemo.modules.signup

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.petnagy.navigatordemo.R
import com.petnagy.navigatordemo.modules.userdata.UserDataActivity
import com.petnagy.navigatordemo.nav.goToDashBoard
import com.petnagy.navigatordemo.nav.goToUserData
import com.petnagy.navigatordemo.service.PreferenceService
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_userdata.*
import timber.log.Timber
import javax.inject.Inject

class UserDataFragment : DaggerFragment() {

    @Inject
    lateinit var preferenceService: PreferenceService

    companion object {
        private const val USER_DATA_REQUEST_CODE = 123
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_userdata, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userdata_button.setOnClickListener {
            context?.let {
                val intent = goToUserData(it)
                startActivityForResult(intent, USER_DATA_REQUEST_CODE)
            }
        }

        userdata_next_button.setOnClickListener {
            context?.let {
                preferenceService.saveUserData(userdata.text.toString())
                val intent = goToDashBoard(it)
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
                userdata.text = it.getStringExtra(UserDataActivity.USER_NAME_TEXT) ?: ""
            }
        }
    }

}