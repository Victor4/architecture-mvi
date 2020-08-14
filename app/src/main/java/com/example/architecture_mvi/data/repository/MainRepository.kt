package com.example.architecture_mvi.data.repository

import com.example.architecture_mvi.data.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun getUsers() = apiHelper.getUsers()

}