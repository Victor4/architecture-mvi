package com.fourall.signin.intent

sealed class SigninIntent {

    data class PutLogin(val email: String, val password: String) : SigninIntent()
}