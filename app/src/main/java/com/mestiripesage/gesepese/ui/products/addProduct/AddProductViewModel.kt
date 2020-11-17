package com.mestiripesage.gesepese.ui.products.addProduct

import android.util.Log
import androidx.databinding.ObservableField
import com.mestiripesage.gesepese.data.entities.Customer
import com.mestiripesage.gesepese.data.entities.Receipt
import com.mestiripesage.gesepese.data.remote.request.product.ProductAddRequest
import com.mestiripesage.gesepese.domain.useCases.product.addProductUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AddProductViewModel {
    private val TAG = "AddProductViewModel"
    private val useCase =
        addProductUseCase()
    private var name = ObservableField<String>()
    private var code = ObservableField<String>()

    private var price = ObservableField<String>()
    private var customers = ObservableField<List<Customer>>()
    private var receipts = ObservableField<List<Receipt>>()

    fun add() {
        // getNavigator()?.login(email.get()!!,password.get()!!)
        Log.v(TAG, "name " + name.get())
        Log.v(TAG, "quantity " + code.get())
        Log.v(TAG, "price " + price.get())


        useCase.execute(
            ProductAddRequest(
                name.get()!!,
                code.get()!!,
                price.get()!!,
                customers.get()!!,
                receipts.get()
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

    private fun handleResult(result: addProductUseCase.Result) {
//        progressVisible.set(result == LoginUseCase.Result.Loading)
        //getNavigator()!!.showProgress()
        when (result) {
            is addProductUseCase.Result.Success -> {

                Log.e(TAG, result.userResponse.toString())

            }
            is addProductUseCase.Result.Failure -> {

                Log.d("ERROR", "" + result.throwable.message)
            }
        }
    }

    fun getName(): ObservableField<String>? {
        return name
    }

    fun getCode(): ObservableField<String>? {
        return code
    }

    fun getPrice(): ObservableField<String> {
        return price
    }
    fun getCustomers(): ObservableField<List<Customer>> {
        return customers
    }
    fun getReceipt(): ObservableField<List<Receipt>> {
        return receipts
    }

}