package com.fourall.signin.viewstate

sealed class SigninState {

    object Idle : SigninState()
    object Loading : SigninState()
    data class Login(val token: String) : SigninState()
    data class Error(val error : String?) : SigninState()
}