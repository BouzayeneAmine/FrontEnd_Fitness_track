package com.mestiripesage.gesepese.data.remote

import com.mestiripesage.gesepese.data.entities.*
import com.mestiripesage.gesepese.data.remote.request.camion.CamionAddRequest
import com.mestiripesage.gesepese.data.remote.request.camion.CamionUpdateRequest
import com.mestiripesage.gesepese.data.remote.request.customer.CustomerAddRequest
import com.mestiripesage.gesepese.data.remote.request.customer.CustomerUpdateRequest
import com.mestiripesage.gesepese.data.remote.request.product.ProductAddRequest
import com.mestiripesage.gesepese.data.remote.request.product.ProductUpdateRequest
import com.mestiripesage.gesepese.data.remote.request.reciept.RecieptAddRequest
import com.mestiripesage.gesepese.data.remote.request.user.LoginRequest
import com.mestiripesage.gesepese.data.remote.request.user.RegisterRequest
import com.mestiripesage.gesepese.data.remote.request.user.UpdateRequest
import com.mestiripesage.gesepese.data.remote.response.*
import com.mestiripesage.gesepese.data.remote.response.Data
import io.paperdb.Paper
import io.reactivex.Observable
import retrofit2.http.*

interface GesepeseApi {
    /// ws users
    @POST(ApiGesepese.LOGIN_USER)
    fun login(@Body loginRequest: LoginRequest): Observable<Data<UserLogin>>

    @POST(ApiGesepese.REGISTER_USER)
    fun register(@Body registerRequest: RegisterRequest): Observable<Data<User>>

    @DELETE(ApiGesepese.REMOVE_USER)
    fun remove(@Path("id") id: Long): Observable<Data<User>>

    @PUT(ApiGesepese.UPDATE_USER)
    fun update(@Path("id") id: Long, @Body updateRequest: UpdateRequest): Observable<Data<User>>

    // ws Products
    @Headers("Content-Type:application/json; charset=UTF-8")
    @POST(ApiGesepese.ADD_PRODUCT)
    fun addProduct(@Body productAddRequest: ProductAddRequest): Observable<Data<Product>>

    @Headers("Authorization: ${ApiGesepese.token}")
    @GET(ApiGesepese.ALL_PRODUCT)
    fun selectAllProduct(): Observable<Data<List<Product>>>

    @DELETE(ApiGesepese.REMOVE_PRODUCT)
    fun removeProduct(@Path("id") id: Long): Observable<Data<Product>>

    @PUT(ApiGesepese.UPDATE_PRODUCT)
    fun updateProduct(
        @Path("id") id: Long,
        @Body productUpdateRequest: ProductUpdateRequest
    ): Observable<Data<Product>>

    // ws Camions
    @POST(ApiGesepese.ADD_CAMION)
    fun addCamion(@Body camionAddRequest: CamionAddRequest): Observable<Data<Camion>>

    @GET(ApiGesepese.ALL_CAMION)
    fun selectAllCamion(): Observable<Data<List<Camion>>>

    @DELETE(ApiGesepese.REMOVE_CAMION)
    fun removeCamion(@Path("id") id: Long): Observable<Data<Camion>>

    @PUT(ApiGesepese.UPDATE_CAMION)
    fun updateCamion(
        @Path("id") id: Long,
        @Body camionUpdateRequest: CamionUpdateRequest
    ): Observable<Data<Camion>>

    // ws Customers
    @POST(ApiGesepese.ADD_CUSTOMER)
    fun addCustomer(@Body customerAddRequest: CustomerAddRequest): Observable<Data<Customer>>

    @GET(ApiGesepese.ALL_CUSTOMER)
    fun selectAllCustomer(): Observable<Data<List<Customer>>>

    @DELETE(ApiGesepese.REMOVE_CUSTOMER)
    fun removeCustomer(@Path("id") id: Long): Observable<Data<Customer>>

    @PUT(ApiGesepese.UPDATE_CUSTOMER)
    fun updateCustomer(
        @Path("id") id: Long,
        @Body customerUpdateRequest: CustomerUpdateRequest
    ): Observable<Data<Customer>>

    // ws Reciepts
    @POST(ApiGesepese.ADD_RECIEPT)
    fun addReciept(@Body recieptAddRequest: RecieptAddRequest): Observable<Data<Receipt>>

    @GET(ApiGesepese.ALL_RECIEPT)
    fun selectAllReciept(): Observable<Data<List<Receipt>>>

    @DELETE(ApiGesepese.REMOVE_RECIEPT)
    fun removeReciept(@Path("id") id: Long): Observable<Data<Receipt>>



}