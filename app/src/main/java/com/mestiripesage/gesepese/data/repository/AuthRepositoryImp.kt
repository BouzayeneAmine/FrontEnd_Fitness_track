package com.mestiripesage.gesepese.data.repository

import com.mestiripesage.gesepese.data.entities.Product
import com.mestiripesage.gesepese.data.entities.User
import com.mestiripesage.gesepese.data.remote.RetrofitClient
import com.mestiripesage.gesepese.data.remote.request.LoginRequest
import com.mestiripesage.gesepese.data.remote.request.ProductAddRequest
import com.mestiripesage.gesepese.data.remote.request.RegisterRequest
import com.mestiripesage.gesepese.data.remote.request.UpdateRequest
import com.mestiripesage.gesepese.data.remote.response.*
import com.mestiripesage.gesepese.domain.repository.IAuthRepository
import io.reactivex.Observable
import retrofit2.Retrofit

class AuthRepositoryImp : IAuthRepository {
    override fun login(loginRequest: LoginRequest): Observable<Data<User>> {
        return RetrofitClient.build().login((loginRequest))
    }

    override fun register(registerRequest: RegisterRequest): Observable<Data<User>>  {
        return RetrofitClient.build().register(registerRequest)
    }

    override fun remove(id: Long): Observable<Data<User>> {
        return RetrofitClient.build().remove(id)

}
    override fun update(id: Long, updateRequest: UpdateRequest): Observable<Data<User>> {
        return RetrofitClient.build().update(id,updateRequest)

    }


}