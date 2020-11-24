package com.mestiripesage.gesepese.domain.useCases.customer

import com.mestiripesage.gesepese.data.entities.Customer
import com.mestiripesage.gesepese.data.entities.Product
import com.mestiripesage.gesepese.data.remote.response.Data
import com.mestiripesage.gesepese.data.repository.CustomerRepositoryImp
import com.mestiripesage.gesepese.data.repository.ProductRepositoryImp
import com.mestiripesage.gesepese.domain.repository.ICustomerRepository
import com.mestiripesage.gesepese.domain.repository.IProductRepository
import io.reactivex.Observable

class ListCustomerUseCase {
    private val customerRepository: ICustomerRepository = CustomerRepositoryImp()

    sealed class Result {
        object Loading : Result()
        data class Success(val userResponse: Data<List<Customer>>) :
            Result()

        data class Failure(val throwable: Throwable) : Result()

    }

    fun execute(): Observable<Result> {
        return customerRepository.customerGetAll()
            .doOnNext {
                Result.Success(
                    it
                )
            }
            .map {
                Result.Success(
                    it
                ) as Result
            }
            .onErrorReturn {
                Result.Failure(
                    it
                )
            }
            .startWith(Result.Loading)


    }
}