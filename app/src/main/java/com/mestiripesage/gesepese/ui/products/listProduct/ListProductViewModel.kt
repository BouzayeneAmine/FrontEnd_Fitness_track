package com.mestiripesage.gesepese.ui.products.listProduct

import android.util.Log
import com.mestiripesage.gesepese.domain.useCases.product.ListProductUseCase
import com.mestiripesage.gesepese.ui.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ListProductViewModel  : BaseViewModel<ListProductNavigator>() {

    private var TAG = "ListProductViewModel"
    private var useCase =
        ListProductUseCase()



    fun showProduct() {


        // getNavigator()?.register(email.get()!!,password.get()!!,firstName.get()!!,lastName.get()!!,phone.get()!!)
        useCase.execute()

        .subscribeOn(
            Schedulers.io()
        ).observeOn(
            AndroidSchedulers
                .mainThread()
        )
            .subscribe {
                handleResult(it)
            }

    }

    private fun handleResult(result: ListProductUseCase.Result?) {
//        progressVisible.set(result == LoginUseCase.Result.Loading)
        //getNavigator()!!.showProgress()
        when (result) {
            is ListProductUseCase.Result.Success -> {

                Log.e(TAG, result.userResponse.toString())

            }
            is ListProductUseCase.Result.Failure -> {

                Log.d("ERROR", "" + result.throwable.message)
            }
        }
    }
}