package com.example.alodoktermobiletest.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.alodoktermobiletest.data.preference.Preferences
import com.example.alodoktermobiletest.R
import com.example.alodoktermobiletest.databinding.ActivityLoginBinding
import com.example.alodoktermobiletest.homescreen.MainActivity


class LoginActivity : AppCompatActivity() {

    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        viewModel = LoginViewModel(this)
        binding.viewModel = viewModel

        if (Preferences().getLoggedInStatus(this))
            goToMainActivity()

        viewModel.isLoggedIn.observe(this, Observer {
            if (it) goToMainActivity()
        })
    }

    private fun goToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}