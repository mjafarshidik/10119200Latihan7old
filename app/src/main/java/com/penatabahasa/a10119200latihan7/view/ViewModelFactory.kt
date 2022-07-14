package com.penatabahasa.a10119200latihan7.view

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.penatabahasa.a10119200latihan7.view.details.UserDetailViewModel
import com.penatabahasa.a10119200latihan7.view.favorites.FavoriteUserViewModel

/*
14 Juli 2022
10119200
Muhammad Jafar Shidik
IF-5
*/

class ViewModelFactory private constructor(private val mApplication: Application) :
    ViewModelProvider.NewInstanceFactory() {
    companion object {
        @Volatile
        private var INSTANCE: ViewModelFactory? = null

        @JvmStatic
        fun getInstance(application: Application): ViewModelFactory {
            if (INSTANCE == null) {
                synchronized(ViewModelFactory::class.java) {
                    INSTANCE = ViewModelFactory(application)
                }
            }
            return INSTANCE as ViewModelFactory
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserDetailViewModel::class.java)) {
            return UserDetailViewModel(mApplication) as T
        } else if (modelClass.isAssignableFrom(FavoriteUserViewModel::class.java)) {
            return FavoriteUserViewModel(mApplication) as T
        }
        throw IllegalArgumentException("Uknown ViewModel class: ${modelClass.name}")
    }
}