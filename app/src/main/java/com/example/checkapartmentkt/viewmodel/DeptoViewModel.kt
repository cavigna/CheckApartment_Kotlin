package com.example.checkapartmentkt.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import com.example.checkapartmentkt.model.Departamento
import com.example.checkapartmentkt.repository.Repository

class DeptoViewModel(private val repository: Repository) : ViewModel() {

    val allDepartamento : LiveData<List<Departamento>> = repository.allDeptos.asLiveData()

    suspend fun acutalizarDepartamento(depto: Departamento){
        repository.actualizarDepartamento(depto)
    }
}


class DeptoViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DeptoViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DeptoViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}