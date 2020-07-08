package com.example.ktroomfirst

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Todo1 {
    @PrimaryKey(autoGenerate = true)
    var Id =0
    var todos: String
    var prior: Int

    constructor(todos: String, prior: Int) {
        this.todos = todos
        this.prior = prior
    }

    constructor(todos: String) {
        this.todos = todos
        prior = 0
    }
}