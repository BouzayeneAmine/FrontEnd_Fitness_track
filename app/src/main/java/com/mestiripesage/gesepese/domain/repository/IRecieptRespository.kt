package com.mestiripesage.gesepese.domain.repository

import com.mestiripesage.gesepese.data.entities.Product
import com.mestiripesage.gesepese.data.entities.Receipt
import com.mestiripesage.gesepese.data.remote.request.product.ProductAddRequest
import com.mestiripesage.gesepese.data.remote.request.product.ProductUpdateRequest
import com.mestiripesage.gesepese.data.remote.request.reciept.RecieptAddRequest
import com.mestiripesage.gesepese.data.remote.response.Data
import io.reactivex.Observable

interface IRecieptRespository {
    fun recieptAdd( recieptAddRequest: RecieptAddRequest): Observable<Data<Receipt>>
    fun recieptGetAll(): Observable<Data<List<Receipt>>>
    fun recieptRemove(id: Long): Observable<Data<Receipt>>
}