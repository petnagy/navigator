package com.petnagy.navigatordemo.modules.listdetail

import android.os.Bundle
import com.petnagy.navigatordemo.R
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_list_detail.*

class ListDetailActivity : DaggerAppCompatActivity() {

    companion object {
        const val CARD_VIEW_DATA = "cardViewData"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_detail)

        val cardViewText = intent.extras?.getString(CARD_VIEW_DATA, "") ?: ""
        detail_value.text = cardViewText
    }
}