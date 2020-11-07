package com.mestiripesage.gesepese.ui.register

import android.util.Log
import androidx.databinding.ObservableField
import com.mestiripesage.gesepese.data.remote.request.RegisterRequest
import com.mestiripesage.gesepese.domain.useCases.auth.RegisterUseCase
import com.mestiripesage.gesepese.ui.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RegisterViewModel : BaseViewModel<RegisterNavigator>() {
    private var TAG = "RegisterViewModel"
    private var useCase =
        RegisterUseCase()
    private var email = ObservableField<String>()
    private var password = ObservableField<String>()
    private var firstName = ObservableField<String>()
    private var lastName = ObservableField<String>()
    private var phone = ObservableField<String>()

    fun register() {

        Log.v("data from register ","email"+  email.get()!! + "password"+password.get()!! +"firstName"+firstName.get()!! + "lastName"+lastName.get()!! +"phone"+phone.get()!!)
        // getNavigator()?.register(email.get()!!,password.get()!!,firstName.get()!!,lastName.get()!!,phone.get()!!)
        useCase.execute(
            RegisterRequest(
                email.get()!!,
                password.get()!!,
                firstName.get()!!,
                lastName.get()!!,
                phone.get()!!
            )).subscribeOn(
                Schedulers.io()
            ).observeOn(
                AndroidSchedulers
                    .mainThread()
            )
                .subscribe {
                    handleResult(it)
                }

    }

    private fun handleResult(result: RegisterUseCase.Result?) {
//        progressVisible.set(result == LoginUseCase.Result.Loading)
        //getNavigator()!!.showProgress()
        when (result) {
            is RegisterUseCase.Result.Success -> {

                Log.e(TAG, result.userResponse.toString())

            }
            is RegisterUseCase.Result.Failure -> {

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

    fun firstName(): ObservableField<String>? {
        return firstName
    }

    fun lastName(): ObservableField<String>? {
        return lastName
    }

    fun getPhone(): ObservableField<String>? {
        return phone
    }
}