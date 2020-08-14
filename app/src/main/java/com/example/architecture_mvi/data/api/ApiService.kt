package com.example.architecture_mvi.data.api

import com.example.architecture_mvi.data.model.User
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getUsers(): List<User>

}