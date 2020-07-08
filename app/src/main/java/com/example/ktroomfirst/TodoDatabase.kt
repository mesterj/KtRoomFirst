package com.example.ktroomfirst

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = arrayOf(Todo::class),version = 1)
abstract class TodoDatabase  : RoomDatabase() {
    abstract fun todoDao() : TodoDao

    companion object {
        @Volatile
        private var INSTANCE: TodoDatabase? = null
   //     private var newinstance: TodoDatabase? = null

        fun getDatabase(context: Context
                        //, scope: CoroutineScope
        ): TodoDatabase {
          return INSTANCE ?: synchronized(this) {
           val instance = Room.databaseBuilder(
               context.applicationContext,
               TodoDatabase::class.java,
               "todo_database"
           )//.allowMainThreadQueries()
              // .fallbackToDestructiveMigration()
               //.addCallback(TodoDatabaseCallback(scope))
               .build()
           INSTANCE = instance
           instance
       }
    }

        private class TodoDatabaseCallback( private val scope: CoroutineScope) : RoomDatabase.Callback() {
            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                INSTANCE.let { todoDatabase -> scope.launch(Dispatchers.IO) {
                 //   populateDatabase(todoDatabase.todoDao())
                }
                }
            }
        }

        fun populateDatabase(todoDao: TodoDao) {

        }
    }
}
