package com.petnagy.navigatordemo.modules.userdata

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.petnagy.navigatordemo.R
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_user_data.*

class UserDataActivity : DaggerAppCompatActivity() {

    companion object {
        const val USER_NAME_TEXT = "userName"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_data)

        user_data_button.setOnClickListener {
            val data = Intent().apply {
                putExtra(USER_NAME_TEXT, user_data_value.text.toString())
            }
            setResult(Activity.RESULT_OK, data)
            finish()
        }
    }
}