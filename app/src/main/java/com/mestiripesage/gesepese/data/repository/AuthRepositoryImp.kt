package com.mestiripesage.gesepese.data.repository

import com.mestiripesage.gesepese.data.entities.User
import com.mestiripesage.gesepese.data.remote.RetrofitClient
import com.mestiripesage.gesepese.data.remote.request.user.LoginRequest
import com.mestiripesage.gesepese.data.remote.request.user.RegisterRequest
import com.mestiripesage.gesepese.data.remote.request.user.UpdateRequest
import com.mestiripesage.gesepese.data.remote.response.*
import com.mestiripesage.gesepese.domain.repository.IAuthRepository
import io.reactivex.Observable

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