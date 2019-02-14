package com.gwk.helloworldgwk.todpapp.data.source.local

import com.gwk.helloworldgwk.todpapp.data.source.TasksDataSource
import com.gwk.helloworldgwk.todpapp.util.AppExecutors

/**
 * Concrete implementation of a data source as a db.
 */
class TasksLocalDataSource private constructor(
    val appExecutors: AppExecutors,
    val tasksDao: TasksDao
) : TasksDataSource {
    companion object {
        private var INSTANCE: TasksLocalDataSource? = null

        @JvmStatic
        fun getInstance(appExecutors: AppExecutors, tasksDao: TasksDao): TasksLocalDataSource {
            if (INSTANCE == null) {
                synchronized(TasksLocalDataSource::javaClass) {
                    INSTANCE = TasksLocalDataSource(appExecutors, tasksDao)
                }
            }
            return INSTANCE!! //只有INSTANCE不为null才执行这条语句
        }

        //@VisibleForTesting
        //fun clearInstance() {
        //    INSTANCE = null
        //}
    }
}