package com.global.userlistapplication.common.bindingadapter

import android.view.View
import androidx.databinding.BindingAdapter


object BindingAdapter {

    @JvmStatic
    @BindingAdapter("visibleIf")
    fun changeVisibility(view: View, visible: Boolean) {
        view.visibility = if (visible) View.VISIBLE else View.GONE
    }
}