package com.penatabahasa.a10119200latihan7.view.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/*
14 Juli 2022
10119200
Muhammad Jafar Shidik
IF-5
*/

class SettingsViewModelFactory(private val pref: SettingsPreferences) :
    ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ThemeSettingsViewModel::class.java)) {
            return ThemeSettingsViewModel(pref) as T
        }
        throw IllegalArgumentException("Uknown ViewModel class:" + modelClass.name)
    }
}