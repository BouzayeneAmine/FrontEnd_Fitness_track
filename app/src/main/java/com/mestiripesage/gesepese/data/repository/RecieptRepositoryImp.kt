package com.mestiripesage.gesepese.data.repository

import com.mestiripesage.gesepese.data.entities.Receipt
import com.mestiripesage.gesepese.data.remote.RetrofitClient
import com.mestiripesage.gesepese.data.remote.request.reciept.RecieptAddRequest
import com.mestiripesage.gesepese.data.remote.response.Data
import com.mestiripesage.gesepese.domain.repository.IRecieptRespository
import io.reactivex.Observable

class RecieptRepositoryImp:IRecieptRespository {
    override fun recieptAdd(recieptAddRequest: RecieptAddRequest): Observable<Data<Receipt>> {
        return RetrofitClient.build().addReciept(recieptAddRequest)
    }

    override fun recieptGetAll(): Observable<Data<List<Receipt>>> {
   return RetrofitClient.build().selectAllReciept()
    }

    override fun recieptRemove(id: Long): Observable<Data<Receipt>> {
        return RetrofitClient.build().removeReciept(id)
    }
}