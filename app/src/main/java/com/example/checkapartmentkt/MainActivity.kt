package com.example.checkapartmentkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.fragment.NavHostFragment
import com.example.checkapartmentkt.application.DepartamentoApplication
import com.example.checkapartmentkt.databinding.ActivityMainBinding
import com.example.checkapartmentkt.viewmodel.DeptoViewModel
import com.example.checkapartmentkt.viewmodel.DeptoViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
     val viewModel: DeptoViewModel by viewModels{
        DeptoViewModelFactory((application as DepartamentoApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController


    }
}