package com.fourall.signin.api

interface SigninHelper {

    suspend fun putLogin(email : String, senha : String): String

}