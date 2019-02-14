package com.gwk.helloworldgwk.todpapp.util

import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.support.v4.app.FragmentTransaction
import android.support.v4.app.FragmentManager

fun AppCompatActivity.setupActionBar(@IdRes toolbarId: Int, action: ActionBar.() -> Unit) {
    setSupportActionBar(findViewById(toolbarId))
    // kotlin语法，其实调用了getSupportActionBar()
    supportActionBar?.run {
        action()
    }
}

/**
 * The `fragment` is added to the container view with id `frameId`. The operation is
 * performed by the `fragmentManager`.
 */
fun AppCompatActivity.replaceFragmentInActivity(fragment: Fragment, @IdRes frameId: Int) {
    supportFragmentManager.transact {
        replace(frameId, fragment)
    }
}

/**
 * Runs a FragmentTransaction, then calls commit().
 */
private inline fun FragmentManager.transact(action: FragmentTransaction.() -> Unit) {
    beginTransaction().apply {
        action()
    }.commit()
}