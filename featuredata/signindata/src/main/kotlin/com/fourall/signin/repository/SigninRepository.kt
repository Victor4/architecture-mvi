package com.fourall.signin.api.repository

import com.fourall.signin.api.SigninHelper


class SigninRepository(private val signinHelper: SigninHelper) {

    suspend fun putLogin(email : String, senha : String) = signinHelper.putLogin(email, senha)

}