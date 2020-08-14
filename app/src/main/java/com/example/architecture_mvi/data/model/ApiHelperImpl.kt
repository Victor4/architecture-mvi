package com.example.architecture_mvi.data.model

import com.example.architecture_mvi.data.api.ApiHelper
import com.example.architecture_mvi.data.api.ApiService

class ApiHelperImpl(private val apiService: ApiService) : ApiHelper {

    override suspend fun getUsers(): List<User> {
        return apiService.getUsers()
    }

}