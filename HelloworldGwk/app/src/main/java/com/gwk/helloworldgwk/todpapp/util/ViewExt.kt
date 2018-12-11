package com.gwk.helloworldgwk.todpapp.util

import android.view.View
import android.support.design.widget.Snackbar

/*
 * 限定函数接收者，扩展View的功能
 */
fun View.showSnackBar(msg: String, duration: Int) {
    Snackbar.make(this, msg, duration).show()
}