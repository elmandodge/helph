package com.health13.helph.presentation.activities.intro_screens
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.health13.helph.data.models.Language
import com.health13.helph.databinding.ActivityOnboardingFinishBinding
import com.health13.helph.presentation.activities.MainActivity
import com.health13.helph.presentation.adapters.LanguageAdapter
import com.health13.helph.utils.Constants
import java.util.*


class OnboardingFinishActivity : AppCompatActivity() {
    private lateinit var btnStart: LinearLayout
    private lateinit var binding: ActivityOnboardingFinishBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingFinishBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setSpinner()

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



    private fun setSpinner() {
        val myAdapter = LanguageAdapter(this, Language.getLanguageList())
        binding.spinner.adapter = myAdapter

        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>, view: View, position: Int, l: Long) {
                val language = adapterView.adapter.getItem(position) as Language
                if (position != 0) {
                    setLocale(language.code)
                }
            }

            override fun onNothingSelected(adapterView: AdapterView<*>) {}
        }
    }

    fun setLocale(lang: String?) {
        val myLocale = lang?.let { Locale(it) }
        val res = resources
        val conf = res.configuration
        conf.locale = myLocale
        res.updateConfiguration(conf, res.displayMetrics)
        startActivity(Intent(this, OnboardingFinishActivity::class.java))
        finish()
    }
}
