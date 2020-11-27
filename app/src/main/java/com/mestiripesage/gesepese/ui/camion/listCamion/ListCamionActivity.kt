package com.mestiripesage.gesepese.ui.camion.listCamion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import androidx.lifecycle.ViewModelProviders
import com.mestiripesage.gesepese.R
import com.mestiripesage.gesepese.data.entities.Camion
import com.mestiripesage.gesepese.databinding.ActivityListCamionBinding
import com.mestiripesage.gesepese.ui.base.BaseActivity
import com.mestiripesage.gesepese.ui.camion.listCamion.ListCamionViewModel

class ListCamionActivity : BaseActivity<ActivityListCamionBinding>(), ListCamionNavigator {
    lateinit var model: ListCamionViewModel


    override fun setViewModel() {
        model = run {
            ViewModelProviders.of(this).get(ListCamionViewModel::class.java)
        }
    }

    override fun init() {
        model.setNavigator(this)
        getDataBanding()?.viewModel = model
        model.getAllCamions()


    }

    override fun getLayoutId(): Int {
        TODO("Not yet implemented")
    }

    override fun setValueList(camions: List<Camion>) {
        TODO("Not yet implemented")
    }
}