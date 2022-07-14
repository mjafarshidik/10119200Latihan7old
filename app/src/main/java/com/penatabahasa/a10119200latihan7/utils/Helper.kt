package com.penatabahasa.a10119200latihan7.utils

import android.content.Context
import android.view.View
import android.widget.Toast

/*
14 Juli 2022
10119200
Muhammad Jafar Shidik
IF-5
*/

class Helper {

    fun showLoading(isLoading: Boolean, view: View) {
        if (isLoading) {
            view.visibility = View.VISIBLE
        } else {
            view.visibility = View.INVISIBLE
        }
    }

    fun showToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}