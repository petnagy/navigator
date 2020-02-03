package com.petnagy.navigatordemo.modules.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.petnagy.navigatordemo.R
import com.petnagy.navigatordemo.databinding.FragmentListBinding
import com.petnagy.navigatordemo.event.AppEvents
import com.petnagy.navigatordemo.modules.dashboard.viewmodel.ListViewModel
import com.petnagy.navigatordemo.modules.dashboard.viewmodel.ListViewModelFactory
import com.petnagy.navigatordemo.nav.goToListDetail
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class ListFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ListViewModelFactory

    private lateinit var viewModel: ListViewModel

    companion object{
        fun newInstance() = ListFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory).get(ListViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentListBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false)
        val view = binding.root
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.listEvent.observe(viewLifecycleOwner, Observer { event ->
            event.getContentIfNotHandled()?.let {
                when(it) {
                    AppEvents.LIST_ITEM_CARD_1 -> launchListDetail("Card 1")
                    AppEvents.LIST_ITEM_CARD_2 -> launchListDetail("Card 2")
                    else -> {
                        // do not implement
                    }
                }
            }
        })
    }

    private fun launchListDetail(message: String) {
        context?.let {
            val intent = goToListDetail(it, message)
            activity?.startActivity(intent)
        }
    }
}