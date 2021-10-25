package com.example.checkapartmentkt.repository

import androidx.annotation.WorkerThread
import com.example.checkapartmentkt.dao.DepartamentoDao
import com.example.checkapartmentkt.model.Departamento
import kotlinx.coroutines.flow.Flow

class Repository (private val dao: DepartamentoDao){
    val allDeptos : Flow<List<Departamento>> = dao.allDeptos()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun agregarDepartamento(depto: Departamento){
        dao.agregarDeaprtamento(depto)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun actualizarDepartamento(depto: Departamento){
        dao.actualizarDepartamento(depto)
    }

}