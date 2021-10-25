package com.example.checkapartmentkt.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.checkapartmentkt.model.Departamento
import kotlinx.coroutines.flow.Flow

@Dao
interface DepartamentoDao {
    @Insert
    suspend fun agregarDeaprtamento(dpto :Departamento)

    @Update
    suspend fun actualizarDepartamento(depto: Departamento)

    @Query("SELECT * FROM departamentos")
     fun allDeptos() : Flow<List<Departamento>>


}