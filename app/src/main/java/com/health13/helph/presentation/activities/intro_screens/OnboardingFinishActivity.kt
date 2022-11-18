package com.health13.helph.presentation.activities.intro_screens
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.health13.helph.databinding.ActivityOnboardingFinishBinding
import com.health13.helph.presentation.activities.MainActivity
import com.health13.helph.utils.Constants


class OnboardingFinishActivity : AppCompatActivity() {
    private lateinit var btnStart: LinearLayout
    private lateinit var binding: ActivityOnboardingFinishBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingFinishBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        btnStart = binding.layoutStart
        btnStart.setOnClickListener {

            val sharedPreferences = this.getSharedPreferences(
                Constants.ON_BOARDING_PREF,
                Context.MODE_PRIVATE)

            val editor : SharedPreferences.Editor = sharedPreferences.edit()
            editor.putBoolean(Constants.SHOW_ON_BOARDING, true)
            editor.apply()

            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
