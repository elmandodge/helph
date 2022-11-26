package com.health13.helph.presentation.activities.intro_screens

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.health13.helph.databinding.ActivitySplashBinding
import com.health13.helph.presentation.activities.MainActivity
import com.health13.helph.presentation.activities.authentication.SignInActivity
import com.health13.helph.utils.Constants

class SplashActivity : AppCompatActivity() {
    lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        Handler(Looper.getMainLooper()).postDelayed({

            val preferences: SharedPreferences = getSharedPreferences(Constants.ON_BOARDING_PREF, MODE_PRIVATE)
            if(preferences.getBoolean(Constants.SHOW_ON_BOARDING, false)){
                val intent = Intent(this,  SignInActivity::class.java)
                startActivity(intent)
                finish()
            }else{
                    val intent = Intent(this,  OnboardingActivity::class.java)
                startActivity(intent)
                finish()
            }

        }, 3000)
    }
}