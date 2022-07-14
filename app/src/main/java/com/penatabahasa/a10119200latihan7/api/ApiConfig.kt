package com.penatabahasa.a10119200latihan7.api

import com.penatabahasa.a10119200latihan7.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/*
14 Juli 2022
10119200
Muhammad Jafar Shidik
IF-5
*/

class ApiConfig {
    companion object {
        fun getApiService(): ApiService {
            val httpClient = OkHttpClient.Builder()

            if (BuildConfig.DEBUG) {
                val loggingInterceptor = HttpLoggingInterceptor()
                loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
                httpClient.addInterceptor(loggingInterceptor)
            } else {
                val loggingInterceptor = HttpLoggingInterceptor()
                loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE)
                httpClient.addInterceptor(loggingInterceptor)
            }

            val retrofit = Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build()
            return retrofit.create(ApiService::class.java)
        }
    }
}