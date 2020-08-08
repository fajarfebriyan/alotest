package com.example.alodoktermobiletest.homescreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.example.alodoktermobiletest.R
import com.example.alodoktermobiletest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.appBarLayout.tvTitle.text = getString(R.string.app_name)

        navController = Navigation.findNavController(this, R.id.nav_host_main)

        binding.bottomNavigation.setupWithNavController(navController)
    }
}