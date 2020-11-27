    package com.mestiripesage.gesepese.ui.home

import android.bluetooth.BluetoothSocket
import android.content.Intent
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.mestiripesage.gesepese.R
import com.mestiripesage.gesepese.databinding.ActivityHomeBinding
import com.mestiripesage.gesepese.databinding.ActivityLoginBinding
import com.mestiripesage.gesepese.ui.base.BaseActivity
import com.mestiripesage.gesepese.ui.camion.addCamion.AddCamionActivity
import com.mestiripesage.gesepese.ui.customer.addCustomer.AddCustomerActivity
import com.mestiripesage.gesepese.ui.products.listProduct.ListProductActivity
import java.io.IOException

class HomeActivity : BaseActivity<ActivityHomeBinding>(), HomeNavigator {
    lateinit var model: HomeViewModel
    var testTare: Boolean = true
    var tare: Double = 0.0
    var wheight: Double = 0.0

    override fun setViewModel() {
        model = run {
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        }
    }

    override fun init() {
        model.setNavigator(this)

        getDataBanding()?.viewModel = model
        getDataBanding()!!.zeroImageButton.setOnClickListener(View.OnClickListener {
            getDataBanding()!!.wheighInput.text = "0"

        })
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_home
    }


    override fun tare() {


if (tare.equals("0.0")) {
    tare = getDataBanding()!!.wheighInput.text.toString().toDouble()
    getDataBanding()!!.wheighInput.text = "0"
}
else {
    wheight = getDataBanding()!!.wheighInput.toString().toDouble()
    wheight = wheight + tare
    getDataBanding()!!.wheighInput.text = wheight.toString()

}


    }

    override fun navigateToListeProduct() {
        startActivity(Intent(this, ListProductActivity::class.java))
    }

    override fun navigateToCamion() {
        startActivity(Intent(this, AddCamionActivity::class.java))
    }

    override fun navigateToCustomer() {
        startActivity(Intent(this, AddCustomerActivity::class.java))
    }

   /*
    fun readBlueToothDataFromMothership(bluetoothSocket: BluetoothSocket) {
        Log.i(TAG, Thread.currentThread().name)
        val bluetoothSocketInputStream = bluetoothSocket.inputStream
        val buffer = ByteArray(1024)
        var bytes: Int
        //Loop to listen for received bluetooth messages
        while (true) {
            try {
                bytes = bluetoothSocketInputStream.read(buffer)
                val readMessage = String(buffer, 0, bytes)
                liveData.postValue(readMessage)
            } catch (e: IOException) {
                e.printStackTrace()
                break
            }
        }
    }*/

}