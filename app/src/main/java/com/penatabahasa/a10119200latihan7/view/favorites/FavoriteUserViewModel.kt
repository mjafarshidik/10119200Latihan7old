package com.penatabahasa.a10119200latihan7.view.favorites

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.penatabahasa.a10119200latihan7.model.database.FavoriteUser
import com.penatabahasa.a10119200latihan7.model.repository.FavoriteUserRepository

/*
14 Juli 2022
10119200
Muhammad Jafar Shidik
IF-5
*/

class FavoriteUserViewModel(application: Application) : ViewModel() {
    private val mFavoriteUserRepository: FavoriteUserRepository =
        FavoriteUserRepository(application)

    fun getAllFavorites(): LiveData<List<FavoriteUser>> = mFavoriteUserRepository.getAllFavorites()
}