package com.example.tablayout_optionmenu

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.tablayout_optionmenu.databinding.FragmentLoginBinding
import com.example.tablayout_optionmenu.databinding.FragmentRegisterBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.loginButton.setOnClickListener() {
            val username = binding.username.text.toString()
            val password = binding.password.text.toString()

            val sharedPref = requireActivity().getSharedPreferences("DataPengguna", Context.MODE_PRIVATE)
            val savedUsername = sharedPref.getString("username", "")
            val savedPassword = sharedPref.getString("password", "")
            Log.d("LoginFragment", "Input Username: $username, Input Password: $password")
            Log.d("LoginFragment", "Saved Username: $savedUsername, Saved Password: $savedPassword")
            if (username == savedUsername && password == savedPassword) {
                val intent = Intent(requireContext(), SecondActivity::class.java)
                intent.putExtra("username", username)
                startActivity(intent)
            } else {
                Toast.makeText(requireContext(), "username atau password salah!", Toast.LENGTH_SHORT).show()
            }
        }
        return binding.root
    }
}