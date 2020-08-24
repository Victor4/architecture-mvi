package com.fourall.signin.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fourall.signin.api.repository.SigninRepository
import com.fourall.signin.intent.SigninIntent
import com.fourall.signin.viewstate.SigninState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import java.lang.Exception

@ExperimentalCoroutinesApi
class SigninViewModel(
    private val signinRepository : SigninRepository
) : ViewModel() {
    val siginIntent = Channel<SigninIntent>(Channel.UNLIMITED)
    private val _state = MutableStateFlow<SigninState>(SigninState.Idle)
    val state: StateFlow<SigninState>
        get() = _state

    init {
        handleIntent()
    }

    private fun handleIntent(){
        viewModelScope.launch {
            siginIntent.consumeAsFlow().collect {
                when (it) {
                    is SigninIntent.PutLogin -> putLogin(it)
                }
            }
        }
    }

    private fun putLogin(intent : SigninIntent.PutLogin) {
        viewModelScope.launch {
            _state.value = SigninState.Loading
            _state.value = try {
                SigninState.Login(signinRepository.putLogin(intent.email,intent.password))
            } catch (e : Exception) {
                SigninState.Error(e.localizedMessage)
            }
        }
    }

}