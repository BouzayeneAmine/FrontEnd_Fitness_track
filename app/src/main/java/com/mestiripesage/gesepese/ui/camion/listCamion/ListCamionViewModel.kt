package com.mestiripesage.gesepese.ui.camion.listCamion

import android.util.Log
import com.mestiripesage.gesepese.databinding.ActivityListCamionBinding
import com.mestiripesage.gesepese.domain.useCases.camion.ListeCamionUseCase
import com.mestiripesage.gesepese.domain.useCases.customer.ListCustomerUseCase
import com.mestiripesage.gesepese.ui.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.ArrayList

class ListCamionViewModel:BaseViewModel<ListCamionNavigator>() {
    private var TAG ="ListCamionViewModel"
    private var useCase =ListeCamionUseCase()


    fun getAllCamions() {
        useCase.execute().subscribeOn(
            Schedulers.io()
        ).observeOn(
            AndroidSchedulers
                .mainThread()
        )
            .subscribe {
                handleResult(it)
            }
    }

    private fun handleResult(result: ListeCamionUseCase.Result?) {
//        progressVisible.set(result == LoginUseCase.Result.Loading)
        //getNavigator()!!.showProgress()
        when (result) {
            is ListeCamionUseCase.Result.Success -> {

                Log.e(TAG, result.userResponse.data.toString())
                val list: MutableList<String> = ArrayList()
                //   products.set( result.userResponse.data)
                for (pro in result.userResponse.data!!) {
                   // list.add(pro.name.toString())
                }
                //getNavigator()?.setValueSpinner(list)
            }
            is ListeCamionUseCase.Result.Failure -> {

                Log.d("ERROR", "" + result.throwable.message)
            }
        }
    }
}
