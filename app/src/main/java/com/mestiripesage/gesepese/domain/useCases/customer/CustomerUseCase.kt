package com.mestiripesage.gesepese.domain.useCases.customer

import com.mestiripesage.gesepese.data.entities.Camion
import com.mestiripesage.gesepese.data.entities.Customer
import com.mestiripesage.gesepese.data.remote.request.camion.CamionAddRequest
import com.mestiripesage.gesepese.data.remote.request.customer.CustomerAddRequest
import com.mestiripesage.gesepese.data.remote.response.Data
import com.mestiripesage.gesepese.data.repository.CamionRepositoryImp
import com.mestiripesage.gesepese.data.repository.CustomerRepositoryImp
import com.mestiripesage.gesepese.domain.repository.ICamionRepository
import com.mestiripesage.gesepese.domain.repository.ICustomerRepository
import io.reactivex.Observable

class CustomerUseCase {  private  val customerRepository : ICustomerRepository = CustomerRepositoryImp()
    sealed class Result {
        object  Loading : Result()
        data class Success (val userResponse: Data<Customer>) :
            Result()
        data class Failure (val throwable: Throwable) : Result()

    }
    fun execute(customerAddRequest: CustomerAddRequest): Observable<Result> {
        return customerRepository.customerAdd(customerAddRequest)
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
