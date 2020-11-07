package com.mestiripesage.gesepese.data.remote


import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {
    private var retrofit: Retrofit? = null
    private var client: OkHttpClient? = null
    fun build(): GesepeseApi {
        if (retrofit == null) {
            if (client == null)
                client = OkHttpClient.Builder()
                    .connectTimeout(100, TimeUnit.SECONDS)
                    .readTimeout(100, TimeUnit.SECONDS)
                    .writeTimeout(100, TimeUnit.SECONDS)

                    .build()

            retrofit = Retrofit.Builder()
                .client(client)
                //  .addConverterFactory(NullOnEmptyConverterFactory())
                .baseUrl(ApiGesepese.Base_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        }
        return retrofit!!.create(GesepeseApi::class.java)
    }
}
