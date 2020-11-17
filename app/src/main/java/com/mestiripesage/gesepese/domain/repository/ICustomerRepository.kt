package com.mestiripesage.gesepese.domain.repository

import com.mestiripesage.gesepese.data.entities.Camion
import com.mestiripesage.gesepese.data.entities.Customer
import com.mestiripesage.gesepese.data.remote.request.camion.CamionAddRequest
import com.mestiripesage.gesepese.data.remote.request.customer.CustomerAddRequest
import com.mestiripesage.gesepese.data.remote.request.customer.CustomerUpdateRequest
import com.mestiripesage.gesepese.data.remote.response.Data
import io.reactivex.Observable


interface ICustomerRepository {
    fun customerAdd(customerAddRequest: CustomerAddRequest): Observable<Data<Customer>>
    fun customerUpdate(
        id: Long,
        customerUpdateRequest: CustomerUpdateRequest
    ): Observable<Data<Customer>>

    fun customerRemove(id: Long): Observable<Data<Customer>>
    fun customerGetAll(): Observable<Data<List<Customer>>>
}