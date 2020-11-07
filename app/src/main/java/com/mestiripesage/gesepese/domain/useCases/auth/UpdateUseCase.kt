package com.mestiripesage.gesepese.domain.useCases.auth

import com.mestiripesage.gesepese.data.entities.User
import com.mestiripesage.gesepese.data.remote.request.LoginRequest
import com.mestiripesage.gesepese.data.remote.request.UpdateRequest
import com.mestiripesage.gesepese.data.remote.response.Data
import com.mestiripesage.gesepese.data.repository.AuthRepositoryImp
import com.mestiripesage.gesepese.domain.repository.IAuthRepository
import io.reactivex.Observable
class UpdateUseCase {
    private  val authRepository : IAuthRepository = AuthRepositoryImp()
    sealed class Result {
        object  Loading : Result()
        data class Success (val userResponse: Data<User>) :
            Result()
        data class Failure (val throwable: Throwable) : Result()

    }
    fun execute(id: Long,updateRequest: UpdateRequest): Observable<Result> {
        return authRepository.update(id,updateRequest )
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