package com.mestiripesage.gesepese.domain.repository

import com.mestiripesage.gesepese.data.entities.Camion
import com.mestiripesage.gesepese.data.remote.request.camion.CamionAddRequest
import com.mestiripesage.gesepese.data.remote.request.camion.CamionUpdateRequest
import com.mestiripesage.gesepese.data.remote.response.Data
import io.reactivex.Observable


interface ICamionRepository {
    fun camionAdd(camionAddRequest: CamionAddRequest): Observable<Data<Camion>>
    fun camionUpdate(id: Long, camionUpdateRequest: CamionUpdateRequest): Observable<Data<Camion>>
    fun camiontGetAll(): Observable<Data<List<Camion>>>
    fun camionRemove(id: Long): Observable<Data<Camion>>
}