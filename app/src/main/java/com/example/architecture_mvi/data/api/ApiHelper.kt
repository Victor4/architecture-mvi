package com.example.architecture_mvi.data.api

import com.example.architecture_mvi.data.model.User

interface ApiHelper {

    suspend fun getUsers(): List<User>

}