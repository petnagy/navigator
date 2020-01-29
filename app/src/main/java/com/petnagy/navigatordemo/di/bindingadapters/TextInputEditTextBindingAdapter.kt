package com.petnagy.navigatordemo.di.bindingadapters

import android.text.TextWatcher
import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputEditText

object TextInputEditTextBindingAdapter {

    @JvmStatic
    @BindingAdapter("addTextWatcher")
    fun bindTextWatcher(textInputEditText: TextInputEditText, textWatcher: TextWatcher) {
        textInputEditText.addTextChangedListener(textWatcher)
    }
}