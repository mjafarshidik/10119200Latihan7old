package com.penatabahasa.a10119200latihan7.model.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.penatabahasa.a10119200latihan7.model.database.FavoriteUser
import com.penatabahasa.a10119200latihan7.model.database.FavoriteUserDao
import com.penatabahasa.a10119200latihan7.model.database.FavoriteUserRoomDatabase
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

/*
14 Juli 2022
10119200
Muhammad Jafar Shidik
IF-5
*/

class FavoriteUserRepository(application: Application) {
    private val mFavoriteUserDao: FavoriteUserDao
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    init {
        val db = FavoriteUserRoomDatabase.getDatabase(application)
        mFavoriteUserDao = db.favoriteUserDao()
    }

    fun getAllFavorites(): LiveData<List<FavoriteUser>> = mFavoriteUserDao.getAllUser()

    fun insert(user: FavoriteUser) {
        executorService.execute { mFavoriteUserDao.insertFavorite(user) }
    }

    fun delete(id: Int) {
        executorService.execute { mFavoriteUserDao.removeFavorite(id) }
    }
}