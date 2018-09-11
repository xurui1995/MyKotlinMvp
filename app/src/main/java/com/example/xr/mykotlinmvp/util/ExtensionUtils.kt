package com.example.xr.mykotlinmvp.util

import android.support.v4.app.Fragment
import android.view.View
import android.widget.Toast

fun View.OnClickListener.addView(vararg  views: View) {
    for (view in views) {
        view.setOnClickListener(this)
    }
}

fun Fragment.showToast(content: String): Toast {
    val toast = Toast.makeText(this.activity?.applicationContext, content, Toast.LENGTH_SHORT)
    toast.show()
    return toast
}