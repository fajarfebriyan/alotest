package com.example.alodoktermobiletest.data.preference

import android.content.Context

class Preferences() {

    companion object {
        const val IS_LOGGED_IN = "is_logged_in"
        const val NAME = "name"
        const val MODE = 0
    }

    private fun sharedPreferences(context: Context) = context.getSharedPreferences(
        NAME,
        MODE
    )

    fun setLoggedInStatus(context: Context) {
        val editor = sharedPreferences(context).edit()
        editor.putBoolean(IS_LOGGED_IN, true)
        editor.apply()
    }

    fun getLoggedInStatus(context: Context) = sharedPreferences(context).getBoolean(
        IS_LOGGED_IN, false)
}