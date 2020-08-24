package com.fourall.signin.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.fourall.signin.api.SigninHelper
import com.fourall.signin.api.repository.SigninRepository
import com.fourall.signin.viewmodel.SigninViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory(private val signinHelper: SigninHelper) : ViewModelProvider.Factory
{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SigninViewModel::class.java)){
            return SigninViewModel(SigninRepository(signinHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}