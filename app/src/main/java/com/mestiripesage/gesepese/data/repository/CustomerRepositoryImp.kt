package com.mestiripesage.gesepese.data.repository

import com.mestiripesage.gesepese.data.entities.Customer
import com.mestiripesage.gesepese.data.remote.RetrofitClient
import com.mestiripesage.gesepese.data.remote.request.customer.CustomerAddRequest
import com.mestiripesage.gesepese.data.remote.request.customer.CustomerUpdateRequest
import com.mestiripesage.gesepese.data.remote.response.Data
import com.mestiripesage.gesepese.domain.repository.ICustomerRepository
import io.reactivex.Observable

class CustomerRepositoryImp :ICustomerRepository {
    override fun customerAdd(customerAddRequest: CustomerAddRequest): Observable<Data<Customer>> {
        return RetrofitClient.build().addCustomer(customerAddRequest)
    }

    override fun customerUpdate(
        id: Long,
        customerUpdateRequest: CustomerUpdateRequest
    ): Observable<Data<Customer>> {
        return RetrofitClient.build().updateCustomer(id,customerUpdateRequest)
    }

    override fun customerRemove(id: Long): Observable<Data<Customer>> {
        return RetrofitClient.build().removeCustomer(id)
    }

    override fun customerGetAll(): Observable<Data<List<Customer>>> {
        return RetrofitClient.build().selectAllCustomer()
    }
}