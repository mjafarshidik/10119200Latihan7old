package com.penatabahasa.a10119200latihan7.view.settings

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

/*
14 Juli 2022
10119200
Muhammad Jafar Shidik
IF-5
*/

class ThemeSettingsViewModel(private val pref: SettingsPreferences) : ViewModel() {
    fun getThemeSettings(): LiveData<Boolean> {
        return pref.getThemeSetting().asLiveData()
    }

    fun saveThemeSetting(isLightModeActive: Boolean) {
        viewModelScope.launch {
            pref.saveThemeSetting(isLightModeActive)
        }
    }
}