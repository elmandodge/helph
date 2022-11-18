package com.health13.helph.utils

import android.app.Activity
import android.content.Context
import com.health13.helph.R


object Animations {

    fun animateSlideLeft(context: Context) {
        (context as Activity).overridePendingTransition(
            R.anim.animate_slide_left_enter,
            R.anim.animate_slide_left_exit
        )
    }

}