package com.fourall.signin.api.model

import com.fourall.signin.api.SigninHelper
import com.fourall.signin.api.SigninService
import com.fourall.signin.model.Login


class SigninHelperImpl(private val signinService: SigninService) : SigninHelper {

    override suspend fun putLogin(email : String, senha : String): String {
        val login = Login(email,senha)
        val retorno = signinService.putLogin(login)
        return "retorno"
    }

}