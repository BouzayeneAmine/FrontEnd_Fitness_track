package com.mestiripesage.gesepese.ui.products.addProduct

import android.util.Log
import androidx.lifecycle.ViewModelProviders
import com.mestiripesage.gesepese.R
import com.mestiripesage.gesepese.data.entities.Customer
import com.mestiripesage.gesepese.data.entities.Receipt
import com.mestiripesage.gesepese.databinding.ActivityAddProductBinding
import com.mestiripesage.gesepese.ui.base.BaseActivity


class AddProductActivity  : BaseActivity<ActivityAddProductBinding>(),AddProductNavigator {
  lateinit var model : AddProductViewModel



    override fun setViewModel() {
        model = run {
            ViewModelProviders.of(this).get(AddProductViewModel::class.java)
        }
    }

    override fun init() {
        model.setNavigator(this)

        getDataBanding()?.viewModel =model
        getAllCustomer()
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_add_product
    }

    override fun add(
        name: String,
        price: String,
        code: String,
        customers: List<Customer>,
        receipts: List<Receipt>
    ) {
        Log.v(
            "add customer",
            "name" + name + "code" + code + "price" + price + "customers" + customers + "reciept" + receipts
        )
    }

    override fun getAllCustomer() {

    }
}