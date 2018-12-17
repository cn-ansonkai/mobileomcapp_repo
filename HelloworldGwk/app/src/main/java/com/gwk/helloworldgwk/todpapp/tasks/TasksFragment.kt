package com.gwk.helloworldgwk.todpapp.tasks

import android.support.v4.app.Fragment

class TasksFragment : Fragment(), TasksContract.View {
    companion object {

        fun newInstance() = TasksFragment()
    }
}