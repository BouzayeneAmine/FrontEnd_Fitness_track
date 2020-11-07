package com.mestiripesage.gesepese.ui.products.listProduct

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.mestiripesage.gesepese.R
import com.mestiripesage.gesepese.databinding.ActivityListProductBinding
import com.mestiripesage.gesepese.databinding.ActivityLoginBinding
import com.mestiripesage.gesepese.ui.base.BaseActivity
import com.mestiripesage.gesepese.ui.login.LoginNavigator
import com.mestiripesage.gesepese.ui.login.LoginViewModel

class ListProductActivity  : BaseActivity<ActivityListProductBinding>(), ListProductNavigator {
    lateinit var model :ListProductViewModel



    override fun setViewModel() {
        model = run {
            ViewModelProviders.of(this!!).get(ListProductViewModel::class.java)
        }
    }

    override fun init() {
        model.setNavigator(this)

        getDataBanding()?.viewModel =model
        showProduct()

    }

    override fun getLayoutId(): Int {
        return R.layout.activity_list_product    }


    override fun showProduct() {
        model.showProduct()
    }

}