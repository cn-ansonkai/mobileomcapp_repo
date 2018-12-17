package com.gwk.helloworldgwk.todpapp.tasks

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.view.MenuItem
import com.gwk.helloworldgwk.todpapp.util.setupActionBar
import com.gwk.helloworldgwk.todpapp.util.replaceFragmentInActivity
import com.gwk.helloworldgwk.R
import com.gwk.helloworldgwk.todpapp.statistics.StatisticsActivity
import kotlinx.android.synthetic.main.tasks_act.*

class TasksActivity : AppCompatActivity() {

    // 程序退出时的状态保存的key：查询tasks的过滤条件
    private val CURRENT_FILTERING_KEY = "CURRENT_FILTERING_KEY"

    private lateinit var tasksPresenter: TasksPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tasks_act)

        // toolbar works as ActionBar
        setupActionBar(R.id.toolbar) {
            setHomeAsUpIndicator(R.drawable.ic_menu)
            setDisplayHomeAsUpEnabled(true)
        }

        // navi drawer setup
        drawer_layout.apply {
            setStatusBarBackground(R.color.colorPrimaryDark)
        }

        // navi drawer setup for selected listener and intent
        setupDrawerContent(nav_view)

        // framelayout is being cast to TasksFragment
        val tasksFragment = (contentFrame as? TasksFragment) ?: TasksFragment.newInstance().also {
            replaceFragmentInActivity(it, R.id.contentFrame)
        }



    }

    private fun setupDrawerContent(navi: NavigationView) {
        navi.setNavigationItemSelectedListener { item: MenuItem ->
            if (item.itemId == R.id.statistics_navigation_menu_item) {
                val intentToBeSent = Intent(this@TasksActivity, StatisticsActivity::class.java)
                startActivity(intentToBeSent)
            }
            item.isChecked = true
            drawer_layout.closeDrawers()
            true
        }
    }
}
