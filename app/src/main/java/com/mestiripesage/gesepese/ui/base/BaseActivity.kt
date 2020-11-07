package com.mestiripesage.gesepese.ui.base

import android.annotation.TargetApi
import android.app.AlertDialog
import android.app.Dialog
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.mestiripesage.gesepese.R
import io.paperdb.Paper


abstract class BaseActivity<D : ViewDataBinding> : AppCompatActivity() {
    private var dataBinding: D? = null
    private val TAG = "BaseActivity"
    private var WIFI_ENABLE_REQUEST = 0x1006
    var alertDialogLoading: Dialog? = null

    var isConnected: Boolean = false
    fun getDataBanding():D?= dataBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Paper.init(this)
        registerReceiver(
            mNetworkDetectReceiver,
            IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        )

        performDataBinding()
        setViewModel()
        init()

    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(mNetworkDetectReceiver)

    }


    abstract fun setViewModel()

    abstract fun init()

    private fun performDataBinding() {
        dataBinding = DataBindingUtil.setContentView(this, getLayoutId());
    }


    @LayoutRes
    abstract fun getLayoutId(): Int


    @TargetApi(Build.VERSION_CODES.M)
    fun hasPermission(permission: String): Boolean {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M || ContextCompat.checkSelfPermission(
            baseContext,
            permission
        ) == PackageManager.PERMISSION_GRANTED
    }

    @TargetApi(Build.VERSION_CODES.M)
    fun askPermission(permission: String, requestCode: Int) {
        if (!hasPermission(permission)) {
            ActivityCompat
                .requestPermissions(
                    this,
                    arrayOf(permission),
                    requestCode
                )
        }

    }




    private fun checkInternetConnection() {
        val manager: ConnectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = manager.activeNetworkInfo

        if (networkInfo != null && networkInfo.state === NetworkInfo.State.CONNECTED) {
            isConnected = true

//            startActivity(Intent.makeRestartActivityTask(this.intent.component))

            Log.e(TAG, "checkInternetConnection: $isConnected")
//            showNoConnectionSnackBar("Connected", isConnected, 1500)
        } else {
            Log.e(TAG, "checkInternetConnection: $isConnected")
            isConnected = false
//            showNoInternetDialog()

        }
    }
    private val mNetworkDetectReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            checkInternetConnection()
            Log.e(TAG, "onReceive: 1")

        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == WIFI_ENABLE_REQUEST) {
            Log.e(TAG, "INTERNET: wv wdvadsv dsav adsds adsa a")
        }
    }



}