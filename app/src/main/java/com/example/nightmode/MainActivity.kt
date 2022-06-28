package com.example.nightmode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.example.nightmode.databinding.ActivityMainBinding
import com.example.nightmode.manager.SharedPreFManager

class MainActivity : AppCompatActivity() {
    private lateinit var sharedPreFManager: SharedPreFManager
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreFManager = SharedPreFManager(this)
        binding.btnSwitch.isChecked = sharedPreFManager.getTheme()

        if (sharedPreFManager.getTheme()) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {

            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
        binding.btnSwitch.setOnClickListener{
            if (binding.btnSwitch.isChecked){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                sharedPreFManager.saveTheme(true)
            } else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                sharedPreFManager.saveTheme(false)
            }
        }
    }
}