package com.jk.koin_example.network

import com.jk.koin_example.model.PostOfficeResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface PostOfficeApi {

    @GET("/pincode/{input}")
    suspend fun getPinCodeInfo(@Path("input") input: String): MutableList<PostOfficeResponse>
}