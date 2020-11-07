package com.mestiripesage.gesepese.data.repository

import com.mestiripesage.gesepese.data.entities.Product
import com.mestiripesage.gesepese.data.remote.RetrofitClient
import com.mestiripesage.gesepese.data.remote.request.ProductAddRequest
import com.mestiripesage.gesepese.data.remote.response.Data
import com.mestiripesage.gesepese.domain.repository.IProductRepository
import io.reactivex.Observable

class ProductRepositoryImp : IProductRepository {

    override fun productAdd(productAddRequest: ProductAddRequest): Observable<Data<Product>>  {
        return RetrofitClient.build().addProduct(productAddRequest)
    }

    override fun productGetAll(): Observable<Data<List<Product>>> {

        return RetrofitClient.build().selectAllProduct()
    }

}