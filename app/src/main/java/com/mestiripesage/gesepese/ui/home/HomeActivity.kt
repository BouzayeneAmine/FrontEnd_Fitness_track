package com.mestiripesage.gesepese.ui.home

import android.content.Intent
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.mestiripesage.gesepese.R
import com.mestiripesage.gesepese.databinding.ActivityHomeBinding
import com.mestiripesage.gesepese.databinding.ActivityLoginBinding
import com.mestiripesage.gesepese.ui.base.BaseActivity
import com.mestiripesage.gesepese.ui.forget.ForgetPasswordActivity
import com.mestiripesage.gesepese.ui.home.HomeActivity
import com.mestiripesage.gesepese.ui.products.listProduct.ListProductActivity
import com.mestiripesage.gesepese.ui.register.RegisterActivity

class HomeActivity : BaseActivity<ActivityHomeBinding>(), HomeNavigator {
    lateinit var model: HomeViewModel
    var testTare: Boolean = true
    var tare: Double = 0.0;
    var wheight:Double=0.0;

    override fun setViewModel() {
        model = run {
            ViewModelProviders.of(this!!).get(HomeViewModel::class.java)
        }
    }

    override fun init() {
        model.setNavigator(this)

        getDataBanding()?.viewModel = model
        getDataBanding()!!.button10.setOnClickListener(View.OnClickListener {
            getDataBanding()!!.textView3.setText("0")

        })
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_home
    }


    override fun tare() {


if (tare.equals("0.0")){
    tare =getDataBanding()!!.textView3.text.toString().toDouble();
    getDataBanding()!!.textView3.setText("0")
}
else {
    wheight = getDataBanding()!!.textView3.toString().toDouble();
    wheight=wheight+tare;
    getDataBanding()!!.textView3.setText(wheight.toString())

}


    }
}