package com.penatabahasa.a10119200latihan7.api

import com.penatabahasa.a10119200latihan7.BuildConfig
import com.penatabahasa.a10119200latihan7.model.response.DetailResponse
import com.penatabahasa.a10119200latihan7.model.response.GithubUser
import com.penatabahasa.a10119200latihan7.model.response.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

/*
14 Juli 2022
10119200
Muhammad Jafar Shidik
IF-5
*/

interface ApiService {

    @GET("search/users")
    @Headers("Authorization: token ${BuildConfig.GITHUB_TOKEN}")
    fun searchUser(
        @Query("q") login: String
    ): Call<UserResponse>

    @GET("users/{login}")
    @Headers("Authorization: token ${BuildConfig.GITHUB_TOKEN}")
    fun getUserDetail(
        @Path("login") login: String
    ): Call<DetailResponse>

    @GET("users/{login}/followers")
    @Headers("Authorization: token ${BuildConfig.GITHUB_TOKEN}")
    fun getUserFollowers(
        @Path("login") login: String
    ): Call<List<GithubUser>>

    @GET("users/{login}/following")
    @Headers("Authorization: token ${BuildConfig.GITHUB_TOKEN}")
    fun getUserFollowings(
        @Path("login") login: String
    ): Call<List<GithubUser>>
}