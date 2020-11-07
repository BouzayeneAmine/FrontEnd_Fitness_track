package com.mestiripesage.gesepese.domain.repository

import com.mestiripesage.gesepese.data.entities.Product
import com.mestiripesage.gesepese.data.entities.User
import com.mestiripesage.gesepese.data.remote.request.LoginRequest
import com.mestiripesage.gesepese.data.remote.request.ProductAddRequest
import com.mestiripesage.gesepese.data.remote.request.RegisterRequest
import com.mestiripesage.gesepese.data.remote.request.UpdateRequest
import com.mestiripesage.gesepese.data.remote.response.*
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.Path
import java.util.*

interface IAuthRepository {
    fun login(loginRequest: LoginRequest): Observable<Data<User>>
    fun register(registerRequest: RegisterRequest): Observable<Data<User>>
    fun remove(id: Long): Observable<Data<User>>
    fun update(id: Long, updateRequest: UpdateRequest): Observable<Data<User>>






}