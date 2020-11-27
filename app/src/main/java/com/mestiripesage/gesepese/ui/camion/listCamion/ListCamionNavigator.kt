package com.mestiripesage.gesepese.ui.camion.listCamion

import com.mestiripesage.gesepese.data.entities.Camion

interface ListCamionNavigator {
    fun setValueList(camions:List<Camion>)
}