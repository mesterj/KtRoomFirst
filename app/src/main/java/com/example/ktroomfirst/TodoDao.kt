package com.example.ktroomfirst

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TodoDao {

    @Insert
    suspend fun insert(todo: Todo)

    @Query("SELECT * from todos ")
    fun geTodosLive(): LiveData<List<Todo>>

    @Query("SELECT * from todos ")
    fun geTodos(): List<Todo>
    
}