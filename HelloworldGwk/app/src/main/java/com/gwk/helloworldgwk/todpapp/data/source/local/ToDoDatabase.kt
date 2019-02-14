package com.gwk.helloworldgwk.todpapp.data.source.local

import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context


abstract class ToDoDatabase: RoomDatabase() {

    abstract fun taskDao(): TasksDao

    companion object {

        private var INSTANCE: ToDoDatabase? = null

        private val lock = Any()

        fun getInstance(context: Context): ToDoDatabase {
            synchronized(lock) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        ToDoDatabase::class.java, "Tasks.db")
                        .build()
                }
                return INSTANCE!!
            }
        }
    }
}