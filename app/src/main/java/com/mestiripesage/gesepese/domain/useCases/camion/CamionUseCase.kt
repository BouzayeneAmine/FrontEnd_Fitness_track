package com.mestiripesage.gesepese.domain.useCases.camion

import com.mestiripesage.gesepese.data.entities.Camion
import com.mestiripesage.gesepese.data.entities.Product
import com.mestiripesage.gesepese.data.remote.request.camion.CamionAddRequest
import com.mestiripesage.gesepese.data.remote.request.product.ProductAddRequest
import com.mestiripesage.gesepese.data.remote.response.Data
import com.mestiripesage.gesepese.data.repository.CamionRepositoryImp
import com.mestiripesage.gesepese.data.repository.ProductRepositoryImp
import com.mestiripesage.gesepese.domain.repository.ICamionRepository
import com.mestiripesage.gesepese.domain.repository.ICustomerRepository
import com.mestiripesage.gesepese.domain.repository.IProductRepository
import io.reactivex.Observable

class CamionUseCase {
    private  val camionRepository : ICamionRepository = CamionRepositoryImp()
    sealed class Result {
        object  Loading : Result()
        data class Success (val userResponse: Data<Camion>) :
            Result()
        data class Failure (val throwable: Throwable) : Result()

    }
    fun execute(camionAddRequest: CamionAddRequest): Observable<Result> {
        return camionRepository.camionAdd(camionAddRequest)
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
