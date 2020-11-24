package com.mestiripesage.gesepese.ui.login


import android.util.Log
import androidx.databinding.ObservableField
import com.mestiripesage.gesepese.data.remote.ApiGesepese
import com.mestiripesage.gesepese.data.remote.request.user.LoginRequest
import com.mestiripesage.gesepese.domain.useCases.auth.LoginUseCase
import com.mestiripesage.gesepese.ui.base.BaseViewModel
import io.paperdb.Paper

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class LoginViewModel : BaseViewModel<LoginNavigator>() {
    private val TAG = "LoginVIewModel"
    private val useCase =
        LoginUseCase()
    private var email = ObservableField<String>()
    private var password = ObservableField<String>()
    fun login() {
        // getNavigator()?.login(email.get()!!,password.get()!!)
        Log.v(TAG, "email " + email.get())
        Log.v(TAG, "password " + password.get())


        useCase.execute(
            LoginRequest(
                email.get()!!,
                password.get()!!
            )
        ).subscribeOn(
            Schedulers.io()
        ).observeOn(
            AndroidSchedulers
                .mainThread()
        )
            .subscribe {
                handleResult(it)
            }


    }

    private fun handleResult(result: LoginUseCase.Result?) {
//        progressVisible.set(result == LoginUseCase.Result.Loading)
        //getNavigator()!!.showProgress()
        when (result) {
            is LoginUseCase.Result.Success -> {

                Log.e(TAG, "" + result.userResponse.data.toString())

                Paper.book().write("userLogin", result.userResponse.data)
                Paper.book().write("token", result.userResponse.data?.accesstoken!!)

                getNavigator()?.navigateToHome()
            }
            is LoginUseCase.Result.Failure -> {

                Log.d("ERROR", "" + result.throwable.message)
            }
        }
    }

    fun getEmail(): ObservableField<String>? {
        return email
    }

    fun getPassword(): ObservableField<String>? {
        return password
    }

    fun navigateToRegister() {


        getNavigator()?.navigateToRegister()
    }
    fun navigateToForget() {


        getNavigator()?.navigateToForget()
    }

    fun navigateToHome() {


        getNavigator()?.navigateToHome()
    }

}

