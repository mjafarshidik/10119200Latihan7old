package com.penatabahasa.a10119200latihan7.model.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/*
14 Juli 2022
10119200
Muhammad Jafar Shidik
IF-5
*/

@Entity
data class FavoriteUser(
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "login")
    var login: String?,

    @ColumnInfo(name = "html_url")
    var htmlUrl: String? = null,

    @ColumnInfo(name = "avatar_url")
    var avatarUrl: String? = null,
)
