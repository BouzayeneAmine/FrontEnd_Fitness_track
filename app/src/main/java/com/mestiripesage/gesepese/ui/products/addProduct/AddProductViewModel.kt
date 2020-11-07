package com.mestiripesage.gesepese.ui.products.addProduct

import android.util.Log
import androidx.databinding.ObservableField
import com.mestiripesage.gesepese.data.entities.Order
import com.mestiripesage.gesepese.data.remote.request.ProductAddRequest
import com.mestiripesage.gesepese.domain.useCases.product.addProductUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AddProductViewModel {
    private val TAG = "AddProductViewModel"
    private val useCase =
        addProductUseCase()
    private var name = ObservableField<String>()
    private var quantity = ObservableField<String>()
    private var description = ObservableField<String>()
    private var price = ObservableField<String>()
    private var subCategory = ObservableField<String>()
    private var order = ObservableField<List<Order>>()

    fun add() {
        // getNavigator()?.login(email.get()!!,password.get()!!)
        Log.v(TAG, "name " + name.get())
        Log.v(TAG, "quantity " + quantity.get())
        Log.v(TAG, "description " + description.get())
        Log.v(TAG, "price " + price.get())


        useCase.execute(ProductAddRequest(name.get()!!, quantity.get()!! , description.get()!! , price.get()!!,order.get()!!,subCategory.get())).subscribeOn(
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

    fun getQuantity(): ObservableField<String>? {
        return quantity
    }
    fun getDescription(): ObservableField<String>? {
        return description
    }
    fun getPrice(): ObservableField<String> {
        return price
    }
    fun getOrders(): ObservableField<List<Order>> {
        return order
    }
    fun getSubCategory(): ObservableField<String>? {
        return subCategory
    }

}