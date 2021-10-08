package com.challenge.magalu.data.server

import com.challenge.magalu.data.server.RetrofitApi.Companion.retrofit
import com.challenge.magalu.data.server.RetrofitApi.Companion.retrofitInstance

class ApiRequest {

    val services: Endpoint?
        get() = retrofit?.create(Endpoint::class.java)

    init {
        retrofitInstance
    }
}