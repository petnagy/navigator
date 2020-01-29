package com.petnagy.navigatordemo.modules.signup

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
import com.petnagy.navigatordemo.databinding.FragmentUserdataBinding
import com.petnagy.navigatordemo.event.AppEvents
import com.petnagy.navigatordemo.modules.signup.viewmodel.UserDataViewModel
import com.petnagy.navigatordemo.modules.signup.viewmodel.UserDataViewModelFactory
import com.petnagy.navigatordemo.modules.userdata.UserDataActivity
import com.petnagy.navigatordemo.nav.goToDashBoard
import com.petnagy.navigatordemo.nav.goToUserData
import dagger.android.support.DaggerFragment
import timber.log.Timber
import javax.inject.Inject

class UserDataFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: UserDataViewModelFactory

    private lateinit var viewModel: UserDataViewModel

    companion object {
        private const val USER_DATA_REQUEST_CODE = 123
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory).get(UserDataViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentUserdataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_userdata, container, false)
        val view = binding.root
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.userDataEvent.observe(viewLifecycleOwner, Observer { event ->
            event.getContentIfNotHandled()?.let {
                when (it) {
                    AppEvents.REQUEST_USER_DATA -> requestUserData()
                    AppEvents.FINISH_USER_DATA -> goNextScreen()
                    else -> {
                        // do not implement
                    }
                }
            }
        })
    }

    private fun requestUserData() {
        context?.let {
            val intent = goToUserData(it)
            startActivityForResult(intent, USER_DATA_REQUEST_CODE)
        }
    }

    private fun goNextScreen() {
        context?.let {
            val intent = goToDashBoard(it)
            activity?.startActivity(intent)
            activity?.finish()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Timber.d("on activity result")
        if (requestCode == USER_DATA_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            data?.let {
                Timber.d("There is intent: $it")
                viewModel.userData.value = it.getStringExtra(UserDataActivity.USER_NAME_TEXT) ?: UserDataViewModel.DEFAULT_USER_DATA
            }
        }
    }

}