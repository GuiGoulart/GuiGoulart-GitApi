package com.challenge.magalu.data.server

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitApi {

    companion object {
        var retrofit: Retrofit? = null
        private const val baseUrl = "https://api.github.com/"
        private val client = OkHttpClient.Builder()
            .addInterceptor { chain: Interceptor.Chain ->
                val newRequest = chain.request().newBuilder()
                        .addHeader(
                            "Authorization",
                            "Bearer " + "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"
                        )
                        .build()

                val resp = chain.proceed(newRequest)
                resp
            }.readTimeout(1, TimeUnit.MINUTES).build()
        val retrofitInstance: Retrofit?
            get() {
                if (retrofit == null) {
                    retrofit = Retrofit.Builder()
                        .baseUrl(baseUrl)
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .client(client)
                        .build()
                }
                return retrofit
            }
    }
}