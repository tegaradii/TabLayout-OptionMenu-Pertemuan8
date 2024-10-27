package com.example.tablayout_optionmenu

import android.app.FragmentManager
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.tablayout_optionmenu.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {
    private lateinit var binding: FragmentRegisterBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        binding.registerButton.setOnClickListener() {
            val username = binding.username.text.toString()
            val email = binding.email.text.toString()
            val phone = binding.phone.text.toString()
            val password = binding.password.text.toString()
            val sharedPref = requireActivity().getSharedPreferences("DataPengguna", Context.MODE_PRIVATE)
            with(sharedPref.edit()) {
                putString("username", username)
                putString("email", email)
                putString("phone", phone)
                putString("password", password)
                apply()
            }
            val viewPager = requireActivity().findViewById<ViewPager2>(R.id.view_pager)
            viewPager.currentItem = 1
        }
        return binding.root
    }
}