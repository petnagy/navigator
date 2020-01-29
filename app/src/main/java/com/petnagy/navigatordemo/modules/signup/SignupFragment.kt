package com.petnagy.navigatordemo.modules.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.petnagy.navigatordemo.R
import com.petnagy.navigatordemo.databinding.FragmentSignupBinding
import com.petnagy.navigatordemo.event.AppEvents
import com.petnagy.navigatordemo.modules.signup.viewmodel.SignUpViewModel
import com.petnagy.navigatordemo.modules.signup.viewmodel.SignUpViewModelFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class SignupFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: SignUpViewModelFactory

    private lateinit var viewModel: SignUpViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory).get(SignUpViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentSignupBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_signup, container, false)
        val view = binding.root
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.signUpEvent.observe(viewLifecycleOwner, Observer { event ->
            event.getContentIfNotHandled()?.let {
                when(it) {
                    AppEvents.SIGN_UP_PRESSED -> startSignUp()
                    else -> {
                        // do not implement
                    }
                }
            }
        })
    }

    private fun startSignUp() {
        val activity = activity as SignUpActivity
        activity.openFragment(UserDataFragment())
    }
}