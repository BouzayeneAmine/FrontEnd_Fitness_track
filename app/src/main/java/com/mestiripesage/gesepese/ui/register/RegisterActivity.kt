package com.mestiripesage.gesepese.ui.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProviders
import com.mestiripesage.gesepese.R
import com.mestiripesage.gesepese.databinding.ActivityRegisterBinding
import com.mestiripesage.gesepese.ui.base.BaseActivity
import com.mestiripesage.gesepese.ui.login.LoginViewModel

class RegisterActivity : BaseActivity<ActivityRegisterBinding>(),RegisterNavigator {

    lateinit var model:RegisterViewModel

    override fun setViewModel() {
        model = run {
            ViewModelProviders.of(this!!).get(RegisterViewModel::class.java)
        }
    }

    override fun init() {
        model.setNavigator(this)

        getDataBanding()?.viewModel =model



    }

    override fun getLayoutId(): Int {
     return R.layout.activity_register
    }

    override fun register(
        email: String,
        password: String,
        firstName: String,
        lastName: String,
        phone: String
    ) {

        Log.v("msg",email)
        Log.v("msg",password)
        Log.v("msg",firstName)
        Log.v("msg",lastName)
        Log.v("msg",phone)


    }


}