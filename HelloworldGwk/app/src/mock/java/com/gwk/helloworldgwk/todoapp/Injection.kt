package com.gwk.helloworldgwk.todoapp

import android.content.Context
import com.gwk.helloworldgwk.todoapp.data.FakeTasksRemoteDataSource
import com.gwk.helloworldgwk.todpapp.data.source.TasksRepository
import com.gwk.helloworldgwk.todpapp.data.source.local.TasksLocalDataSource
import com.gwk.helloworldgwk.todpapp.data.source.local.ToDoDatabase

import com.gwk.helloworldgwk.todpapp.util.AppExecutors


/**
 * Enables injection of mock implementations for
 * [TasksDataSource] at compile time. This is useful for testing, since it allows us to use
 * a fake instance of the class to isolate the dependencies and run a test hermetically.
 */
object Injection {
    fun provideTasksRepository(context: Context): TasksRepository {
        val database = ToDoDatabase.getInstance(context)
        return TasksRepository.getInstance(
            FakeTasksRemoteDataSource.getInstance(),
            TasksLocalDataSource.getInstance(AppExecutors(), database.taskDao()))
    }
}