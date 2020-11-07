package com.mestiripesage.gesepese.domain.useCases.auth

import com.mestiripesage.gesepese.data.entities.User
import com.mestiripesage.gesepese.data.remote.request.LoginRequest
import com.mestiripesage.gesepese.data.remote.response.Data
import com.mestiripesage.gesepese.data.repository.AuthRepositoryImp
import com.mestiripesage.gesepese.domain.repository.IAuthRepository
import io.reactivex.Observable

class LoginUseCase {
    private  val authRepository : IAuthRepository = AuthRepositoryImp()
    sealed class Result {
        object  Loading : Result()
        data class Success (val userResponse: Data<User> ) :
            Result()
        data class Failure (val throwable: Throwable) : Result()

    }
    fun execute(loginRequest: LoginRequest):Observable<Result> {
        return authRepository.login(loginRequest)
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