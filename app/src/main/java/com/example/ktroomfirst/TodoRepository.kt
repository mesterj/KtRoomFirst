package com.example.ktroomfirst

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData

class TodoRepository(private val todoDao: TodoDao){

    val allTodos: LiveData<List<Todo>> = todoDao.geTodosLive()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(todo: Todo) {
        todoDao.insert(todo)
    }
}