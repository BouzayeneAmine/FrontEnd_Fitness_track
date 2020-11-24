package com.mestiripesage.gesepese.ui.login


import android.content.Intent
import android.util.Log
import androidx.lifecycle.ViewModelProviders
import com.mestiripesage.gesepese.R
import com.mestiripesage.gesepese.databinding.ActivityLoginBinding
import com.mestiripesage.gesepese.ui.base.BaseActivity
import com.mestiripesage.gesepese.ui.forget.ForgetPasswordActivity
import com.mestiripesage.gesepese.ui.home.HomeActivity
import com.mestiripesage.gesepese.ui.products.listProduct.ListProductActivity
import com.mestiripesage.gesepese.ui.register.RegisterActivity

class LoginActivity : BaseActivity<ActivityLoginBinding>(),LoginNavigator {

    lateinit var model:LoginViewModel

    override fun setViewModel() {
        model = run {
            ViewModelProviders.of(this).get(LoginViewModel::class.java)
        }
    }

    override fun init() {

        model.setNavigator(this)

        getDataBanding()?.viewModel =model
    }

    override fun getLayoutId(): Int {

        return R.layout.activity_login
    }

    override fun login(email:String,password:String) {


        Log.v("msg",email)
        Log.v("msg",password)
    }

    override fun forgret() {
        TODO("Not yet implemented")
    }

    override fun navigateToRegister() {

        startActivity(Intent(this,RegisterActivity::class.java))
    }

    override fun navigateToHome() {
        startActivity(Intent(this,HomeActivity::class.java))
    }

    override fun navigateToForget() {
        startActivity(Intent(this,ForgetPasswordActivity::class.java))    }


}