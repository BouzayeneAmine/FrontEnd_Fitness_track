package com.mestiripesage.gesepese.domain.repository

import com.mestiripesage.gesepese.data.entities.Product
import com.mestiripesage.gesepese.data.remote.request.product.ProductAddRequest
import com.mestiripesage.gesepese.data.remote.request.product.ProductUpdateRequest
import com.mestiripesage.gesepese.data.remote.response.Data
import io.reactivex.Observable

interface IProductRepository {
    fun productAdd( productAddRequest: ProductAddRequest): Observable<Data<Product>>
    fun productUpdate(id:Long, productUpdateRequest: ProductUpdateRequest): Observable<Data<Product>>
    fun productGetAll(): Observable<Data<List<Product>>>
    fun productRemove(id: Long): Observable<Data<Product>>

}