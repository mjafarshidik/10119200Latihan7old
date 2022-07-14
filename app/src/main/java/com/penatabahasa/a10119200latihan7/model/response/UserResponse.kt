package com.penatabahasa.a10119200latihan7.model.response

import com.google.gson.annotations.SerializedName

/*
14 Juli 2022
10119200
Muhammad Jafar Shidik
IF-5
*/

data class UserResponse(
    @field:SerializedName("total_count")
    val totalCount: Int,

    @field:SerializedName("items")
    val githubUsers: List<GithubUser>
)

data class GithubUser(
    @field:SerializedName("avatar_url")
    val avatarUrl: String,

    @field:SerializedName("html_url")
    val htmlUrl: String,

    @field:SerializedName("login")
    val login: String,
)
