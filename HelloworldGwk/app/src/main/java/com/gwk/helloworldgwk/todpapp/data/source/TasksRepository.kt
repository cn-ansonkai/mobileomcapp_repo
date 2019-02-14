package com.gwk.helloworldgwk.todpapp.data.source

class TasksRepository(
    val tasksRemoteDataSource: TasksDataSource,
    val tasksLocalDataSource: TasksDataSource
) {
    companion object {

        private var INSTANCE: TasksRepository? = null

        /**
         * Returns the single instance of this class, creating it if necessary.
         * @param tasksRemoteDataSource the backend data source
         * *
         * @param tasksLocalDataSource  the device storage data source
         * *
         * @return the [TasksRepository] instance
         */
        @JvmStatic fun getInstance(tasksRemoteDataSource: TasksDataSource,
                                   tasksLocalDataSource: TasksDataSource): TasksRepository {
            return INSTANCE ?: TasksRepository(tasksRemoteDataSource, tasksLocalDataSource)
                .apply { INSTANCE = this }
        }

        /**
         * Used to force [getInstance] to create a new instance
         * next time it's called.
         */
        @JvmStatic fun destroyInstance() {
            INSTANCE = null
        }
    }
}