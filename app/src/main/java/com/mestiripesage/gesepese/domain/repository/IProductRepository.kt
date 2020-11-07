package com.mestiripesage.gesepese.domain.repository

import com.mestiripesage.gesepese.data.entities.Product
import com.mestiripesage.gesepese.data.remote.request.ProductAddRequest
import com.mestiripesage.gesepese.data.remote.response.Data
import io.reactivex.Observable

interface IProductRepository {
    fun productAdd( productAddRequest: ProductAddRequest): Observable<Data<Product>>
    fun productGetAll(): Observable<Data<List<Product>>>
}