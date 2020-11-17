package com.mestiripesage.gesepese.data.repository

import com.mestiripesage.gesepese.data.entities.Camion
import com.mestiripesage.gesepese.data.remote.RetrofitClient
import com.mestiripesage.gesepese.data.remote.request.camion.CamionAddRequest
import com.mestiripesage.gesepese.data.remote.request.camion.CamionUpdateRequest
import com.mestiripesage.gesepese.data.remote.response.Data
import com.mestiripesage.gesepese.domain.repository.ICamionRepository
import io.reactivex.Observable

class CamionRepositoryImp : ICamionRepository {
    override fun camionAdd(camionAddRequest: CamionAddRequest): Observable<Data<Camion>> {
        return RetrofitClient.build().addCamion(camionAddRequest)
    }

    override fun camionUpdate(
        id: Long,
        camionUpdateRequest: CamionUpdateRequest
    ): Observable<Data<Camion>> {
        return RetrofitClient.build().updateCamion(id, camionUpdateRequest)
    }

    override fun camiontGetAll(): Observable<Data<List<Camion>>> {
        return RetrofitClient.build().selectAllCamion()
    }

    override fun camionRemove(id: Long): Observable<Data<Camion>> {
        return RetrofitClient.build().removeCamion(id)
    }

}