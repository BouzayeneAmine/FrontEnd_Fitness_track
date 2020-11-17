package com.mestiripesage.gesepese.data.repository

import com.mestiripesage.gesepese.data.entities.Product
import com.mestiripesage.gesepese.data.remote.RetrofitClient
import com.mestiripesage.gesepese.data.remote.request.product.ProductAddRequest
import com.mestiripesage.gesepese.data.remote.request.product.ProductUpdateRequest
import com.mestiripesage.gesepese.data.remote.response.Data
import com.mestiripesage.gesepese.domain.repository.IProductRepository
import io.reactivex.Observable

class ProductRepositoryImp : IProductRepository {

    override fun productAdd(productAddRequest: ProductAddRequest): Observable<Data<Product>>  {
        return RetrofitClient.build().addProduct(productAddRequest)
    }

    override fun productUpdate(
        id: Long,
        productUpdateRequest: ProductUpdateRequest
    ): Observable<Data<Product>> {
        return RetrofitClient.build().updateProduct(id,productUpdateRequest)
    }

    override fun productGetAll(): Observable<Data<List<Product>>> {

        return RetrofitClient.build().selectAllProduct()
    }

    override fun productRemove(id: Long): Observable<Data<Product>> {
       return  RetrofitClient.build().removeProduct(id)
    }

}