package com.petnagy.navigatordemo.modules.userdata

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.petnagy.navigatordemo.R
import com.petnagy.navigatordemo.databinding.ActivityUserDataBinding
import com.petnagy.navigatordemo.event.AppEvents
import com.petnagy.navigatordemo.modules.userdata.viewmodel.UserUserDataViewModel
import com.petnagy.navigatordemo.modules.userdata.viewmodel.UserUserDataViewModelFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class UserDataActivity : DaggerAppCompatActivity() {

    companion object {
        const val USER_NAME_TEXT = "userName"
    }

    @Inject
    lateinit var viewModelFactory: UserUserDataViewModelFactory

    private lateinit var viewModel: UserUserDataViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory).get(UserUserDataViewModel::class.java)
        val binding: ActivityUserDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_user_data)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.userDataEvent.observe(this, Observer { event ->
            event.getContentIfNotHandled()?.let {
                when(it) {
                    AppEvents.ADDED_USER_DATA -> addUserData()
                    else -> {
                        // do not implement
                    }
                }
            }
        })
    }

    private fun addUserData() {
        val data = Intent().apply {
            putExtra(USER_NAME_TEXT, viewModel.userData.value ?: "")
        }
        setResult(Activity.RESULT_OK, data)
        finish()
    }
}