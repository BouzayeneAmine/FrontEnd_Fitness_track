package com.mestiripesage.gesepese.domain.useCases.product

import com.mestiripesage.gesepese.data.entities.Product
import com.mestiripesage.gesepese.data.remote.request.ProductAddRequest
import com.mestiripesage.gesepese.data.remote.response.Data
import com.mestiripesage.gesepese.data.repository.AuthRepositoryImp
import com.mestiripesage.gesepese.data.repository.ProductRepositoryImp
import com.mestiripesage.gesepese.domain.repository.IAuthRepository
import com.mestiripesage.gesepese.domain.repository.IProductRepository
import io.reactivex.Observable

class addProductUseCase {
    private  val productRepository : IProductRepository = ProductRepositoryImp()
    sealed class Result {
        object  Loading : Result()
        data class Success (val userResponse: Data<Product>) :
            Result()
        data class Failure (val throwable: Throwable) : Result()

    }
    fun execute(productAddRequest: ProductAddRequest): Observable<Result> {
        return productRepository.productAdd(productAddRequest)
            .doOnNext{
                Result.Success(
                    it
                )
            }
            .map { Result.Success(
                it
            ) as Result
            }
            .onErrorReturn{
                Result.Failure(
                    it
                )
            }
            .startWith(Result.Loading)


    }
}
