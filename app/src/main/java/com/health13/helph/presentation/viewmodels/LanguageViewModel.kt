package com.health13.helph.presentation.viewmodels

import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.util.*

class LanguageViewModel:  ViewModel(){



}


class LanguageViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LanguageViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return LanguageViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}