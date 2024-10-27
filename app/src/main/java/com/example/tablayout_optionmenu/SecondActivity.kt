package com.example.tablayout_optionmenu

import android.content.Context
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tablayout_optionmenu.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sharedPref = this.getSharedPreferences("DataPengguna", Context.MODE_PRIVATE)
        val username = sharedPref.getString("username", "")
        binding.usernameView.text = "Welcome $username"
    }
}