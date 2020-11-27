package com.mestiripesage.gesepese.data.remote

import android.icu.util.TimeUnit
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

class ApiGesepese {

    companion object {
        const val Base_URL = "http://192.168.1.11:3000"
        // User
        const val LOGIN_USER = "/users/login"
        const val REGISTER_USER = "/users/register"
        const val REMOVE_USER = "/users/remove/{id}"
        const val UPDATE_USER = "/users/update"

        // Product
        const val ADD_PRODUCT = "/products/add"
        const val ALL_PRODUCT = "/products/all"
        const val REMOVE_PRODUCT = "/products/remove/{id}"
        const val UPDATE_PRODUCT = "/products/update"

        // Camion
        const val ADD_CAMION = "/camions/add"
        const val ALL_CAMION = "/camions/all"
        const val REMOVE_CAMION = "/camions/remove/{id}"
        const val UPDATE_CAMION = "/camions/update"

        // Customers
        const val ADD_CUSTOMER = "/customers/add"
        const val ALL_CUSTOMER = "/customers/all"
        const val REMOVE_CUSTOMER = "/customers/remove/{id}"
        const val UPDATE_CUSTOMER = "/customers/update"

        // Reciept
        const val ADD_RECIEPT = "/reciepts/add"
        const val ALL_RECIEPT = "/reciepts/all"
        const val REMOVE_RECIEPT = "/reciept/remove/{id}"
        const val UPDATE_RECIEPT = "/reciept/update"
        const val token = ""

///interceptor
        /*   fun getUnsafeOkHttpClient(): OkHttpClient {
       val interceptor = HttpLoggingInterceptor()
       interceptor.level = HttpLoggingInterceptor.Level.HEADERS
       interceptor.level = HttpLoggingInterceptor.Level.BODY
       val builder = OkHttpClient.Builder()
       builder.addInterceptor(interceptor)
           .connectTimeout(20, java.util.concurrent.TimeUnit.SECONDS)
           .readTimeout(20, java.util.concurrent.TimeUnit.SECONDS)
           .addInterceptor(SupportInterceptor())
           .authenticator(SupportInterceptor())
       return builder.build()
   }*/
    }
}