package com.fourall.signin.api
import com.fourall.signin.model.Login
import retrofit2.http.Body
import retrofit2.http.POST

interface SigninService {

    @POST("auth")
    suspend fun putLogin(@Body login : Login): Object

}