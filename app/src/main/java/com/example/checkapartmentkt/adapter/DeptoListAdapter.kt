package com.example.checkapartmentkt.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.checkapartmentkt.R
import com.example.checkapartmentkt.adapter.DeptoListAdapter.DeptoViewHolder
import com.example.checkapartmentkt.databinding.ItemRowBinding
import com.example.checkapartmentkt.model.Departamento

class DeptoListAdapter : ListAdapter<Departamento, DeptoViewHolder>(DeptoComparador()) {


    class DeptoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemRowBinding.bind(itemView)
        val tvNombre = binding.tvNombreRow;
        val tvUnidad = binding.tvUnidadRow;
        val tvDireccion = binding.tvDireccionRow;
        val tvPuntaje = binding.tvPuntajeRow;
        val imagenDpto = binding.imgViewRow;


        companion object {
            fun create(parent: ViewGroup): DeptoViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_row, parent, false)
                return DeptoViewHolder(view)
            }
        }

        fun unirDatos(depto: Departamento) {
            tvNombre.text = depto.nombre
            tvDireccion.text =  depto.direccion
            tvPuntaje.text = depto.puntaje.toString()
            tvUnidad.text = depto.unidad
            Glide.with(itemView).load(depto.urlFoto).fitCenter().into(imagenDpto)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeptoViewHolder {
        return DeptoViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: DeptoViewHolder, position: Int) {
        val depto = getItem(position)
        holder.unirDatos(depto)
    }


}


class DeptoComparador : DiffUtil.ItemCallback<Departamento>() {
    override fun areItemsTheSame(oldItem: Departamento, newItem: Departamento): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Departamento, newItem: Departamento): Boolean {
        return oldItem.id == newItem.id
    }
}



