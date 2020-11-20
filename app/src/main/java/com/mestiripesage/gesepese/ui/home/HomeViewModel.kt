package com.mestiripesage.gesepese.ui.home

import android.util.Log
import com.mestiripesage.gesepese.ui.base.BaseViewModel

class HomeViewModel : BaseViewModel<HomeNavigator>() {
    private val TAG = "HomeVIewModel"
    fun tare(){
        Log.v(TAG, "tare done " )
        getNavigator()
    }
 fun show() {
     Log.v(TAG, "show button is done")
     getNavigator()?.navigateToListeProduct()
 }
    fun camion() {
        Log.v(TAG, "camion button is working")
        getNavigator()?.navigateToCamion()
    }

    }






