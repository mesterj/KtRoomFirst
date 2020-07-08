package com.example.ktroomfirst

import android.app.Application
import androidx.annotation.WorkerThread
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class TodoViewModel(application: Application) : AndroidViewModel(application) {
    private val todoRepository: TodoRepository

    val alltodos : LiveData<List<Todo>>

    init {
    //    viewModelScope.launch(Dispatchers.IO) {
        val todoDao = TodoDatabase.getDatabase(application).todoDao()
       // val todoDao = TodoDatabase.getDatabase(application,viewModelScope).todoDao()
       //val todoDao = TodoDatabase.initDatabase(application)!!.todoDao()


        todoRepository = TodoRepository(todoDao)
        alltodos = todoRepository.allTodos
    }

    fun insert (todo: Todo) = viewModelScope.launch(Dispatchers.IO) {
        todoRepository.insert(todo)
    }



}