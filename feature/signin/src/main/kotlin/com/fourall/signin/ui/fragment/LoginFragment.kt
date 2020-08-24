package com.fourall.signin.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.fourall.signin.util.ViewModelFactory
import com.fourall.signin.BuildConfig
import com.fourall.signin.R
import com.fourall.signin.api.RetrofitBuilder
import com.fourall.signin.api.model.SigninHelperImpl
import com.fourall.signin.intent.SigninIntent
import com.fourall.signin.viewmodel.SigninViewModel
import com.fourall.signin.viewstate.SigninState
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber
import java.lang.Exception

class LoginFragment() : Fragment() {

    private lateinit var signinViewModel: SigninViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTimber()
        setupViewModel()
        observerViewModel()
        setupClicks()
    }

    private fun setupClicks() {
        loginButton.setOnClickListener{
            lifecycleScope.launch {
                signinViewModel.siginIntent.send(
                    SigninIntent.PutLogin(
                        emailEditText.text.toString(),
                        passwordEditText.text.toString()
                    )
                )
            }
        }
    }

    private fun setupViewModel(){
        signinViewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(
                SigninHelperImpl(
                    RetrofitBuilder.signinService
                )
            )
        ).get(SigninViewModel::class.java)
    }

    private fun observerViewModel() {
        lifecycleScope.launch {
            signinViewModel.state.collect {
                when(it) {
                    is SigninState.Idle -> {

                    }
                    is SigninState.Loading -> {
                    }
                    is SigninState.Login -> {
                        val a = it.token
                        navigateHome()
                    }
                    is SigninState.Error -> {
                    }
                }
            }
        }
    }

    private fun navigateHome() {
        try {
            findNavController().navigate(R.id.action_loginFragment_to_homenav_graph)
        } catch (e: Exception) {
            SigninState.Error(e.localizedMessage)
        }
    }

    private fun setTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        Timber.tag("LoginFragment")
        Timber.e("Login Fragment")
    }

}