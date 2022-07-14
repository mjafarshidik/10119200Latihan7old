package com.penatabahasa.a10119200latihan7.utils

import androidx.recyclerview.widget.DiffUtil
import com.penatabahasa.a10119200latihan7.model.database.FavoriteUser

/*
14 Juli 2022
10119200
Muhammad Jafar Shidik
IF-5
*/

class FavoriteDiffCallback(
    private val mOldFavList: List<FavoriteUser>,
    private val mNewFavList: List<FavoriteUser>
) :
    DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return mOldFavList.size
    }

    override fun getNewListSize(): Int {
        return mNewFavList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return mOldFavList[oldItemPosition].id == mNewFavList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldFavList = mOldFavList[oldItemPosition]
        val newFavList = mNewFavList[newItemPosition]
        return oldFavList.login == newFavList.login && oldFavList.htmlUrl == newFavList.htmlUrl && oldFavList.avatarUrl == newFavList.avatarUrl
    }


}