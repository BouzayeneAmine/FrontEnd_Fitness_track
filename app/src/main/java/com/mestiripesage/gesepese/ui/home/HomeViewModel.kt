package com.mestiripesage.gesepese.ui.home

import android.util.Log
import androidx.databinding.ObservableField
import com.mestiripesage.gesepese.data.remote.request.LoginRequest
import com.mestiripesage.gesepese.domain.useCases.auth.LoginUseCase
import com.mestiripesage.gesepese.ui.base.BaseViewModel
import com.mestiripesage.gesepese.ui.login.LoginNavigator
import io.paperdb.Paper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class HomeViewModel : BaseViewModel<HomeNavigator>() {
    private val TAG = "HomeVIewModel"
    fun tare(){
        Log.v(TAG, "tare done " )
        getNavigator()
    }





    }






