package com.mestiripesage.gesepese.domain.repository

import com.mestiripesage.gesepese.data.entities.User
import com.mestiripesage.gesepese.data.remote.request.user.LoginRequest
import com.mestiripesage.gesepese.data.remote.request.user.RegisterRequest
import com.mestiripesage.gesepese.data.remote.request.user.UpdateRequest
import com.mestiripesage.gesepese.data.remote.response.*
import io.reactivex.Observable

interface IAuthRepository {
    fun login(loginRequest: LoginRequest): Observable<Data<User>>
    fun register(registerRequest: RegisterRequest): Observable<Data<User>>
    fun remove(id: Long): Observable<Data<User>>
    fun update(id: Long , updateRequest: UpdateRequest): Observable<Data<User>>


}