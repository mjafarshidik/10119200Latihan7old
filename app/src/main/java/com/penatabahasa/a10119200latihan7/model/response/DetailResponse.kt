package com.penatabahasa.a10119200latihan7.model.response

import com.google.gson.annotations.SerializedName

/*
14 Juli 2022
10119200
Muhammad Jafar Shidik
IF-5
*/

data class DetailResponse(
    @field: SerializedName("id")
    val id: Int = 0,

    @field:SerializedName("bio")
    val bio: Any? = null,

    @field:SerializedName("login")
    val login: String? = null,

    @field:SerializedName("blog")
    val blog: String? = null,

    @field:SerializedName("public_gists")
    val publicGists: Int? = null,

    @field:SerializedName("followers")
    val followers: Int? = null,

    @field:SerializedName("avatar_url")
    val avatarUrl: String? = null,

    @field:SerializedName("html_url")
    val htmlUrl: String? = null,

    @field:SerializedName("following")
    val following: Int? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("company")
    val company: String? = null,

    @field:SerializedName("location")
    val location: String? = null,

    @field:SerializedName("public_repos")
    val publicRepos: Int? = null,

    @field:SerializedName("email")
    val email: Any? = null
)
