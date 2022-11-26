package com.health13.helph.presentation.activities.authentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.health13.helph.databinding.ActivitySignInBinding
import com.health13.helph.presentation.activities.MainActivity


class SignInActivity : AppCompatActivity() {
    private  lateinit var binding: ActivitySignInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        val view =  binding.root
        setContentView(view)

        binding.loginBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


    }
}