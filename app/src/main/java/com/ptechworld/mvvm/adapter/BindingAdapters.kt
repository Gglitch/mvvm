package com.ptechworld.mvvm.adapter

import android.graphics.Color
import android.graphics.ColorFilter
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("colorForState")
fun bindColorForState(view: ImageView, state: String?) {
    state?.let {
        view.colorFilter = if (it == "open") {
            PorterDuffColorFilter(Color.GREEN, PorterDuff.Mode.SRC_ATOP)
        } else {
            PorterDuffColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP)
        }
    }
}