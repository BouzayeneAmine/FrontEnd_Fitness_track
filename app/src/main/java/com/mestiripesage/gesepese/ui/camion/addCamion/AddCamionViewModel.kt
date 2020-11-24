package com.mestiripesage.gesepese.ui.camion.addCamion

import android.util.Log
import androidx.databinding.ObservableField
import com.mestiripesage.gesepese.data.entities.Customer
import com.mestiripesage.gesepese.data.entities.Product
import com.mestiripesage.gesepese.data.entities.Receipt
import com.mestiripesage.gesepese.data.remote.request.camion.CamionAddRequest
import com.mestiripesage.gesepese.domain.useCases.camion.CamionUseCase
import com.mestiripesage.gesepese.domain.useCases.customer.CustomerUseCase
import com.mestiripesage.gesepese.domain.useCases.customer.ListCustomerUseCase
import com.mestiripesage.gesepese.domain.useCases.product.ListProductUseCase
import com.mestiripesage.gesepese.ui.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.ArrayList

class CamionViewModel: BaseViewModel<AddCamionNavigator>() {
    private var TAG = "CamionViewModel"
    private var useCase = CamionUseCase()
    private var useCaseCustomer = ListCustomerUseCase()

    private var immatricule = ObservableField<String>()
    private var code = ObservableField<String>()
    private var tare = ObservableField<String>()
    private var customer = ObservableField<String>()
    private var reciepts = ObservableField<List<Receipt>>()
    var customers = ObservableField<List<Customer>>()
    fun add() {

        Log.v(
            "data from add ",
            "immatricule" + immatricule.get()!! + "code" + code.get()!! + "tare" + tare.get()!! + "customers" + customer.get()!! +"reciept"+reciepts.get()!!
        )
        // getNavigator()?.register(email.get()!!,password.get()!!,firstName.get()!!,lastName.get()!!,phone.get()!!)
        useCase.execute(
            CamionAddRequest(
                immatricule.get()!!,
                code.get()!!,
                tare.get()!!,
                customer.get()!!,
                reciepts.get()!!

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

    private fun handleResult(result: CamionUseCase.Result?) {
//        progressVisible.set(result == LoginUseCase.Result.Loading)
        //getNavigator()!!.showProgress()
        when (result) {
            is CamionUseCase.Result.Success -> {

                Log.e(TAG, result.userResponse.data.toString())

            }
            is CamionUseCase.Result.Failure -> {

                Log.d("ERROR", "" + result.throwable.message)
            }
        }
    }

    fun getAllCustomer() {
        useCaseCustomer.execute().subscribeOn(
            Schedulers.io()
        ).observeOn(
            AndroidSchedulers
                .mainThread()
        )
            .subscribe {
                handleResultListCustomer(it)
            }
    }

    private fun handleResultListCustomer(result: ListCustomerUseCase.Result?) {
//        progressVisible.set(result == LoginUseCase.Result.Loading)
        //getNavigator()!!.showProgress()
        when (result) {
            is ListCustomerUseCase.Result.Success -> {

                Log.e(TAG, result.userResponse.data.toString())
                val list: MutableList<String> = ArrayList()
                //   products.set( result.userResponse.data)
                for (pro in result.userResponse.data!!) {
                    list.add(pro.name.toString())
                }
                getNavigator()?.setValueSpinner(list)
            }
            is ListCustomerUseCase.Result.Failure -> {

                Log.d("ERROR", "" + result.throwable.message)
            }
        }
    }
}