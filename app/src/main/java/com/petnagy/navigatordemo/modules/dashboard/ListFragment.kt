package com.petnagy.navigatordemo.modules.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.petnagy.navigatordemo.R
import com.petnagy.navigatordemo.nav.goToListDetail
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_list.*
import timber.log.Timber

class ListFragment : DaggerFragment() {

    companion object{
        fun newInstance() = ListFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cardView1.setOnClickListener {
            Timber.d("CardView1 pressed")
            context?.let {
                val intent = goToListDetail(it, card_text_1.text.toString())
                activity?.startActivity(intent)
            }
        }

        cardView2.setOnClickListener {
            Timber.d("CardView2 pressed")
            context?.let {
                val intent = goToListDetail(it, card_text_2.text.toString())
                activity?.startActivity(intent)
            }
        }
    }
}