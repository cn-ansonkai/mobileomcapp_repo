package com.gwk.helloworldgwk.todpapp.tasks

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.gwk.helloworldgwk.todpapp.util.setupActionBar
import com.gwk.helloworldgwk.R

class TasksActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tasks_act)

        setupActionBar(R.id.toolbar) {
            setHomeAsUpIndicator(R.drawable.ic_menu)
            setDisplayHomeAsUpEnabled(true)
        }
    }
}
