package com.example.ktroomfirst

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "todos")
data class Todo(@PrimaryKey(autoGenerate = true)
                public val id: Int,val tennivalo : String ,
                var prioritas : Int)

/*@Entity(tableName = "todos")
class Todo(){

    @PrimaryKey(autoGenerate = true)
    public val id: Int = 0
    var tennivalo : String = ""
    var prioritas : Int = 0


    constructor(tennivalo: String, prioritas: Int) : this() {
        this.tennivalo = tennivalo
        this.prioritas = prioritas
    }

    /*fun setId(id: Int?) {
        this.id = id!!
    }*/


}*/
