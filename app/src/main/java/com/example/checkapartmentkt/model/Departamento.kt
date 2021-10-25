package com.example.checkapartmentkt.model

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "departamentos")
data class Departamento(
    @PrimaryKey(autoGenerate = true)
  
    var id: Int = 1,
    val nombre : String,
    val unidad : String,
    val direccion : String,
    val urlFoto : String,
    val luces :Int,
    val bath : Int,
    val cocina: Int,
    val dormitorio : Int,
    val terminaciones : Int,
    var puntaje : Int ,
){


    //constructor():this(id=0)
    fun calcularPuntaje(){
        this.puntaje = (this.luces + this.bath + this.cocina + this.dormitorio) * this.terminaciones
    }

    //(luces + bath + cocina + dormitorio) * terminaciones
}


