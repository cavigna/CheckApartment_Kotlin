package com.example.checkapartmentkt.fragments.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.checkapartmentkt.R
import com.example.checkapartmentkt.adapter.DeptoListAdapter
import com.example.checkapartmentkt.databinding.FragmentListBinding
import com.example.checkapartmentkt.viewmodel.DeptoViewModel

class ListFragment : Fragment() {
    private lateinit var binding: FragmentListBinding
    //private val viewModel:DeptoViewModel = ViewModelProvider(requireActivity()).get(DeptoViewModel::class.java)
    private val viewModel: DeptoViewModel by activityViewModels()
    val adapter = DeptoListAdapter()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)

        val recyclerView = binding.recyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this.requireContext())


        viewModel.allDepartamento.observe(viewLifecycleOwner){ departamentos ->
            departamentos.let { adapter.submitList(departamentos) }

        }

        return binding.root


    }


//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//         //viewModel = ViewModelProvider(requireActivity()).get(DeptoViewModel::class.java)
//
//    }
}


