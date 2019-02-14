package com.gwk.helloworldgwk.todoapp.data

import com.gwk.helloworldgwk.todpapp.data.source.TasksDataSource

class FakeTasksRemoteDataSource : TasksDataSource {
    companion object {

        private lateinit var INSTANCE: FakeTasksRemoteDataSource
        private var needsNewInstance = true

        @JvmStatic fun getInstance(): FakeTasksRemoteDataSource {
            if (needsNewInstance) {
                INSTANCE = FakeTasksRemoteDataSource()
                needsNewInstance = false
            }
            return INSTANCE
        }
    }
}