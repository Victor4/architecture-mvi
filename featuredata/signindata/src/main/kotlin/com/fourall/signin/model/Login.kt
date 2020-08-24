package com.fourall.signin.model

import com.squareup.moshi.Json

data class Login(
    @Json(name = "email")
    val email: String,
    @Json(name = "senha")
    val senha: String
)