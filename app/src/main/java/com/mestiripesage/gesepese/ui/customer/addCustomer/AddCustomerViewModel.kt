package com.mestiripesage.gesepese.ui.customer.addCustomer

import android.util.Log
import androidx.databinding.ObservableField
import com.mestiripesage.gesepese.data.entities.Camion
import com.mestiripesage.gesepese.data.entities.Product
import com.mestiripesage.gesepese.data.entities.Receipt
import com.mestiripesage.gesepese.data.remote.request.customer.CustomerAddRequest
import com.mestiripesage.gesepese.domain.useCases.customer.CustomerUseCase
import com.mestiripesage.gesepese.ui.base.BaseViewModel
import com.mestiripesage.gesepese.ui.customer.addCustomer.AddCustomerNavigator
import io.paperdb.Paper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AddCustomerViewModel : BaseViewModel<AddCustomerNavigator>() {
    private val TAG = "CustomerViewModel"
    private val useCase = CustomerUseCase()
    private val name = ObservableField<String>()
    private val code = ObservableField<String>()
    private val adresse = ObservableField<String>()
    private val reciepts = ObservableField<List<Receipt>>()
    private val camions = ObservableField<List<Camion>>()
    private val products = ObservableField<List<Product>>()
    fun add() {
        Log.v(
            "add customer",
            "name=" + name.get()!! + "code=" + code.get()!! + "adresse=" + adresse.get()!!
        )

        useCase.execute(
            CustomerAddRequest(
                name.get()!!,
                code.get()!!,
                adresse.get()!!,
                camions.get()!!,
                reciepts.get()!!,
                products.get()!!
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

    private fun handleResult(result: CustomerUseCase.Result?) {
//        progressVisible.set(result == LoginUseCase.Result.Loading)
        //getNavigator()!!.showProgress()
        when (result) {
            is CustomerUseCase.Result.Success -> {

                Log.e(TAG, "" + result.userResponse.message)

                Paper.book().write("user", result.userResponse);

             //   getNavigator()?.navigateToHome()
            }
            is CustomerUseCase.Result.Failure -> {

                Log.d("ERROR", "" + result.throwable.message)
            }
        }
    }

}


