package com.example.ktroomfirst

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*
import net.alexandroid.utils.mylogkt.logI
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var todoViewModel: TodoViewModel
    private lateinit var todoRepository: TodoRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //todoViewModel = todoViewModel by viewModels()
        todoViewModel = ViewModelProvider(this).get(TodoViewModel::class.java)
        //var todoRepository = TodoRepository()
        btnSaveTodo.setOnClickListener {
            val todo1 = Todo(0,etTodoInput.text.toString(),spinner.selectedItemPosition)
            todoViewModel.insert(todo1)
        }
        btnListTodo.setOnClickListener {
         /*   var todolist = todoViewModel.alltodos
            for (todo in todolist) {
                logI("Todo id : ${todo.id} ,  tennivalo: ${todo.tennivalo} , prior: ${todo.prioritas}" )
            }*/
        }

    }


    fun save () {
        var szoveg = etTodoInput.text.toString()
        var todo = Todo(0,szoveg,1)
        todoViewModel.insert(todo)
    }


}