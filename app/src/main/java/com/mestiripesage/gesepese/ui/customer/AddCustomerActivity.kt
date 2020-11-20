package com.mestiripesage.gesepese.ui.customer


import android.util.Log
import androidx.lifecycle.ViewModelProviders
import com.mestiripesage.gesepese.R
import com.mestiripesage.gesepese.data.entities.Camion
import com.mestiripesage.gesepese.data.entities.Product
import com.mestiripesage.gesepese.data.entities.Receipt
import com.mestiripesage.gesepese.databinding.ActivityAddCustomerBinding
import com.mestiripesage.gesepese.ui.base.BaseActivity


class AddCustomerActivity : BaseActivity<ActivityAddCustomerBinding>(),AddCustomerNavigator {
 lateinit var model :AddCustomerViewModel

    override fun setViewModel() {
        model = run {
            ViewModelProviders.of(this!!).get(AddCustomerViewModel::class.java)
        }
    }

    override fun init() {
        model.setNavigator(this)

        getDataBanding()?.viewModel =model
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_add_customer
    }

    override fun add(
        name: String,
        code: String,
        adresse: String,
        products: List<Product>,
        reciepts: List<Receipt>,
        camions: List<Camion>
    ) {
        Log.v("add customer","name"+name+"code"+code+"adresse"+adresse+"products"+products+"reciept"+reciepts+"camions"+camions)
    }
}