package com.example.alodoktermobiletest.homescreen.profile

import androidx.lifecycle.ViewModel
import com.example.alodoktermobiletest.data.model.User

class ProfileViewModel : ViewModel() {

    var user = User()

    fun fillData() {
        user.name = "Rakka Purnama"
        user.gender = "Male"
        user.number = "+6287692830191"
    }
}