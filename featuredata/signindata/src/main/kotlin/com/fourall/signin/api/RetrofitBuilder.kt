package com.fourall.signin.api

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitBuilder {

    private const val BASE_URL = "http://10.0.2.2:8080"

    private fun getRetrofit() = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val signinService : SigninService = getRetrofit().create(SigninService::class.java)

}