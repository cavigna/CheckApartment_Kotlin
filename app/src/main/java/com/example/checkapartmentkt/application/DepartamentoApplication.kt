package com.example.checkapartmentkt.application

import android.app.Application
import com.example.checkapartmentkt.db.BaseDeDatos
import com.example.checkapartmentkt.repository.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class DepartamentoApplication : Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    val baseDeDatos by lazy { BaseDeDatos.getBaseDeDatos(this, applicationScope) }
    val repository by lazy { Repository(baseDeDatos.dao()) }
}