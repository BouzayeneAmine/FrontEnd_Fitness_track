package com.mestiripesage.gesepese.data.remote

import com.mestiripesage.gesepese.data.entities.Product
import com.mestiripesage.gesepese.data.entities.User
import com.mestiripesage.gesepese.data.remote.request.*
import com.mestiripesage.gesepese.data.remote.response.*
import io.reactivex.Observable
import retrofit2.http.*

interface GesepeseApi {
    /// ws users
    @POST(ApiGesepese.LOGIN_USER)
    fun login(@Body loginRequest: LoginRequest): Observable<Data<User>>
    @POST(ApiGesepese.REGISTER_USER)
    fun register(@Body registerRequest: RegisterRequest): Observable<Data<User>>
    @DELETE(ApiGesepese.REMOVE_USER)
    fun remove(@Path("id") id: Long): Observable<Data<User>>
    @PUT(ApiGesepese.UPDATE_USER)
    fun update(@Path ("id") id :Long,@Body updateRequest: UpdateRequest): Observable<Data<User>>
    // ws product
    @POST(ApiGesepese.ADD_PRODUCT)
    fun addProduct (@Body productAddRequest: ProductAddRequest): Observable<Data<Product>>
    @POST(ApiGesepese.ALL_PRODUCT)
    fun selectAllProduct(): Observable<Data<List<Product>>>
    @DELETE(ApiGesepese.REMOVE_PRODUCT)
    fun removeProduct(@Path("id") id: Long): Observable<Data<Product>>
    @PUT(ApiGesepese.UPDATE_PRODUCT)
    fun updateProduct(@Path ("id") id :Long,@Body updateProductRequest: UpdateProductRequest): Observable<Data<Product>>

}