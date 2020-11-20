package com.mestiripesage.gesepese.ui.camion.addCamion


import android.util.Log
import android.widget.ArrayAdapter
import androidx.lifecycle.ViewModelProviders
import com.mestiripesage.gesepese.R
import com.mestiripesage.gesepese.data.entities.Receipt
import com.mestiripesage.gesepese.databinding.ActivityAddCamionBinding

import com.mestiripesage.gesepese.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_add_camion.*
import kotlinx.android.synthetic.main.activity_add_camion.*


class AddCamionActivity : BaseActivity<ActivityAddCamionBinding>(),AddCamionNavigator {
     lateinit var model: CamionViewModel




    override fun setViewModel() {
        model = run {
            ViewModelProviders.of(this!!).get(CamionViewModel::class.java)
        }
    }

    override fun init() {

        model.setNavigator(this)
        getDataBanding()?.viewModel =model
        val list : MutableList<String> =ArrayList()
        for (i:Int in 1..1040)
            list.add(("Item $i"))

    val adapter = ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,list)
        spinnerCamion.adapter=adapter
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_add_camion
    }

    override fun add(
        immatricule: String,
        code: String,
        tare: String,
        customer: String,
        reciepts: List<Receipt>
    ) {
        Log.v("add data","immatricule"+immatricule+"code"+code+"tare"+tare+"customer"+customer+"reciept"+reciepts)
    }
}