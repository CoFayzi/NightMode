package com.example.nightmode.manager

import android.content.Context
import android.content.SharedPreferences
import java.security.AccessControlContext


class SharedPreFManager(context: Context) {
    private val SharedPreFManageref: SharedPreferences =
        context.getSharedPreferences("MyPref", Context.MODE_PRIVATE)

    fun saveTheme(isdark: Boolean) {
        val edit = SharedPreFManageref.edit()
        edit.putBoolean("isdark", isdark)
        edit.apply()
    }

    fun getTheme(): Boolean {
        return SharedPreFManageref.getBoolean("isdark", false)

    }

    fun clear() {
        val edit = SharedPreFManageref.edit()
        edit.apply()
        edit.clear()
    }

}